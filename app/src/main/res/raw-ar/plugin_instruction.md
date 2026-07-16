استخدم ML Kit Barcode لاكتشاف الرموز الشريطية من واصف ملف صورة.

Action الخدمة:

```text
org.autojs.plugin.MLKIT_BARCODE
```

طريقة AIDL الاساسية:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

يدعم `BarcodeOptions` الحقول `formats`, و `maxResults`, و `enableAllPotentialBarcodes`.

تتضمن اسماء التنسيقات المدعومة `QR_CODE`, و `AZTEC`, و `DATA_MATRIX`, و `PDF417`, و `CODE_128`, و `CODE_39`, و `CODE_93`, و `CODABAR`, و `EAN_13`, و `EAN_8`, و `ITF`, و `UPC_A`, و `UPC_E`.

يمكن ان يحتوي كل Result على `rawValue`, و `displayValue`, و `rawBytes`, و `formatName`, و `valueTypeName`, و `boundingBox`, و `cornerPoints`, و JSON للحمولة المنظمة داخل `structuredJson`.
