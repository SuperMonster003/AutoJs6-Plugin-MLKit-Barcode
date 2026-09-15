<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-mlkit-barcode-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Google ML Kit 기반 온디바이스 바코드 스캔</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 언어 (Languages)

******

현재 README.md는 다음 언어를 지원합니다:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ja.md)
- 한국어 [ko] # 현재
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ar.md)

******

### 소개

******

AutoJs6 ML Kit Barcode 플러그인은 Google ML Kit 기반 온디바이스 바코드 감지 기능을 AutoJs6에 제공합니다. ML Kit 의존성, 네이티브 라이브러리, 모델 에셋을 호스트 APK 외부에 둘 수 있습니다.

******

### 기능

******

- `mlkit-barcode` 플러그인 서비스를 제공하며 플러그인 ID는 `mlkit-barcode`, 엔진은 `mlkit-barcode`입니다.
- `org.autojs.plugin.MLKIT_BARCODE`를 통한 호스트 검색 및 호출을 지원합니다.
- 바코드 형식 필터, 최대 결과 수 제한, ML Kit 잠재 바코드 감지를 지원합니다.
- 원시 값, 표시 값, 원시 바이트, 형식 이름, 값 유형 이름, 경계 상자, 모서리 좌표, 구조화된 페이로드 JSON을 반환합니다.
- 플러그인 메타데이터, 사용 설명, README, CHANGELOG는 스페인어/프랑스어/러시아어/아랍어/일본어/한국어/영어/중국어 간체/홍콩 중국어 번체/대만 중국어 번체를 지원합니다.
- `com.google.mlkit:barcode-scanning:17.3.0` 기반입니다.
- 이미지는 최대 16777216픽셀까지 지원
- 인코딩된 이미지는 최대 64 MiB이며 파일 디스크립터와 파이프를 지원합니다

******

### 사용법

******

호스트는 다음 action으로 서비스를 검색합니다:

```text
org.autojs.plugin.MLKIT_BARCODE
```

핵심 AIDL 메서드:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` 지원 항목:

- `formats`: 감지할 형식 목록. 비어 있거나 `ALL_FORMATS`가 포함되면 모든 형식을 스캔합니다.
- `maxResults`: 반환할 최대 결과 수. 서비스 상한은 128입니다.
- `enableAllPotentialBarcodes`: ML Kit 잠재 바코드 감지를 활성화합니다.

******

### 지원 형식

******

일반적인 형식 이름은 다음과 같습니다:

```text
QR_CODE, AZTEC, DATA_MATRIX, PDF417,
CODE_128, CODE_39, CODE_93, CODABAR,
EAN_13, EAN_8, ITF, UPC_A, UPC_E
```

******

### 결과

******

각 `BarcodeResult`에는 다음 필드가 포함될 수 있습니다: `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson`.

******

### 릴리스 기록

******

# v1.0.4

###### 2026/09/16

* `개선` compileSdk 에 이어 targetSdk 를 37 (Android 17) 로 올리며, 플러그인 동작은 새 대상 버전의 영향을 받지 않음

# v1.0.3

###### 2026/09/15

* `개선` compileSdk 를 37 (Android 17) 로 올리며, targetSdk 는 대상 버전에 의존하는 동작을 검증할 때까지 36 으로 유지

# v1.0.2

###### 2026/09/13

* `수정` 플러그인 센터의 버전과 ABI 정보가 설치된 APK와 일치
* `수정` 인코딩된 이미지는 최대 64 MiB이며 파일 디스크립터와 파이프를 지원합니다
* `수정` 버전 날짜를 일관된 영어 형식으로 표시
* `개선` 다운로드 파일 생성 전에 릴리스 APK의 버전, 서명 및 전체 변형 구성을 검증
* `개선` 이미지는 최대 16777216픽셀까지 지원

##### 더 많은 릴리스 기록

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/assets/doc/CHANGELOG-ko.md)

******

### 빌드

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Release 빌드:

```powershell
.\gradlew.bat :app:assembleRelease
```

빌드 매개변수는 `version.properties`에서 가져옵니다. 현재 최소 SDK는 24, 대상 SDK는 36입니다.

******

### 리소스 구조

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml`은 로컬라이즈된 플러그인 설명을 제공합니다; `plugin_instruction.md`는 호스트에 표시되는 사용 설명을 제공합니다. README와 CHANGELOG는 `.python/generate_markdown.py`가 JSON 소스에서 생성합니다.

******

### 관련 링크

******

- Google ML Kit Barcode Scanning 문서: https://developers.google.com/ml-kit/vision/barcode-scanning/android
- 프로젝트 저장소: https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/docs/16kb.md)
