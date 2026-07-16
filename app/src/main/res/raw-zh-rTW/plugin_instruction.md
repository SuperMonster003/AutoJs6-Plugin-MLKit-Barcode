使用 ML Kit Barcode 從圖片檔案描述符辨識條碼.

服務 action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

核心 AIDL 方法:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` 支援 `formats`, `maxResults` 和 `enableAllPotentialBarcodes`.

支援的格式名稱包括 `QR_CODE`, `AZTEC`, `DATA_MATRIX`, `PDF417`, `CODE_128`, `CODE_39`, `CODE_93`, `CODABAR`, `EAN_13`, `EAN_8`, `ITF`, `UPC_A` 和 `UPC_E`.

每個結果可包含 `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, 以及位於 `structuredJson` 的結構化載荷 JSON.
