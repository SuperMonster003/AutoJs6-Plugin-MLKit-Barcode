<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-mlkit-barcode-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>用於 AutoJs6 的 Google ML Kit 條碼掃描外掛</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/commit/3f1ec5c271c17fd39af76b6bff20b1b047996ec9"><img alt="Created" src="https://img.shields.io/date/1783229834?color=2e7d32&label=Created"/></a>
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 語言 (Languages)

******

目前 README.md 支援以下語言:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-HK.md)
- 繁體中文 (台灣) [zh-Hant-TW] # 目前
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ar.md)

******

### 簡介

******

AutoJs6 ML Kit Barcode 外掛為 AutoJs6 提供基於 Google ML Kit 的端側條碼辨識能力, 可在宿主 APK 外部獨立攜帶 ML Kit 依賴, 原生程式庫和模型資產.

******

### 功能

******

- 提供 `mlkit-barcode` 外掛服務, 外掛 ID 為 `mlkit-barcode`, 引擎為 `mlkit-barcode`.
- 支援透過 `org.autojs.plugin.MLKIT_BARCODE` 探索並呼叫外掛.
- 支援依格式過濾條碼, 限制最大回傳數量, 以及啟用 ML Kit 的潛在條碼偵測.
- 回傳原始值, 顯示值, 原始位元組, 格式名稱, 值類型名稱, 外接矩形, 角點座標和結構化載荷 JSON.
- 外掛資訊, 使用說明, README 與 CHANGELOG 均支援西班牙語/法語/俄語/阿拉伯語/日語/韓語/英語/簡體中文/香港繁體/台灣繁體.
- 基於 `com.google.mlkit:barcode-scanning:17.3.0`.

******

### 使用說明

******

宿主透過以下 action 探索服務:

```text
org.autojs.plugin.MLKIT_BARCODE
```

核心 AIDL 方法:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` 支援:

- `formats`: 要辨識的格式清單, 留空或包含 `ALL_FORMATS` 時掃描全部格式.
- `maxResults`: 最大回傳結果數, 服務端上限為 128.
- `enableAllPotentialBarcodes`: 啟用 ML Kit 潛在條碼偵測.

******

### 支援格式

******

常用格式名稱包括:

```text
QR_CODE, AZTEC, DATA_MATRIX, PDF417,
CODE_128, CODE_39, CODE_93, CODABAR,
EAN_13, EAN_8, ITF, UPC_A, UPC_E
```

******

### 回傳結果

******

每個 `BarcodeResult` 可包含以下欄位: `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson`.

******

### 發行歷史

******

# v1.0.0

###### 2026/07/05

* `新增` ML Kit Barcode 外掛服務, 外掛 ID 為 `mlkit-barcode`, 引擎為 `mlkit-barcode`
* `新增` 支援透過 `org.autojs.plugin.MLKIT_BARCODE` 探索並呼叫外掛
* `新增` 支援基於圖片檔案描述符的 `detect(imageFd, options)` 條碼辨識介面
* `新增` 支援依格式過濾, 最大回傳數量限制, 以及 ML Kit `enableAllPotentialBarcodes` 選項
* `新增` 回傳 `rawValue`, `displayValue`, `rawBytes`, 格式名稱, 值類型名稱, 外接矩形, 角點座標和結構化載荷 JSON
* `新增` 外掛資訊和使用說明的多語言資源: 西班牙語/法語/俄語/阿拉伯語/日語/韓語/英語/簡體中文/香港繁體/台灣繁體
* `新增` 支援依 ABI 建置 APK, 包括 `arm64-v8a`/`armeabi-v7a`/`x86_64`/`x86` 以及 `universal` 通用包
* `最佳化` 將 Google ML Kit 條碼掃描依賴, 原生程式庫和模型資產保持在 AutoJs6 宿主 APK 外部
* `最佳化` 發佈 APK 檔名包含版本號和 ABI 變體
* `依賴` 整合 `com.google.mlkit:barcode-scanning:17.3.0`

##### 更多發行歷史可參閱

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.changelog/CHANGELOG-zh-Hant-TW.md)

******

### 建置

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Release 建置:

```powershell
.\gradlew.bat :app:assembleRelease
```

建置參數來自 `version.properties`, 目前最低 SDK 為 24, 目標 SDK 為 36.

******

### 資源結構

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` 提供外掛描述本地化; `plugin_instruction.md` 提供宿主側展示的外掛使用說明. README 與 CHANGELOG 由 `.python/generate_markdown.py` 根據 JSON 來源檔生成.

******

### 相關連結

******

- Google ML Kit Barcode Scanning 文件: https://developers.google.com/ml-kit/vision/barcode-scanning/android
- 專案倉庫: https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode
