ML Kit Barcode を使用して画像ファイルディスクリプターからバーコードを検出します.

サービス action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

中核 AIDL メソッド:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` は `formats`, `maxResults`, `enableAllPotentialBarcodes` をサポートします.

対応形式名には `QR_CODE`, `AZTEC`, `DATA_MATRIX`, `PDF417`, `CODE_128`, `CODE_39`, `CODE_93`, `CODABAR`, `EAN_13`, `EAN_8`, `ITF`, `UPC_A`, `UPC_E` が含まれます.

各結果には `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson` 内の構造化ペイロード JSON を含められます.
