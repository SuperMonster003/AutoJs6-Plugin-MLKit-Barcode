import com.android.build.api.variant.FilterConfiguration
import org.gradle.api.provider.Property
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

val globalApplicationId = "io.github.supermonster003.autojs6.plugin.mlkit.barcode"
val pluginVersionCode = 1
val pluginVersionName = "1.0.0"
val pluginVersionDate = SimpleDateFormat("MMM d, yyyy", Locale.US).apply {
    timeZone = TimeZone.getTimeZone("GMT+08:00")
}.format(Date())

android {
    namespace = globalApplicationId
    compileSdk = 36

    defaultConfig {
        applicationId = globalApplicationId
        minSdk = 24
        targetSdk = 36

        versionCode = pluginVersionCode
        versionName = pluginVersionName

        buildConfigField("String", "VERSION_DATE", "\"$pluginVersionDate\"")
        buildConfigField("String", "PLUGIN_ID", "\"mlkit-barcode\"")
        buildConfigField("String", "PLUGIN_ENGINE", "\"mlkit-barcode\"")
        buildConfigField("String", "PLUGIN_VARIANT", "\"default\"")
        resValue("string", "app_name", "ML Kit Barcode")
        resValue("string", "plugin_author", "SuperMonster003")

        ndk {
            abiFilters += listOf("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
        }
    }

    lint {
        abortOnError = false
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        aidl = true
        buildConfig = true
        resValues = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }

    packaging {
        jniLibs.useLegacyPackaging = true
        resources {
            pickFirsts += listOf(
                "META-INF/DEPENDENCIES",
                "META-INF/LICENSE",
                "META-INF/LICENSE.*",
                "META-INF/LICENSE-notice.*",
                "META-INF/license.*",
                "META-INF/NOTICE",
                "META-INF/NOTICE.*",
                "META-INF/notice.*",
                "META-INF/ASL2.0",
                "META-INF/*.kotlin_module",
            )
        }
    }

    splits {
        abi {
            isEnable = true
            reset()
            include("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
            isUniversalApk = true
        }
    }

    bundle {
        language {
            enableSplit = false
        }
        density {
            enableSplit = false
        }
        abi {
            enableSplit = false
        }
    }
}

androidComponents {
    onVariants { variant ->
        variant.outputs.forEach { output ->
            val architecture = output.filters.find {
                it.filterType == FilterConfiguration.FilterType.ABI
            }?.identifier ?: "universal"
            val outputFileNameProperty = output.javaClass.methods.firstOrNull {
                it.name == "getOutputFileName" && it.parameterTypes.isEmpty()
            }?.invoke(output) as? Property<*>

            @Suppress("UNCHECKED_CAST")
            (outputFileNameProperty as? Property<String>)?.set(
                output.versionName.map { versionName ->
                    "${rootProject.name}-v$versionName-$architecture.apk".lowercase()
                },
            )
        }
    }
}

dependencies {
    implementation(files("$rootDir/libs/common-plugin-api.aar"))
    implementation(files("$rootDir/libs/mlkit-barcode-api.aar"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.2.21")
    implementation("org.jetbrains.kotlin:kotlin-parcelize-runtime:2.2.21")
    implementation("com.google.mlkit:barcode-scanning:17.3.0")
}

tasks.withType(JavaCompile::class.java).configureEach {
    options.encoding = "UTF-8"
}
