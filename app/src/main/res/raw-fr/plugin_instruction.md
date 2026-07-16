Utilisez ML Kit Barcode pour detecter les codes-barres depuis un descripteur de fichier image.

Action du service:

```text
org.autojs.plugin.MLKIT_BARCODE
```

Methode AIDL principale:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` prend en charge `formats`, `maxResults` et `enableAllPotentialBarcodes`.

Les noms de formats pris en charge incluent `QR_CODE`, `AZTEC`, `DATA_MATRIX`, `PDF417`, `CODE_128`, `CODE_39`, `CODE_93`, `CODABAR`, `EAN_13`, `EAN_8`, `ITF`, `UPC_A` et `UPC_E`.

Chaque resultat peut inclure `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints` et le JSON de charge utile structuree dans `structuredJson`.
