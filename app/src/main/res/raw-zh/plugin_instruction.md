使用 ML Kit Barcode 从图片文件描述符识别条码.

服务 action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

核心 AIDL 方法:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` 支持 `formats`, `maxResults` 和 `enableAllPotentialBarcodes`.

支持的格式名称包括 `QR_CODE`, `AZTEC`, `DATA_MATRIX`, `PDF417`, `CODE_128`, `CODE_39`, `CODE_93`, `CODABAR`, `EAN_13`, `EAN_8`, `ITF`, `UPC_A` 和 `UPC_E`.

每个结果可包含 `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, 以及位于 `structuredJson` 的结构化载荷 JSON.
