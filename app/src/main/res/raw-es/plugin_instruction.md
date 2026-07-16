Use ML Kit Barcode para detectar codigos de barras desde un descriptor de archivo de imagen.

Action del servicio:

```text
org.autojs.plugin.MLKIT_BARCODE
```

Metodo AIDL principal:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` admite `formats`, `maxResults` y `enableAllPotentialBarcodes`.

Los nombres de formato admitidos incluyen `QR_CODE`, `AZTEC`, `DATA_MATRIX`, `PDF417`, `CODE_128`, `CODE_39`, `CODE_93`, `CODABAR`, `EAN_13`, `EAN_8`, `ITF`, `UPC_A` y `UPC_E`.

Cada resultado puede incluir `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints` y JSON de carga util estructurada en `structuredJson`.
