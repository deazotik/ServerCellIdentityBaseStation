plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("io.ktor.plugin") version "2.3.7"
    kotlin("plugin.serialization") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation ("androidx.room:room-ktx:2.5.0")
    implementation ("androidx.room:room-runtime:2.5.0")
    implementation("org.jetbrains.exposed:exposed-core:0.48.0")
    implementation("org.jetbrains.exposed:exposed-crypt:0.48.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.48.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.48.0")
    implementation("org.jetbrains.exposed:exposed-jodatime:0.48.0")
    implementation("io.ktor:ktor-server-core-jvm:2.3.7")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.7")
    implementation("org.slf4j", "slf4j-simple", "1.7.32")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("io.ktor:ktor-client-core-jvm:2.3.7")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
}

application {
    mainClass.set("ru.maksim.cellidentityinfo.Main")
}

kotlin {
    jvmToolchain(20)
}