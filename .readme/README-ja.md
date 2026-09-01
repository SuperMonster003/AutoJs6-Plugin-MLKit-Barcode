<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-mlkit-barcode-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Google ML Kit を利用したオンデバイスバーコードスキャン</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 言語 (Languages)

******

現在の README.md は次の言語に対応しています:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-es.md)
- 日本語 [ja] # 現在
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ar.md)

******

### 概要

******

AutoJs6 ML Kit Barcode プラグインは, Google ML Kit に基づくオンデバイスバーコード検出機能を AutoJs6 に提供します. ML Kit 依存関係, ネイティブライブラリ, モデルアセットをホスト APK の外側に保持できます.

******

### 機能

******

- `mlkit-barcode` プラグインサービスを提供します. プラグイン ID は `mlkit-barcode`, エンジンは `mlkit-barcode` です.
- `org.autojs.plugin.MLKIT_BARCODE` によるホストからの検出と呼び出しに対応します.
- バーコード形式フィルター, 最大結果数の制限, ML Kit の潜在バーコード検出に対応します.
- 生値, 表示値, 生バイト, 形式名, 値タイプ名, バウンディングボックス, 角点座標, 構造化ペイロード JSON を返します.
- プラグイン情報, 使用説明, README, CHANGELOG はスペイン語/フランス語/ロシア語/アラビア語/日本語/韓国語/英語/簡体字中国語/香港繁体字中国語/台湾繁体字中国語に対応します.
- `com.google.mlkit:barcode-scanning:17.3.0` を基盤にしています.

******

### 使い方

******

ホストは次の action でサービスを検出します:

```text
org.autojs.plugin.MLKIT_BARCODE
```

中核 AIDL メソッド:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` は次をサポートします:

- `formats`: 検出する形式のリスト. 空または `ALL_FORMATS` を含む場合はすべての形式をスキャンします.
- `maxResults`: 返す結果の最大数. サービス側の上限は 128 です.
- `enableAllPotentialBarcodes`: ML Kit の潜在バーコード検出を有効にします.

******

### 対応形式

******

一般的な形式名は次のとおりです:

```text
QR_CODE, AZTEC, DATA_MATRIX, PDF417,
CODE_128, CODE_39, CODE_93, CODABAR,
EAN_13, EAN_8, ITF, UPC_A, UPC_E
```

******

### 結果

******

各 `BarcodeResult` には次のフィールドを含められます: `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson`.

******

### リリース履歴

******

# v1.0.0

###### 2026/09/01

* `追加` プラグイン ID `mlkit-barcode`, エンジン `mlkit-barcode` の ML Kit Barcode プラグインサービスを追加
* `追加` `org.autojs.plugin.MLKIT_BARCODE` によるホストからの検出と呼び出しを追加
* `追加` 画像ファイルディスクリプターに基づく `detect(imageFd, options)` バーコード検出 API を追加
* `追加` バーコード形式フィルター, 最大結果数の制限, ML Kit `enableAllPotentialBarcodes` オプションを追加
* `追加` `rawValue`, `displayValue`, `rawBytes`, 形式名, 値タイプ名, バウンディングボックス, 角点座標, 構造化ペイロード JSON を返すように追加
* `追加` スペイン語/フランス語/ロシア語/アラビア語/日本語/韓国語/英語/簡体字中国語/香港繁体字中国語/台湾繁体字中国語のローカライズ済みプラグイン情報と使用説明を追加
* `追加` `arm64-v8a`/`armeabi-v7a`/`x86_64`/`x86` と `universal` APK の ABI 別ビルドを追加
* `改善` Google ML Kit barcode scanning 依存関係, ネイティブライブラリ, モデルアセットを AutoJs6 ホスト APK の外側に保持
* `改善` リリース APK ファイル名にバージョンと ABI バリアントを含めるように改善
* `改善` README のレイアウトと Gradle プラットフォームのバージョン管理方式を統一
* `改善` プラグインの説明を簡潔にし, 多言語リソースの句読点を統一
* `依存関係` `com.google.mlkit:barcode-scanning:17.3.0` を統合

##### その他のリリース履歴

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/assets/doc/CHANGELOG-ja.md)

******

### ビルド

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Release ビルド:

```powershell
.\gradlew.bat :app:assembleRelease
```

ビルドパラメーターは `version.properties` から取得されます. 現在の最小 SDK は 24, ターゲット SDK は 36 です.

******

### リソース構成

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` はローカライズされたプラグイン説明を提供します; `plugin_instruction.md` はホスト側に表示される使用説明を提供します. README と CHANGELOG は `.python/generate_markdown.py` により JSON ソースから生成されます.

******

### 関連リンク

******

- Google ML Kit Barcode Scanning ドキュメント: https://developers.google.com/ml-kit/vision/barcode-scanning/android
- プロジェクトリポジトリ: https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode
