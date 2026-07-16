package io.github.supermonster003.autojs6.plugin.mlkit.barcode

import android.app.Service
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.os.IBinder
import android.os.ParcelFileDescriptor
import com.google.android.gms.tasks.Tasks
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import org.autojs.plugin.common.api.PluginCapabilityKeys
import org.autojs.plugin.common.api.PluginInfo
import org.autojs.plugin.mlkit.barcode.api.BarcodeFormats
import org.autojs.plugin.mlkit.barcode.api.BarcodeOptions
import org.autojs.plugin.mlkit.barcode.api.BarcodePluginCapabilityKeys
import org.autojs.plugin.mlkit.barcode.api.BarcodeResult
import org.autojs.plugin.mlkit.barcode.api.BarcodeResultExtraKeys
import org.autojs.plugin.mlkit.barcode.api.BarcodeValueTypes
import org.autojs.plugin.mlkit.barcode.api.IBarcodePlugin
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.TimeUnit
import com.google.mlkit.vision.barcode.common.Barcode as MLKitBarcode

class MlKitBarcodePluginService : Service() {

    private val scanLock = Any()

    override fun onBind(intent: Intent?): IBinder = binder

    private val binder = object : IBarcodePlugin.Stub() {
        override fun getInfo(): PluginInfo {
            return PluginInfo().apply {
                name = getString(R.string.app_name)
                description = getString(R.string.plugin_description)
                author = getString(R.string.plugin_author)
                id = BuildConfig.PLUGIN_ID
                engine = BuildConfig.PLUGIN_ENGINE
                variant = BuildConfig.PLUGIN_VARIANT
                versionName = BuildConfig.VERSION_NAME
                versionCode = BuildConfig.VERSION_CODE.toLong()
                versionDate = BuildConfig.VERSION_DATE
                supportedAbis = SUPPORTED_ABIS
                capabilities = Bundle().apply {
                    putInt(PluginCapabilityKeys.REQUIRES_HOST_VERSION, 3923)
                    putInt(BarcodePluginCapabilityKeys.CONTRACT_VERSION, 1)
                    putBoolean(BarcodePluginCapabilityKeys.SUPPORTS_STRUCTURED_PAYLOAD_JSON, true)
                    putBoolean(BarcodePluginCapabilityKeys.SUPPORTS_ALL_POTENTIAL_BARCODES, true)
                }
            }
        }

        override fun detect(
            imageFd: ParcelFileDescriptor,
            options: BarcodeOptions,
        ): MutableList<BarcodeResult> {
            synchronized(scanLock) {
                val bitmap = ImageFdDecoder.decode(imageFd)
                val scanner = BarcodeScanning.getClient(options.toScannerOptions())
                try {
                    val inputImage = InputImage.fromBitmap(bitmap, 0)
                    val barcodes = Tasks.await(scanner.process(inputImage), SCAN_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    return barcodes
                        .take(options.effectiveMaxResults())
                        .map { it.toAutoJsResult() }
                        .toMutableList()
                } finally {
                    scanner.close()
                    if (!bitmap.isRecycled) {
                        bitmap.recycle()
                    }
                }
            }
        }
    }

    private fun BarcodeOptions.toScannerOptions(): BarcodeScannerOptions {
        val builder = BarcodeScannerOptions.Builder()
        val effectiveFormats = formats
            ?.filter { it != BarcodeFormats.FORMAT_UNKNOWN }
            ?.distinct()
            .orEmpty()

        if (effectiveFormats.isEmpty() || effectiveFormats.contains(BarcodeFormats.FORMAT_ALL_FORMATS)) {
            builder.setBarcodeFormats(MLKitBarcode.FORMAT_ALL_FORMATS)
        } else {
            builder.setBarcodeFormats(effectiveFormats.first(), *effectiveFormats.drop(1).toIntArray())
        }

        if (enableAllPotentialBarcodes) {
            builder.enableAllPotentialBarcodes()
        }

        return builder.build()
    }

    private fun BarcodeOptions.effectiveMaxResults(): Int {
        return maxResults.takeIf { it > 0 }?.coerceAtMost(MAX_RESULTS) ?: MAX_RESULTS
    }

    private fun MLKitBarcode.toAutoJsResult(): BarcodeResult {
        return BarcodeResult().apply {
            rawValue = this@toAutoJsResult.rawValue
            displayValue = this@toAutoJsResult.displayValue
            rawBytes = this@toAutoJsResult.rawBytes
            format = this@toAutoJsResult.format
            formatName = BarcodeFormats.NAME_BY_VALUE[this@toAutoJsResult.format]
                ?: BarcodeFormats.FORMAT_NAME_UNKNOWN
            valueType = this@toAutoJsResult.valueType
            valueTypeName = BarcodeValueTypes.NAME_BY_VALUE[this@toAutoJsResult.valueType]
                ?: BarcodeValueTypes.TYPE_NAME_UNKNOWN
            boundingBox = this@toAutoJsResult.boundingBox?.let { Rect(it) }
            cornerPoints = this@toAutoJsResult.cornerPoints
                ?.flatMap { point -> listOf(point.x, point.y) }
                ?.toIntArray()
            extras = structuredPayloadJson()?.let { structured ->
                Bundle().apply {
                    putString(BarcodeResultExtraKeys.STRUCTURED_JSON, structured.toString())
                }
            }
        }
    }

    private fun MLKitBarcode.structuredPayloadJson(): JSONObject? = when (valueType) {
        MLKitBarcode.TYPE_EMAIL -> email?.let { payload("email").put("email", it.toJsonObject()) }
        MLKitBarcode.TYPE_PHONE -> phone?.let { payload("phone").put("phone", it.toJsonObject()) }
        MLKitBarcode.TYPE_SMS -> sms?.let {
            payload("sms").put(
                "sms",
                JSONObject()
                    .putNullableString("message", it.message)
                    .putNullableString("phoneNumber", it.phoneNumber),
            )
        }
        MLKitBarcode.TYPE_URL -> url?.let {
            payload("url").put(
                "url",
                JSONObject()
                    .putNullableString("title", it.title)
                    .putNullableString("url", it.url),
            )
        }
        MLKitBarcode.TYPE_WIFI -> wifi?.let {
            payload("wifi").put(
                "wifi",
                JSONObject()
                    .putNullableString("ssid", it.ssid)
                    .putNullableString("password", it.password)
                    .put("encryptionType", it.encryptionType),
            )
        }
        MLKitBarcode.TYPE_GEO -> geoPoint?.let {
            payload("geoPoint").put(
                "geoPoint",
                JSONObject()
                    .put("lat", it.lat)
                    .put("lng", it.lng),
            )
        }
        MLKitBarcode.TYPE_CONTACT_INFO -> contactInfo?.let {
            payload("contactInfo").put("contactInfo", it.toJsonObject())
        }
        MLKitBarcode.TYPE_CALENDAR_EVENT -> calendarEvent?.let {
            payload("calendarEvent").put("calendarEvent", it.toJsonObject())
        }
        MLKitBarcode.TYPE_DRIVER_LICENSE -> driverLicense?.let {
            payload("driverLicense").put("driverLicense", it.toJsonObject())
        }
        else -> null
    }

    private fun MLKitBarcode.Email.toJsonObject(): JSONObject = JSONObject()
        .putNullableString("address", address)
        .putNullableString("subject", subject)
        .putNullableString("body", body)
        .put("type", type)

    private fun MLKitBarcode.Phone.toJsonObject(): JSONObject = JSONObject()
        .putNullableString("number", number)
        .put("type", type)

    private fun MLKitBarcode.ContactInfo.toJsonObject(): JSONObject = JSONObject()
        .putNullableString("organization", organization)
        .putNullableString("title", title)
        .putNullableString("name", name?.formattedName)
        .put("phones", JSONArray().apply { phones.orEmpty().take(16).forEach { put(it.toJsonObject()) } })
        .put("emails", JSONArray().apply { emails.orEmpty().take(16).forEach { put(it.toJsonObject()) } })
        .put("urls", JSONArray().apply { urls.orEmpty().take(16).forEach { put(it) } })
        .put(
            "addresses",
            JSONArray().apply {
                addresses.orEmpty().take(16).mapNotNull { address ->
                    address.addressLines.joinToString("\n").takeIf { it.isNotBlank() }
                }.forEach { put(it) }
            },
        )

    private fun MLKitBarcode.CalendarEvent.toJsonObject(): JSONObject = JSONObject()
        .putNullableString("summary", summary)
        .putNullableString("description", description)
        .putNullableString("location", location)
        .putNullableString("organizer", organizer)
        .putNullableString("status", status)
        .putNullableString("start", start?.rawValue)
        .putNullableString("end", end?.rawValue)

    private fun MLKitBarcode.DriverLicense.toJsonObject(): JSONObject = JSONObject()
        .putNullableString("documentType", documentType)
        .putNullableString("firstName", firstName)
        .putNullableString("middleName", middleName)
        .putNullableString("lastName", lastName)
        .putNullableString("licenseNumber", licenseNumber)
        .putNullableString("gender", gender)
        .putNullableString("birthDate", birthDate)
        .putNullableString("expiryDate", expiryDate)
        .putNullableString("issuingDate", issueDate)
        .putNullableString("issuingCountry", issuingCountry)
        .putNullableString("addressStreet", addressStreet)
        .putNullableString("addressCity", addressCity)
        .putNullableString("addressState", addressState)
        .putNullableString("addressZip", addressZip)

    private fun payload(payloadType: String): JSONObject = JSONObject().put("payloadType", payloadType)

    private fun JSONObject.putNullableString(name: String, value: String?): JSONObject {
        if (value != null) {
            put(name, value)
        }
        return this
    }

    private companion object {
        const val SCAN_TIMEOUT_SECONDS = 60L
        const val MAX_RESULTS = 128
        val SUPPORTED_ABIS = arrayOf("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
    }
}
