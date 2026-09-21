******

### 发行历史

******

# v1.0.4

###### 2026/09/19

* `修复` AGP 9.1 构建时的 SDK XML v4 解析警告, 以及 JVM 单元测试误触发 APK 原生库对齐检查的问题 (共享构建插件 1.8.3)
* `优化` targetSdk 升级至 37 (Android 17)

# v1.0.3

###### 2026/09/15

* `优化` compileSdk 升级至 37 (Android 17), targetSdk 保持 36

# v1.0.2

###### 2026/09/13

* `修复` 插件中心显示的版本及 ABI 信息与实际安装包不一致的问题
* `修复` 编码图像的文件描述符及管道输入兼容性问题 (文件大小上限为 64 MiB)
* `修复` 版本日期受构建环境语言影响, 未统一使用英文格式的问题
* `优化` 发布前校验 APK 版本, 签名及变体完整性
* `优化` 图像最多包含 16777216 个像素

# v1.0.1

###### 2026/09/11

* `优化` 构建阶段校验 64 位原生库的 16 KB 内存页对齐及 Manifest 配置, 并输出校验报告

# v1.0.0

###### 2026/09/01

* `新增` ML Kit Barcode 插件服务, 插件 ID 为 `mlkit-barcode`, 引擎为 `mlkit-barcode`
* `新增` 支持通过 org.autojs.plugin.MLKIT_BARCODE 发现并调用插件
* `新增` 支持基于图片文件描述符的 `detect(imageFd, options)` 条码识别接口
* `新增` 支持按格式过滤, 最大返回数量限制, 以及 ML Kit enableAllPotentialBarcodes 选项
* `新增` 返回 rawValue, displayValue, rawBytes, 格式名称, 值类型名称, 外接矩形, 角点坐标和结构化载荷 JSON
* `新增` 插件信息及使用说明支持 10 种语言 (西班牙语/法语/俄语/阿拉伯语/日语/韩语/英语/简体中文/香港繁体/台湾繁体)
* `新增` 支持按 ABI 构建 APK, 包括 `arm64-v8a`/`armeabi-v7a`/x86_64/x86 以及 universal 通用包
* `优化` 将 Google ML Kit 条码扫描依赖, 原生库和模型资产保持在 AutoJs6 宿主 APK 外部
* `优化` 发布 APK 文件名包含版本号和 ABI 变体
* `优化` 统一 README 版式与 Gradle 平台版本管理方式
* `优化` 精简插件描述并规范多语言资源中的标点符号
* `依赖` 附加 ML Kit Barcode Scanning 版本 17.3.0
