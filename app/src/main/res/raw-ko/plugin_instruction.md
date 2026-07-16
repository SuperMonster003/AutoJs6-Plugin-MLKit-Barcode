ML Kit Barcode를 사용해 이미지 파일 디스크립터에서 바코드를 감지합니다.

서비스 action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

핵심 AIDL 메서드:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions`는 `formats`, `maxResults`, `enableAllPotentialBarcodes`를 지원합니다.

지원 형식 이름에는 `QR_CODE`, `AZTEC`, `DATA_MATRIX`, `PDF417`, `CODE_128`, `CODE_39`, `CODE_93`, `CODABAR`, `EAN_13`, `EAN_8`, `ITF`, `UPC_A`, `UPC_E`가 포함됩니다.

각 결과에는 `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, 그리고 `structuredJson`의 구조화된 페이로드 JSON이 포함될 수 있습니다.
