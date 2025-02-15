# 🚀 SpaceX Kotlin API Library

A Kotlin-based library for interacting with the SpaceX API on the JVM platform. 🛰️

---

## 📊 Code Coverage

Check code coverage results in the GitHub repository badge above! We track code coverage to ensure the quality and
reliability of the code. Contributions to improve test coverage are always welcome!

[![Build](https://github.com/Acerik/spacex-kot-api/actions/workflows/kotlin-ci.yml/badge.svg)](https://github.com/Acerik/spacex-kot-api/actions/workflows/kotlin-ci.yml)
[![Code Coverage](https://github.com/Acerik/spacex-kot-api/raw/ci-results/.github/badges/jacoco.svg)](https://github.com/Acerik/spacex-kot-api)

---

## ✨ Features

- Simple and intuitive Kotlin API for SpaceX 🚀
- Supports capsules, rockets, launches, and more!
- JVM compatible with Kotlin 2.0.20 and JDK 21 ☕

## 📦 Installation

Add the following dependency to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("cz.matejvana:spacex-kot-api:1.0-SNAPSHOT")
}
```

## 🛠️ Usage

```kotlin
val client = SpaceXClient()
val capsules = client.capsules.allCapsules()
println(capsules)
```

## ✅ Testing

Run tests with:

```sh
./gradlew test
```

Check code coverage results in the GitHub repository badge above! 📊

## 🤝 Contributing

Contributions are welcome! Open issues, create pull requests, and help improve the project.

## 🧑‍💻 Author

Created by [Matej Vana](https://github.com/Acerik) 👨‍🚀

---

⭐ Star this repository if you find it useful! Thank you for your support! 🌟

