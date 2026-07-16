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
