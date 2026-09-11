<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-mlkit-barcode-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Lecture de codes-barres sur l'appareil avec Google ML Kit</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Langues (Languages)

******

Le README.md actuel prend en charge les langues suivantes:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-en.md)
- Français [fr] # actuel
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ar.md)

******

### Introduction

******

Le plugin AutoJs6 ML Kit Barcode fournit a AutoJs6 une detection de codes-barres sur l'appareil basee sur Google ML Kit. Il garde les dependances ML Kit, les bibliotheques natives et les assets de modele en dehors de l'APK hote.

******

### Fonctionnalites

******

- Fournit le service de plugin `mlkit-barcode` avec l'ID `mlkit-barcode` et le moteur `mlkit-barcode`.
- Prend en charge la decouverte et l'appel par l'hote via `org.autojs.plugin.MLKIT_BARCODE`.
- Prend en charge les filtres de formats de codes-barres, les limites de resultats et la detection des codes-barres potentiels de ML Kit.
- Renvoie les valeurs brutes, les valeurs affichees, les octets bruts, les noms de format, les noms de type de valeur, les rectangles englobants, les points d'angle et le JSON de charge utile structuree.
- Les metadonnees du plugin, les instructions d'utilisation, le README et le CHANGELOG sont localises en espagnol/francais/russe/arabe/japonais/coreen/anglais/chinois simplifie/chinois traditionnel de Hong Kong/chinois traditionnel de Taiwan.
- Base sur `com.google.mlkit:barcode-scanning:17.3.0`.

******

### Utilisation

******

L'hote decouvre le service via cette action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

Methode AIDL principale:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` prend en charge:

- `formats`: Liste des formats a detecter. Vide ou `ALL_FORMATS` analyse tous les formats.
- `maxResults`: Nombre maximal de resultats retournes. Le service limite cette valeur a 128.
- `enableAllPotentialBarcodes`: Active la detection des codes-barres potentiels de ML Kit.

******

### Formats pris en charge

******

Les noms de formats courants incluent:

```text
QR_CODE, AZTEC, DATA_MATRIX, PDF417,
CODE_128, CODE_39, CODE_93, CODABAR,
EAN_13, EAN_8, ITF, UPC_A, UPC_E
```

******

### Resultats

******

Chaque `BarcodeResult` peut inclure ces champs: `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson`.

******

### Historique des versions

******

# v1.0.1

###### 2026/09/11

* `Amelioration` Vérification à la compilation de l'alignement des pages de 16 KB des bibliothèques natives 64 bits, avec contrôle du contrat manifest et rapports JSON

# v1.0.0

###### 2026/09/01

* `Ajout` Ajout du service de plugin ML Kit Barcode avec l'ID `mlkit-barcode` et le moteur `mlkit-barcode`
* `Ajout` Ajout de la decouverte et de l'appel par l'hote via `org.autojs.plugin.MLKIT_BARCODE`
* `Ajout` Ajout de l'API de detection de codes-barres `detect(imageFd, options)` basee sur les descripteurs de fichiers image
* `Ajout` Ajout des filtres de formats de codes-barres, des limites de resultats et de l'option ML Kit `enableAllPotentialBarcodes`
* `Ajout` Retour de `rawValue`, `displayValue`, `rawBytes`, des noms de format, des noms de type de valeur, des rectangles englobants, des points d'angle et du JSON de charge utile structuree
* `Ajout` Ajout des metadonnees de plugin et des instructions d'utilisation localisees en espagnol/francais/russe/arabe/japonais/coreen/anglais/chinois simplifie/chinois traditionnel de Hong Kong/chinois traditionnel de Taiwan
* `Ajout` Ajout de builds APK separes par ABI pour `arm64-v8a`, `armeabi-v7a`, `x86_64`, `x86` et un APK `universal`
* `Amelioration` Conservation des dependances Google ML Kit barcode scanning, des bibliotheques natives et des assets de modele en dehors de l'APK hote AutoJs6
* `Amelioration` Les noms des APK de publication incluent la version et la variante ABI
* `Amelioration` Uniformiser la mise en page du README et la gestion des versions de la plateforme Gradle
* `Amelioration` Simplifier la description du plugin et normaliser la ponctuation des ressources multilingues
* `Dependance` Integration de `com.google.mlkit:barcode-scanning:17.3.0`

##### Pour plus d'historique des versions

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/assets/doc/CHANGELOG-fr.md)

******

### Build

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Build Release:

```powershell
.\gradlew.bat :app:assembleRelease
```

Les parametres de build viennent de `version.properties`; le SDK minimum actuel est 24 et le SDK cible est 36.

******

### Structure des ressources

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` contient les descriptions localisees du plugin; `plugin_instruction.md` contient les instructions d'utilisation affichees par l'hote. README et CHANGELOG sont generes depuis les sources JSON par `.python/generate_markdown.py`.

******

### Liens

******

- Documentation Google ML Kit Barcode Scanning: https://developers.google.com/ml-kit/vision/barcode-scanning/android
- Depot du projet: https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/docs/16kb.md)
