******

### Historique des versions

******

# v1.0.3

###### 2026/09/15

* `Amelioration` compileSdk passe à 37 (Android 17) ; targetSdk reste à 36 jusqu'à la vérification du comportement dépendant de la cible

# v1.0.2

###### 2026/09/13

* `Correctif` Les informations de version et d'ABI du centre des plugins correspondent à l'APK installé
* `Correctif` Les images encodées sont limitées à 64 MiB avec prise en charge des fichiers et des tubes
* `Correctif` Les dates de version utilisent un format anglais uniforme
* `Amelioration` Validation des versions, signatures et variantes complètes des APK avant la création des fichiers à télécharger
* `Amelioration` Les images peuvent contenir jusqu'à 16777216 pixels

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
