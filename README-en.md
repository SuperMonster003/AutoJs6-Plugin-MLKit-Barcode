<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-mlkit-barcode-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>On-device barcode scanning powered by Google ML Kit</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Languages

******

The current README.md supports the following languages:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-TW.md)
- English [en] # current
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ar.md)

******

### Introduction

******

The AutoJs6 ML Kit Barcode plugin provides Google ML Kit powered on-device barcode detection for AutoJs6. It keeps ML Kit dependencies, native libraries, and model assets outside the host APK.

******

### Features

******

- Provides the `mlkit-barcode` plugin service with plugin ID `mlkit-barcode` and engine `mlkit-barcode`.
- Supports host discovery and invocation through `org.autojs.plugin.MLKIT_BARCODE`.
- Supports barcode format filters, maximum result limits, and ML Kit potential barcode detection.
- Returns raw values, display values, raw bytes, format names, value type names, bounding boxes, corner points, and structured payload JSON.
- Plugin metadata, usage instructions, README, and changelog are localized for Spanish, French, Russian, Arabic, Japanese, Korean, English, Simplified Chinese, Hong Kong Traditional Chinese, and Taiwan Traditional Chinese.
- Built on `com.google.mlkit:barcode-scanning:17.3.0`.
- Images may contain at most 16777216 pixels
- Encoded image input is limited to 64 MiB and supports file descriptors and pipes

******

### Usage

******

The host discovers the service through this action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

Core AIDL method:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` supports:

- `formats`: List of formats to detect. Empty or `ALL_FORMATS` scans all formats.
- `maxResults`: Maximum number of returned results. The service caps this at 128.
- `enableAllPotentialBarcodes`: Enables ML Kit potential barcode detection.

******

### Supported Formats

******

Common format names include:

```text
QR_CODE, AZTEC, DATA_MATRIX, PDF417,
CODE_128, CODE_39, CODE_93, CODABAR,
EAN_13, EAN_8, ITF, UPC_A, UPC_E
```

******

### Results

******

Each `BarcodeResult` can include these fields: `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson`.

******

### Release History

******

# v1.0.2

###### 2026/09/13

* `Fix` Plugin center version and ABI information matches the installed plugin APK
* `Fix` Encoded image input is limited to 64 MiB and supports file descriptors and pipes
* `Improvement` Validate release APK versions, signing and the complete variant set before creating download artifacts
* `Improvement` Images may contain at most 16777216 pixels

# v1.0.1

###### 2026/09/11

* `Improvement` Build verification of 16 KB page alignment for 64-bit native libraries, including manifest contract checks and JSON reports

# v1.0.0

###### 2026/09/01

* `Feature` Added the ML Kit Barcode plugin service with plugin ID `mlkit-barcode` and engine `mlkit-barcode`
* `Feature` Added host discovery and invocation through `org.autojs.plugin.MLKIT_BARCODE`
* `Feature` Added the `detect(imageFd, options)` barcode detection API based on image file descriptors
* `Feature` Added barcode format filters, maximum result limits, and the ML Kit `enableAllPotentialBarcodes` option
* `Feature` Returned `rawValue`, `displayValue`, `rawBytes`, format names, value type names, bounding boxes, corner points, and structured payload JSON
* `Feature` Added localized plugin metadata and usage instructions for Spanish, French, Russian, Arabic, Japanese, Korean, English, Simplified Chinese, Hong Kong Traditional Chinese, and Taiwan Traditional Chinese
* `Feature` Added ABI split APK builds for `arm64-v8a`, `armeabi-v7a`, `x86_64`, `x86`, and a `universal` APK
* `Improvement` Kept Google ML Kit barcode scanning dependencies, native libraries, and model assets outside the AutoJs6 host APK
* `Improvement` Release APK filenames include the version and ABI variant
* `Improvement` Standardize the README layout and Gradle platform version management
* `Improvement` Refine the plugin description and normalize punctuation in multilingual resources
* `Dependency` Integrated `com.google.mlkit:barcode-scanning:17.3.0`

##### For more release history

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/assets/doc/CHANGELOG-en.md)

******

### Build

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Release build:

```powershell
.\gradlew.bat :app:assembleRelease
```

Build parameters come from `version.properties`; the current minimum SDK is 24 and target SDK is 36.

******

### Resource Layout

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` contains localized plugin descriptions; `plugin_instruction.md` contains usage instructions displayed by the host. README and CHANGELOG files are generated from JSON sources by `.python/generate_markdown.py`.

******

### Links

******

- Google ML Kit Barcode Scanning documentation: https://developers.google.com/ml-kit/vision/barcode-scanning/android
- Project repository: https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/docs/16kb.md)
