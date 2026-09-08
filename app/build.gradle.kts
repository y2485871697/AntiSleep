plugins {
    id("com.android.application")
}

android {
    namespace = "com.antisleep.keepscreen"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.antisleep.keepscreen"
        minSdk = 26
        targetSdk = 36
        versionCode = 4
        versionName = "1.4"
    }

    signingConfigs {
        val releaseStoreFile = System.getenv("ETA_RELEASE_STORE_FILE")
            ?: rootProject.file("app/signing/eta-release.p12").absolutePath
        val releaseStorePassword = System.getenv("ETA_RELEASE_STORE_PASSWORD") ?: "eta-release"
        val releaseKeyAlias = System.getenv("ETA_RELEASE_KEY_ALIAS") ?: "eta"
        val releaseKeyPassword = System.getenv("ETA_RELEASE_KEY_PASSWORD") ?: "eta-release"

        create("release") {
            storeFile = file(releaseStoreFile)
            storePassword = releaseStorePassword
            keyAlias = releaseKeyAlias
            keyPassword = releaseKeyPassword
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.findByName("release")
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
}
