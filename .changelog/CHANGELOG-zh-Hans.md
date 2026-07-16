******

### 发行历史

******

# v1.0.0

###### 2026/07/05

* `新增` ML Kit Barcode 插件服务, 插件 ID 为 `mlkit-barcode`, 引擎为 `mlkit-barcode`
* `新增` 支持通过 `org.autojs.plugin.MLKIT_BARCODE` 发现并调用插件
* `新增` 支持基于图片文件描述符的 `detect(imageFd, options)` 条码识别接口
* `新增` 支持按格式过滤, 最大返回数量限制, 以及 ML Kit `enableAllPotentialBarcodes` 选项
* `新增` 返回 `rawValue`, `displayValue`, `rawBytes`, 格式名称, 值类型名称, 外接矩形, 角点坐标和结构化载荷 JSON
* `新增` 插件信息和使用说明的多语言资源: 西班牙语/法语/俄语/阿拉伯语/日语/韩语/英语/简体中文/香港繁体/台湾繁体
* `新增` 支持按 ABI 构建 APK, 包括 `arm64-v8a`/`armeabi-v7a`/`x86_64`/`x86` 以及 `universal` 通用包
* `优化` 将 Google ML Kit 条码扫描依赖, 原生库和模型资产保持在 AutoJs6 宿主 APK 外部
* `优化` 发布 APK 文件名包含版本号和 ABI 变体
* `依赖` 集成 `com.google.mlkit:barcode-scanning:17.3.0`
