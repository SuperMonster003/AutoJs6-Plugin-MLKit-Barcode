******

### リリース履歴

******

# v1.0.1

###### 2026/09/11

* `改善` 64 ビットのネイティブライブラリの 16 KB ページアラインメントをビルド時に検証, manifest 契約の検査と JSON レポートに対応

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
