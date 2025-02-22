plugins {
    kotlin("jvm") version "2.0.20"
    id("jacoco")
    id("maven-publish")
}

group = "cz.matejvana"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.mockk:mockk:1.13.16")
    testImplementation("net.bytebuddy:byte-buddy:1.12.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.31")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        csv.required.set(true)
        html.required.set(true)
    }
}
kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["kotlin"])
            artifactId = "spacex-kotlin-lib"
        }
    }

    repositories {
        maven {
            url = uri("https://jitpack.io")
        }
    }
}