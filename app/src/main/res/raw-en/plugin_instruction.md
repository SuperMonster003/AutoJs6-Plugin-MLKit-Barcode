Use ML Kit Barcode to detect barcodes from an image file descriptor.

Service action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

Core AIDL method:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` supports `formats`, `maxResults`, and `enableAllPotentialBarcodes`.

Supported format names include `QR_CODE`, `AZTEC`, `DATA_MATRIX`, `PDF417`, `CODE_128`, `CODE_39`, `CODE_93`, `CODABAR`, `EAN_13`, `EAN_8`, `ITF`, `UPC_A`, and `UPC_E`.

Each result can include `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, and structured payload JSON under `structuredJson`.
