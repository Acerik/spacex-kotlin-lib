plugins {
    kotlin("jvm") version "2.0.20"
    id("jacoco")
    id("maven-publish")
}

group = "com.github.Acerik"
version = "0.9.1"

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
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Acerik/spacex-kotlin-lib")
            credentials {
                username = (project.findProperty("gpr.user") as? String) ?: System.getenv("GITHUB_ACTOR")
                password = (project.findProperty("gpr.key") as? String) ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}