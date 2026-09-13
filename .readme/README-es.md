<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <source srcset="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap-night/ic_launcher.png?raw=true" media="(prefers-color-scheme: dark)" />
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-mlkit-barcode-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Escaneo de códigos de barras en el dispositivo con Google ML Kit</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Idiomas (Languages)

******

El README.md actual admite los siguientes idiomas:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-fr.md)
- Español [es] # actual
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/.readme/README-ar.md)

******

### Introduccion

******

El complemento AutoJs6 ML Kit Barcode proporciona deteccion de codigos de barras en el dispositivo con Google ML Kit para AutoJs6. Mantiene las dependencias de ML Kit, las bibliotecas nativas y los recursos de modelo fuera del APK anfitrion.

******

### Funciones

******

- Proporciona el servicio de complemento `mlkit-barcode` con ID `mlkit-barcode` y motor `mlkit-barcode`.
- Admite descubrimiento e invocacion por el anfitrion mediante `org.autojs.plugin.MLKIT_BARCODE`.
- Admite filtros de formato de codigo de barras, limites de resultados y deteccion de codigos de barras potenciales de ML Kit.
- Devuelve valores sin procesar, valores de visualizacion, bytes sin procesar, nombres de formato, nombres de tipo de valor, rectangulos delimitadores, puntos de esquina y JSON de carga util estructurada.
- Los metadatos del complemento, las instrucciones de uso, el README y el CHANGELOG estan localizados para espanol/frances/ruso/arabe/japones/coreano/ingles/chino simplificado/chino tradicional de Hong Kong/chino tradicional de Taiwan.
- Basado en `com.google.mlkit:barcode-scanning:17.3.0`.
- Las imágenes admiten hasta 16777216 píxeles
- La imagen codificada admite hasta 64 MiB mediante descriptores de archivo y tuberías

******

### Uso

******

El anfitrion descubre el servicio mediante esta action:

```text
org.autojs.plugin.MLKIT_BARCODE
```

Metodo AIDL principal:

```kotlin
List<BarcodeResult> detect(ParcelFileDescriptor imageFd, BarcodeOptions options)
```

`BarcodeOptions` admite:

- `formats`: Lista de formatos a detectar. Vacio o `ALL_FORMATS` escanea todos los formatos.
- `maxResults`: Numero maximo de resultados devueltos. El servicio lo limita a 128.
- `enableAllPotentialBarcodes`: Activa la deteccion de codigos de barras potenciales de ML Kit.

******

### Formatos admitidos

******

Los nombres de formato comunes incluyen:

```text
QR_CODE, AZTEC, DATA_MATRIX, PDF417,
CODE_128, CODE_39, CODE_93, CODABAR,
EAN_13, EAN_8, ITF, UPC_A, UPC_E
```

******

### Resultados

******

Cada `BarcodeResult` puede incluir estos campos: `rawValue`, `displayValue`, `rawBytes`, `formatName`, `valueTypeName`, `boundingBox`, `cornerPoints`, `structuredJson`.

******

### Historial de versiones

******

# v1.0.2

###### 2026/09/13

* `Correccion` La versión y las ABI del centro de complementos coinciden con el APK instalado
* `Correccion` La imagen codificada admite hasta 64 MiB mediante descriptores de archivo y tuberías
* `Correccion` Las fechas de versión mantienen un formato uniforme en inglés
* `Mejora` Validación de las versiones, firmas y variantes completas de los APK antes de crear los archivos de descarga
* `Mejora` Las imágenes admiten hasta 16777216 píxeles

# v1.0.1

###### 2026/09/11

* `Mejora` Verificación de compilación de la alineación de páginas de 16 KB en bibliotecas nativas de 64 bits, con controles del contrato manifest e informes JSON

# v1.0.0

###### 2026/09/01

* `Nueva` Se agrego el servicio de complemento ML Kit Barcode con ID `mlkit-barcode` y motor `mlkit-barcode`
* `Nueva` Se agrego descubrimiento e invocacion por el anfitrion mediante `org.autojs.plugin.MLKIT_BARCODE`
* `Nueva` Se agrego la API de deteccion de codigos de barras `detect(imageFd, options)` basada en descriptores de archivo de imagen
* `Nueva` Se agregaron filtros de formato de codigo de barras, limites de resultados y la opcion de ML Kit `enableAllPotentialBarcodes`
* `Nueva` Se devuelven `rawValue`, `displayValue`, `rawBytes`, nombres de formato, nombres de tipo de valor, rectangulos delimitadores, puntos de esquina y JSON de carga util estructurada
* `Nueva` Se agregaron metadatos del complemento e instrucciones de uso localizadas para espanol/frances/ruso/arabe/japones/coreano/ingles/chino simplificado/chino tradicional de Hong Kong/chino tradicional de Taiwan
* `Nueva` Se agregaron compilaciones APK separadas por ABI para `arm64-v8a`, `armeabi-v7a`, `x86_64`, `x86` y un APK `universal`
* `Mejora` Las dependencias de Google ML Kit barcode scanning, las bibliotecas nativas y los recursos de modelo permanecen fuera del APK anfitrion de AutoJs6
* `Mejora` Los nombres de APK de publicacion incluyen la version y la variante ABI
* `Mejora` Unificar el diseño del README y la gestión de versiones de la plataforma Gradle
* `Mejora` Simplificar la descripción del complemento y normalizar la puntuación de los recursos multilingües
* `Dependencia` Integrado `com.google.mlkit:barcode-scanning:17.3.0`

##### Para mas historial de versiones

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/app/src/main/assets/doc/CHANGELOG-es.md)

******

### Compilacion

******

```powershell
.\gradlew.bat :app:assembleDebug
```

Compilacion Release:

```powershell
.\gradlew.bat :app:assembleRelease
```

Los parametros de compilacion vienen de `version.properties`; el SDK minimo actual es 24 y el SDK objetivo es 36.

******

### Estructura de recursos

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
```

`strings.xml` contiene descripciones localizadas del complemento; `plugin_instruction.md` contiene instrucciones de uso mostradas por el anfitrion. README y CHANGELOG se generan desde fuentes JSON mediante `.python/generate_markdown.py`.

******

### Enlaces

******

- Documentacion de Google ML Kit Barcode Scanning: https://developers.google.com/ml-kit/vision/barcode-scanning/android
- Repositorio del proyecto: https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-MLKit-Barcode/blob/master/docs/16kb.md)
