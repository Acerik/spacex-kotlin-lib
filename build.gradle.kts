plugins {
    kotlin("jvm") version "2.0.20"
}

group = "cz.matejvana"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.16") // Update to the latest version of MockK
    testImplementation("net.bytebuddy:byte-buddy:1.12.0") // Update to the latest version of Byte Buddy
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.31")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}