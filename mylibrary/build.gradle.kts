import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)

    id("maven-publish")
    id("signing")
    id("com.vanniktech.maven.publish") version "0.30.0"
}

group = "io.github.huongltt1113"
version = "1.0.7"

//publishing {
//    publications {
//        create<MavenPublication>("release") {
//            afterEvaluate {
//                from(components["release"])
//            }
//            groupId = "io.github.huongltt1113"
//            artifactId = "mylibrary"
//            version = "1.0.7"
//
//            pom {
//                name.set("My Library")
//                description.set("A description of what your library does")
//                url.set("https://github.com/huongltt1113/GMapProj")
//
//                licenses {
//                    license {
//                        name.set("Apache License 2.0")
//                        url.set("http://www.apache.org/licenses/LICENSE-2.0.html")
//                    }
//                }
//
//                developers {
//                    developer {
//                        id.set("luongthithuhuong")
//                        name.set("Luong Thi Thu Huong")
//                        email.set("21020330@vnu.edu.vn")
//                    }
//                }
//
//                scm {
//                    connection.set("scm:git:git://github.com/huongltt1113/GMapProj.git")
//                    developerConnection.set("scm:git:ssh://github.com/huongltt1113/GMapProj.git")
//                    url.set("https://github.com/huongltt1113/GMapProj")
//                }
//            }
//        }
//    }
//}
//

android {
    namespace = "io.github.huongltt1113"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

mavenPublishing {
    coordinates(
        groupId = "io.github.huongltt1113",
        artifactId = "mylibrary",
        version = "1.0.7"
    )

    pom{
        name.set("My Library")
        description.set("A description of what your library does")
        url.set("https://github.com/huongltt1113/GMapProj")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("huongltt1113")
                name.set("Luong Thi Thu Huong")
                email.set("21020337@vnu.edu.vn")
            }
        }

        scm{
            url.set("https://github.com/huongltt1113/GMapProj")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}
//
//signing {
//    sign(publishing.publications["release"])
//}
