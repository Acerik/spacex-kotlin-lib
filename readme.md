# 🚀 SpaceX Kotlin API Library

A Kotlin-based library for interacting with the SpaceX API on the JVM platform. 🛰️

---

## ✨ Features

- Simple and intuitive Kotlin API for SpaceX 🚀
- Supports capsules, rockets, launches, and more!
- JVM compatible with Kotlin 2.0.20 and JDK 21 ☕

## 📦 Installation

Current version

[![](https://jitpack.io/v/Acerik/spacex-kotlin-lib.svg)](https://jitpack.io/#Acerik/spacex-kotlin-lib)

Add the following dependency to your `build.gradle.kts`:

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}
dependencies {
    implementation("com.github.Acerik:spacex-kotlin-lib:1.0.0")
}
```

## 🛠️ Usage

The `SpaceXClientV4` provides a structured way to interact with the SpaceX API. It includes various endpoints such as
`capsules`, `rockets`, `launches`, and more. The client returns Data Transfer Objects (DTOs) that can be utilized in
your application.

Refer to the official SpaceX API documentation
at [https://github.com/r-spacex/SpaceX-API/](https://github.com/r-spacex/SpaceX-API/) for detailed information on how to
use the API and the available endpoints.

```kotlin
val client: SpaceXClientV4 = SpaceXClient.createV4()

val capsules = client.capsules.getAll()

capsules.forEach { capsule ->
    println(capsule)
}
```

## ✅ Build Status & Testing

Check the build status in the GitHub repository badge above! We ensure the quality and reliability of the code by
running continuous integration tests. Contributions to improve the project are always welcome!

[![Build](https://github.com/Acerik/spacex-kotlin-lib/actions/workflows/kotlin-ci.yml/badge.svg)](https://github.com/Acerik/spacex-kot-api/actions/workflows/kotlin-ci.yml)
[![](https://jitci.com/gh/Acerik/spacex-kotlin-lib/svg)](https://jitci.com/gh/Acerik/spacex-kotlin-lib)
[![](https://jitpack.io/v/Acerik/spacex-kotlin-lib.svg)](https://jitpack.io/#Acerik/spacex-kotlin-lib)

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

