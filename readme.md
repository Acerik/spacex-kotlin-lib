# 🚀 SpaceX Kotlin API Library

A Kotlin-based library for interacting with the SpaceX API on the JVM platform. 🛰️

---

## ✨ Features

- Simple and intuitive Kotlin API for SpaceX 🚀
- Supports capsules, rockets, launches, and more!
- JVM compatible with Kotlin 2.0.20 and JDK 21 ☕

## 📦 Installation

Add the following dependency to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("cz.matejvana:spacex-kotlin-lib:1.0-SNAPSHOT")
}
```

## 🛠️ Usage

```kotlin
val client = SpaceXClient()
val capsules = client.capsules.allCapsules()
println(capsules)
```

## ✅ Build Status & Testing

Check the build status in the GitHub repository badge above! We ensure the quality and reliability of the code by
running continuous integration tests. Contributions to improve the project are always welcome!

[![Build](https://github.com/Acerik/spacex-kotlin-lib/actions/workflows/kotlin-ci.yml/badge.svg)](https://github.com/Acerik/spacex-kot-api/actions/workflows/kotlin-ci.yml)

Run tests with:

```sh
./gradlew test
```

## 🤝 Contributing

Contributions are welcome! Open issues, create pull requests, and help improve the project.

## 🧑‍💻 Author

Created by [Matěj Váňa](https://github.com/Acerik) 👨‍🚀

---

⭐ Star this repository if you find it useful! Thank you for your support! 🌟

