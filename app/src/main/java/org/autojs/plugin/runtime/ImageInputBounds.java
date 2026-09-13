package org.autojs.plugin.runtime;

import android.graphics.BitmapFactory;
import java.io.FileDescriptor;

/** Allocation limits are checked with long arithmetic before decoding images. */
public final class ImageInputBounds {
    public static final long MAX_PIXELS = 16L * 1024 * 1024;
    public static final long MAX_RAW_BYTES = 64L * 1024 * 1024;
    private ImageInputBounds() {}

    public static void validateDimensions(int width, int height) {
        if (width <= 0 || height <= 0 || (long) width * height > MAX_PIXELS) {
            throw new IllegalArgumentException("Image dimensions must be positive and contain at most 16777216 pixels");
        }
    }

    public static void validateRaw(int width, int height, int stride) {
        validateDimensions(width, height);
        if (stride < (long) width * 4 || (long) stride * height > MAX_RAW_BYTES) {
            throw new IllegalArgumentException("Raw image stride or byte count exceeds the 64 MiB limit");
        }
    }

    public static void validateEncoded(FileDescriptor descriptor) {
        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(descriptor, null, bounds);
        validateDimensions(bounds.outWidth, bounds.outHeight);
    }
}
