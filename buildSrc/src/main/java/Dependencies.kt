object Versions {
    const val KOTLIN_VERSION = "1.5.31"
    const val KOTLINX_COROUTINES = "1.5.2"
    const val BUILD_GRADLE = "7.0.3"

    const val CORE_KTX = "1.5.0"
    const val APP_COMPAT = "1.3.1"
    const val ACTIVITY_KTX = "1.2.3"
    const val LIFECYCLE_KTX = "2.3.1"
    const val PAGING = "3.0.1"

    const val HILT = "2.37"
    const val MATERIAL = "1.4.0"

    const val RETROFIT = "2.9.0"
    const val OKHTTP = "4.9.0"

    const val JUNIT = "4.13.2"
    const val ANDROID_JUNIT = "1.1.3"
    const val ESPRESSO_CORE = "3.4.0"
}

object Kotlin {
    const val KOTLIN_STDLIB      = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val COROUTINES_CORE    = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLINX_COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES}"
}

object AndroidX {
    const val CORE_KTX                = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT              = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.1"

    const val ACTIVITY_KTX            = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"

    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX}"
    const val LIFECYCLE_LIVEDATA_KTX  = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX}"
}

object Paging {
    const val PAGING = "androidx.paging:paging-runtime:${Versions.PAGING}"
    const val PAGING_COMMON = "androidx.paging:paging-common:${Versions.PAGING}"
    const val PAGING_RXJAVA3 = "androidx.paging:paging-rxjava3:${Versions.PAGING}"
}

object Google {
    const val HILT_ANDROID          = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"

    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
}

object ReactiveX{
    private const val VERSION   = "3.0.1"
    const val RX_KOTLIN         = "io.reactivex.rxjava3:rxkotlin:$VERSION"
}

object Libraries {
    const val RETROFIT                   = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON    = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val RETROFIT_ADAPTER_RXJAVA    = "com.squareup.retrofit2:adapter-rxjava3:${Versions.RETROFIT}"
    const val OKHTTP                     = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_SSE                 = "com.squareup.okhttp3:okhttp-sse:${Versions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val GLIDE     = "com.github.bumptech.glide:glide:4.12.0"
    const val GLIDE_COMPILER  = "com.github.bumptech.glide:compiler:4.8.0"
}

object Test {
    const val JUNIT         = "junit:junit:${Versions.JUNIT}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}




