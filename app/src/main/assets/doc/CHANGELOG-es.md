******

### Historial de versiones

******

# v1.0.4

###### 2026/09/16

* `Mejora` Tras compileSdk, targetSdk sube a 37 (Android 17); el comportamiento del plugin no depende del nuevo objetivo

# v1.0.3

###### 2026/09/15

* `Mejora` compileSdk sube a 37 (Android 17); targetSdk se mantiene en 36 hasta verificar el comportamiento que depende del objetivo

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
