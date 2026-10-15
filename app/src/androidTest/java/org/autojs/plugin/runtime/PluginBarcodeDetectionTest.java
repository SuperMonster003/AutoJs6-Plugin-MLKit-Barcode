package org.autojs.plugin.runtime;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.test.platform.app.InstrumentationRegistry;
import org.autojs.plugin.mlkit.barcode.api.BarcodeFormats;
import org.autojs.plugin.mlkit.barcode.api.BarcodeOptions;
import org.autojs.plugin.mlkit.barcode.api.BarcodeResult;
import org.autojs.plugin.mlkit.barcode.api.BarcodeResultExtraKeys;
import org.autojs.plugin.mlkit.barcode.api.BarcodeValueTypes;
import org.autojs.plugin.mlkit.barcode.api.IBarcodePlugin;
import org.json.JSONObject;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.Assert.*;

/**
 * Scans a real QR code through the AIDL proxy. The fixture is a 444 x 444 PNG whose payload is
 * {@link #FIXTURE_VALUE}. A plugin whose ML Kit components never registered (for example when R8
 * strips the ComponentRegistrar constructors) fails here with a NullPointerException instead of
 * returning the decoded value, so run this against the installed release APK as well.
 */
public class PluginBarcodeDetectionTest {
    private static final String FIXTURE_ASSET = "qr_url.png";
    private static final String FIXTURE_VALUE = "https://example.com/autojs6/mlkit-barcode";
    private static final int FIXTURE_SIZE = 444;

    @Test(timeout = 180000) public void detectsQrCodeThroughFileAndPipeDescriptors() throws Exception {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent discovery = new Intent("org.autojs.plugin.MLKIT_BARCODE").addCategory("mlkit-barcode").setPackage(context.getPackageName());
        List<ResolveInfo> services = context.getPackageManager().queryIntentServices(discovery, 0);
        assertEquals(1, services.size());
        ServiceInfo service = services.get(0).serviceInfo;
        ArrayBlockingQueue<IBinder> connectionResult = new ArrayBlockingQueue<>(1);
        ServiceConnection connection = new ServiceConnection() {
            @Override public void onServiceConnected(ComponentName name, IBinder binder) { connectionResult.add(binder); }
            @Override public void onServiceDisconnected(ComponentName name) {}
        };
        assertTrue(context.bindService(new Intent().setComponent(new ComponentName(service.packageName, service.name)), connection, Context.BIND_AUTO_CREATE));
        File image = File.createTempFile("binder-qr-", ".png", context.getCacheDir());
        try {
            IBinder binder = connectionResult.poll(30, TimeUnit.SECONDS);
            assertNotNull(binder);
            // Force the generated proxy even when instrumentation shares the service process.
            Binder transport = new Binder() {
                @Override protected boolean onTransact(int code, Parcel input, Parcel output, int flags) throws RemoteException {
                    return binder.transact(code, input, output, flags);
                }
            };
            IBarcodePlugin plugin = IBarcodePlugin.Stub.asInterface(transport);
            try (InputStream source = InstrumentationRegistry.getInstrumentation().getContext().getAssets().open(FIXTURE_ASSET);
                 OutputStream target = new FileOutputStream(image)) {
                copy(source, target);
            }

            BarcodeOptions anyFormat = new BarcodeOptions();
            try (ParcelFileDescriptor fd = ParcelFileDescriptor.open(image, ParcelFileDescriptor.MODE_READ_ONLY)) {
                List<BarcodeResult> results = plugin.detect(fd, anyFormat);
                assertEquals(String.valueOf(results), 1, results.size());
                assertQrFixture(results.get(0));
            }

            BarcodeOptions qrOnly = new BarcodeOptions();
            qrOnly.formats = new int[] { BarcodeFormats.FORMAT_QR_CODE };
            qrOnly.maxResults = 1;
            ParcelFileDescriptor[] pipe = ParcelFileDescriptor.createPipe();
            AtomicReference<Throwable> pipeFailure = new AtomicReference<>();
            Thread writer = new Thread(() -> {
                try (InputStream source = new FileInputStream(image);
                     OutputStream target = new ParcelFileDescriptor.AutoCloseOutputStream(pipe[1])) {
                    copy(source, target);
                } catch (Throwable error) { pipeFailure.set(error); }
            }, "binder-qr-pipe");
            writer.setDaemon(true);
            writer.start();
            try (ParcelFileDescriptor fd = pipe[0]) {
                List<BarcodeResult> results = plugin.detect(fd, qrOnly);
                assertEquals(String.valueOf(results), 1, results.size());
                assertQrFixture(results.get(0));
            }
            writer.join(10000);
            assertFalse("Image pipe writer leaked", writer.isAlive());
            assertNull(pipeFailure.get());

            BarcodeOptions otherFormat = new BarcodeOptions();
            otherFormat.formats = new int[] { BarcodeFormats.FORMAT_EAN_13 };
            try (ParcelFileDescriptor fd = ParcelFileDescriptor.open(image, ParcelFileDescriptor.MODE_READ_ONLY)) {
                assertTrue(plugin.detect(fd, otherFormat).isEmpty());
            }
        } finally {
            assertTrue(image.delete() || !image.exists());
            context.unbindService(connection);
        }
    }

    private static void copy(InputStream source, OutputStream target) throws java.io.IOException {
        byte[] bytes = new byte[8192];
        int count;
        while ((count = source.read(bytes)) != -1) target.write(bytes, 0, count);
    }

    private static void assertQrFixture(BarcodeResult result) throws Exception {
        assertEquals(FIXTURE_VALUE, result.rawValue);
        assertEquals(FIXTURE_VALUE, result.displayValue);
        assertNotNull(result.rawBytes);
        assertEquals(BarcodeFormats.FORMAT_QR_CODE, result.format);
        assertEquals("QR_CODE", result.formatName);
        assertEquals(BarcodeValueTypes.TYPE_URL, result.valueType);
        assertEquals("URL", result.valueTypeName);
        assertNotNull(result.boundingBox);
        String box = String.valueOf(result.boundingBox);
        assertTrue(box, result.boundingBox.width() > 0 && result.boundingBox.height() > 0);
        assertTrue(box, result.boundingBox.left >= 0 && result.boundingBox.top >= 0);
        assertTrue(box, result.boundingBox.right <= FIXTURE_SIZE && result.boundingBox.bottom <= FIXTURE_SIZE);
        assertNotNull(result.cornerPoints);
        assertEquals(8, result.cornerPoints.length);
        assertNotNull(result.extras);
        JSONObject structured = new JSONObject(result.extras.getString(BarcodeResultExtraKeys.STRUCTURED_JSON));
        assertEquals("url", structured.getString("payloadType"));
        assertEquals(FIXTURE_VALUE, structured.getJSONObject("url").getString("url"));
    }
}
