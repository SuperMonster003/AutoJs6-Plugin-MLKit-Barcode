-keep class org.autojs.plugin.common.api.** { *; }
-keep class org.autojs.plugin.mlkit.barcode.api.** { *; }
-keep class io.github.supermonster003.autojs6.plugin.mlkit.barcode.MlKitBarcodePluginService { *; }
-keep class io.github.supermonster003.autojs6.plugin.mlkit.barcode.WakeActivity { *; }


# ML Kit lists its ComponentRegistrar implementations as manifest meta-data strings and instantiates
# them reflectively from MlKitInitProvider. firebase-components 16.1.0 (pulled in by mlkit common)
# only ships "-keep class * implements ComponentRegistrar"; in R8 full mode (AGP 8+) that keeps the
# class name but not its no-argument constructor, so the registrars fail with NoSuchMethodException,
# no components are registered, and every detect() then dies with a NullPointerException inside
# com.google.mlkit.vision.barcode.internal. Keep the constructors explicitly.
-keep class * implements com.google.firebase.components.ComponentRegistrar {
    <init>();
}
