
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ir.adicom.androidoldpractice"
    compileSdk = Configs.compileSdk

    defaultConfig {
        applicationId = "ir.adicom.androidoldpractice"
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(mapOf("path" to ":mylibrary")))
    

    implementation(Libraries.coreKtx)
    implementation(Libraries.appCompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintlayout)
    implementation(Libraries.fragmentKtx)

    implementation(Libraries.roomKtx)
    implementation(Libraries.roomRuntime)
    kapt(Libraries.roomCompiler)

    implementation(Libraries.coroutines)
    implementation(Libraries.lifecycleViewmodelKtx)
    implementation(Libraries.lifecycleRuntimeKtx)

    // Dagger & Hilt
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompiler)

    // navigation
    implementation(Libraries.navigationFragment)
    implementation(Libraries.navigationFragmentKtx)
    implementation(Libraries.navigationUiKtx)

    // retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.converterGson)
    implementation(Libraries.loggingInterceptor)

    //gson
    implementation(Libraries.gson)

    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.extJunit)
    androidTestImplementation(Libraries.espressoCore)
}