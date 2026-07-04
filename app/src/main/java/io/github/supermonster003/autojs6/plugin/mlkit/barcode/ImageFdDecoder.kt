package io.github.supermonster003.autojs6.plugin.mlkit.barcode

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.ParcelFileDescriptor
import java.io.IOException

object ImageFdDecoder {

    fun decode(imageFd: ParcelFileDescriptor): Bitmap {
        try {
            imageFd.use { descriptor ->
                return BitmapFactory.decodeFileDescriptor(descriptor.fileDescriptor)
                    ?: error("decode image failed")
            }
        } catch (e: IOException) {
            throw IllegalStateException("decode image failed", e)
        }
    }
}

