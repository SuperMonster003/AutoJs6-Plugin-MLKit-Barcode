<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-mlkit-barcode-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Сканирование штрихкодов на устройстве с помощью Google ML Kit</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Языки (Languages)

******

Текущий README.md поддерживает следующие языки:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ko.md)
- Русский [ru] # текущий
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ar.md)

******

### Введение

******

Плагин AutoJs6 ML Kit Barcode предоставляет AutoJs6 распознавание штрихкодов на устройстве на базе Google ML Kit. Он хранит зависимости ML Kit, нативные библиотеки и ресурсы модели вне APK хоста.

******

### Возможности

******

- Предоставляет сервис плагина `mlkit-barcode` с ID `mlkit-barcode` и движком `mlkit-barcode`.
- Поддерживает обнаружение и вызов хостом через `org.autojs.plugin.MLKIT_BARCODE`.
- Поддерживает фильтры форматов штрихкодов, ограничение числа результатов и обнаружение потенциальных штрихкодов ML Kit.
- Возвращает сырые значения, отображаемые значения, сырые байты, имена форматов, имена типов значений, ограничивающие прямоугольники, угловые точки и JSON структурированной нагрузки.
- Метаданные плагина, инструкции, README и CHANGELOG локализованы на испанский/французский/русский/арабский/японский/корейский/английский/упрощенный китайский/традиционный китайский Гонконга/традиционный китайский Тайваня.
- Основан на `com.google.mlkit:barcode-scanning:17.3.0`.
- Изображения могут содержать до 16777216 пикселей
- Размер закодированного изображения ограничен 64 MiB с поддержкой файловых дескрипторов и каналов

******

### Использование

******

Хост обнаруживает сервис через этот action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

Основной метод AIDL:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` поддерживает:

- `formats`: Список форматов для обнаружения. Пустой список или `ALL_FORMATS` сканирует все форматы.
- `maxResults`: Максимальное число возвращаемых результатов. Сервис ограничивает значение 128.
- `enableAllPotentialBarcodes`: Включает обнаружение потенциальных штрихкодов ML Kit.

******

### Поддерживаемые форматы

******

Распространенные имена форматов включают:

```text
QR_CODE, AZTEC, DATA_MATRIX, PDF417,
CODE_128, CODE_39, CODE_93, CODABAR,
EAN_13, EAN_8, ITF, UPC_A, UPC_E
```

******

### Результаты

******

Каждый `BarcodeResult` может включать эти поля: `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson`.

******

### История выпусков

******

# v1.0.3

###### 2026/09/15

* `Улучшение` Поднят compileSdk до 37 (Android 17); targetSdk остаётся 36 до проверки поведения, зависящего от целевого уровня

# v1.0.2

###### 2026/09/13

* `Исправление` Информация о версии и ABI в центре плагинов соответствует установленному APK
* `Исправление` Размер закодированного изображения ограничен 64 MiB с поддержкой файловых дескрипторов и каналов
* `Исправление` Даты версий используют единый английский формат
* `Улучшение` Проверка версий, подписей и полного набора вариантов APK перед подготовкой файлов для загрузки
* `Улучшение` Изображения могут содержать до 16777216 пикселей

# v1.0.1

###### 2026/09/11

* `Улучшение` Проверка выравнивания страниц 16 KB для 64-битных нативных библиотек при сборке, включая контракт manifest и отчеты JSON

##### Больше истории выпусков

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/assets/doc/CHANGELOG-ru.md)

******

### Сборка

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Release сборка:

```powershell
.\gradlew.bat :app:assembleRelease
```

Параметры сборки берутся из `version.properties`; текущий минимальный SDK равен 24, целевой SDK равен 36.

******

### Структура ресурсов

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` содержит локализованные описания плагина; `plugin_instruction.md` содержит инструкции, отображаемые хостом. README и CHANGELOG создаются из JSON источников скриптом `.python/generate_markdown.py`.

******

### Ссылки

******

- Документация Google ML Kit Barcode Scanning: https://developers.google.com/ml-kit/vision/barcode-scanning/android
- Репозиторий проекта: https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/docs/16kb.md)
