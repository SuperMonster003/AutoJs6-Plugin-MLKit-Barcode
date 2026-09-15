******

### 發行歷史

******

# v1.0.3

###### 2026/09/15

* `優化` 將 compileSdk 提升到 37 (Android 17), targetSdk 保持 36, 待依賴目標版本的行為驗證後再提升

# v1.0.2

###### 2026/09/13

* `修復` 外掛中心顯示的版本與 ABI 資訊符合實際安裝的 APK
* `修復` 編碼圖像最大為 64 MiB, 支援檔案描述符和管道傳輸
* `修復` 版本日期保持統一的英文格式
* `優化` 發佈下載檔案產生前校驗 APK 版本, 簽署與完整變體集合
* `優化` 影像最多包含 16777216 個像素

# v1.0.1

###### 2026/09/11

* `優化` 建置階段校驗 64 位原生程式庫的 16 KB 頁面大小對齊, 檢查 manifest 契約並輸出 JSON 報告

# v1.0.0

###### 2026/09/01

* `新增` ML Kit Barcode 插件服務, 插件 ID 為 `mlkit-barcode`, 引擎為 `mlkit-barcode`
* `新增` 支援透過 `org.autojs.plugin.MLKIT_BARCODE` 發現並調用插件
* `新增` 支援基於圖片文件描述符的 `detect(imageFd, options)` 條碼識別接口
* `新增` 支援按格式過濾, 最大返回數量限制, 以及 ML Kit `enableAllPotentialBarcodes` 選項
* `新增` 返回 `rawValue`, `displayValue`, `rawBytes`, 格式名稱, 值類型名稱, 外接矩形, 角點座標和結構化載荷 JSON
* `新增` 插件資訊和使用說明的多語言資源: 西班牙語/法語/俄語/阿拉伯語/日語/韓語/英語/簡體中文/香港繁體/台灣繁體
* `新增` 支援按 ABI 構建 APK, 包括 `arm64-v8a`/`armeabi-v7a`/`x86_64`/`x86` 以及 `universal` 通用包
* `優化` 將 Google ML Kit 條碼掃描依賴, 原生庫和模型資產保持在 AutoJs6 宿主 APK 外部
* `優化` 發佈 APK 文件名包含版本號和 ABI 變體
* `優化` 統一 README 版式與 Gradle 平台版本管理方式
* `優化` 精簡插件描述並規範多語言資源中的標點符號
* `依賴` 集成 `com.google.mlkit:barcode-scanning:17.3.0`
