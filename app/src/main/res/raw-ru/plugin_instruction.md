Используйте ML Kit Barcode для обнаружения штрихкодов из дескриптора файла изображения.

Action сервиса:

```text
org.autojs.plugin.MLKIT_BARCODE
```

Основной метод AIDL:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` поддерживает `formats`, `maxResults` и `enableAllPotentialBarcodes`.

Поддерживаемые имена форматов включают `QR_CODE`, `AZTEC`, `DATA_MATRIX`, `PDF417`, `CODE_128`, `CODE_39`, `CODE_93`, `CODABAR`, `EAN_13`, `EAN_8`, `ITF`, `UPC_A` и `UPC_E`.

Каждый результат может включать `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints` и JSON структурированной нагрузки в `structuredJson`.
