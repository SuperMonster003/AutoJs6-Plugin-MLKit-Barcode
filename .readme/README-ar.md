<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-mlkit-barcode-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>مسح الرموز الشريطية على الجهاز باستخدام Google ML Kit</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=534BAE&label=License"/></a>
  </p>
</div>

******

### اللغات (Languages)

******

يدعم README.md الحالي اللغات التالية:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ru.md)
- العربية [ar] # الحالي

******

### مقدمة

******

يوفر مكون AutoJs6 ML Kit Barcode اكتشاف الرموز الشريطية على الجهاز ل AutoJs6 باستخدام Google ML Kit. يحتفظ باعتمادات ML Kit, والمكتبات الاصلية, واصول النموذج خارج APK المضيف.

******

### الميزات

******

- يوفر خدمة المكون `mlkit-barcode` مع معرف المكون `mlkit-barcode` والمحرك `mlkit-barcode`.
- يدعم اكتشاف المضيف والاستدعاء عبر `org.autojs.plugin.MLKIT_BARCODE`.
- يدعم مرشحات تنسيقات الرموز الشريطية, وحدود عدد النتائج, واكتشاف الرموز الشريطية المحتملة في ML Kit.
- يرجع القيم الخام, وقيم العرض, والبايتات الخام, واسماء التنسيقات, واسماء انواع القيم, والمربعات المحيطة, ونقاط الزوايا, و JSON للحمولة المنظمة.
- بيانات المكون, وتعليمات الاستخدام, و README, و CHANGELOG مترجمة للاسبانية/الفرنسية/الروسية/العربية/اليابانية/الكورية/الانجليزية/الصينية المبسطة/الصينية التقليدية في هونغ كونغ/الصينية التقليدية في تايوان.
- مبني على `com.google.mlkit:barcode-scanning:17.3.0`.
- تقبل الصور حتى 16777216 بكسل
- يقتصر حجم الصورة المشفرة على 64 MiB مع دعم واصفات الملفات والأنابيب

******

### الاستخدام

******

يكتشف المضيف الخدمة عبر هذا action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

طريقة AIDL الاساسية:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

يدعم `BarcodeOptions`:

- `formats`: قائمة التنسيقات المطلوب اكتشافها. القيمة الفارغة او `ALL_FORMATS` تفحص كل التنسيقات.
- `maxResults`: اكبر عدد من النتائج المرجعة. تحد الخدمة هذه القيمة عند 128.
- `enableAllPotentialBarcodes`: يفعل اكتشاف الرموز الشريطية المحتملة في ML Kit.

******

### التنسيقات المدعومة

******

تتضمن اسماء التنسيقات الشائعة:

```text
QR_CODE, AZTEC, DATA_MATRIX, PDF417,
CODE_128, CODE_39, CODE_93, CODABAR,
EAN_13, EAN_8, ITF, UPC_A, UPC_E
```

******

### النتائج

******

يمكن ان يحتوي كل `BarcodeResult` على هذه الحقول: `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson`.

******

### سجل الاصدارات

******

# v1.0.3

###### 2026/09/15

* `تحسين` رفع compileSdk إلى 37 (Android 17)؛ يبقى targetSdk عند 36 حتى يتم التحقق من السلوك المعتمد على الهدف

# v1.0.2

###### 2026/09/13

* `اصلاح` تطابق معلومات الإصدار وواجهات ABI في مركز الإضافات مع حزمة الإضافة المثبتة
* `اصلاح` يقتصر حجم الصورة المشفرة على 64 MiB مع دعم واصفات الملفات والأنابيب
* `اصلاح` تستخدم تواريخ الإصدارات تنسيقا إنجليزيا موحدا
* `تحسين` التحقق من إصدار حزم النشر وتوقيعها واكتمال متغيراتها قبل إنشاء ملفات التنزيل
* `تحسين` تقبل الصور حتى 16777216 بكسل

# v1.0.1

###### 2026/09/11

* `تحسين` التحقق أثناء البناء من محاذاة صفحات 16 KB للمكتبات الأصلية ذات 64 بت, مع فحص عقد manifest وتقارير JSON

##### لمزيد من سجل الاصدارات

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/assets/doc/CHANGELOG-ar.md)

******

### البناء

******

```powershell
.\gradlew.bat :app:assembleDebug
```

بناء Release:

```powershell
.\gradlew.bat :app:assembleRelease
```

تاتي معاملات البناء من `version.properties`; الحد الادنى الحالي ل SDK هو 24 و SDK الهدف هو 36.

******

### بنية الموارد

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

يحتوي `strings.xml` على اوصاف المكون المترجمة; يحتوي `plugin_instruction.md` على تعليمات الاستخدام المعروضة بواسطة المضيف. يتم توليد README و CHANGELOG من مصادر JSON بواسطة `.python/generate_markdown.py`.

******

### روابط

******

- توثيق Google ML Kit Barcode Scanning: https://developers.google.com/ml-kit/vision/barcode-scanning/android
- مستودع المشروع: https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/docs/16kb.md)
