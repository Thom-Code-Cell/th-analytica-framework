plugins { id("com.android.application") }
android {
    namespace = "com.thanalytica.pps.receiver"
    compileSdk = 36
    defaultConfig {
        applicationId = "com.thanalytica.pps.receiver"
        minSdk = 26
        targetSdk = 36
        versionCode = 2
        versionName = "0.2.0-test"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
dependencies {
    implementation("com.google.zxing:core:3.5.3")
    implementation("androidx.activity:activity:1.10.1")
    implementation("androidx.camera:camera-camera2:1.4.2")
    implementation("androidx.camera:camera-lifecycle:1.4.2")
    implementation("androidx.camera:camera-video:1.4.2")
    implementation("androidx.camera:camera-view:1.4.2")
    testImplementation("junit:junit:4.13.2")
}
