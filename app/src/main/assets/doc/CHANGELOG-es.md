******

### Historial de versiones

******

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
