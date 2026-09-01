******

### Release History

******

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
