# AutoJs6 Plugin: ML Kit Barcode

External ML Kit Barcode scanner plugin for AutoJs6.

The plugin exposes `org.autojs.plugin.MLKIT_BARCODE` through an AIDL service and keeps Google ML Kit barcode dependencies, native libraries, and bundled model assets outside the AutoJs6 host APK.

Build:

```powershell
./gradlew :app:assembleDebug
```

Install:

```powershell
./gradlew :app:installDebug
```
