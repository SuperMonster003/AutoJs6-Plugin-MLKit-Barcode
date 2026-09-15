******

### Release History

******

# v1.0.4

###### 2026/09/16

* `Improvement` Raise targetSdk to 37 (Android 17) after compileSdk; the plugin's behavior does not depend on the new target

# v1.0.3

###### 2026/09/15

* `Improvement` Raise compileSdk to 37 (Android 17); targetSdk stays at 36 until the behavior that depends on the target is verified

# v1.0.2

###### 2026/09/13

* `Fix` Plugin center version and ABI information matches the installed plugin APK
* `Fix` Encoded image input is limited to 64 MiB and supports file descriptors and pipes
* `Fix` Version dates use a consistent English format
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
