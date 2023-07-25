
<h1 align="center">TMDP Compose 🚧 [Work in progress] 🚧</h1></br>

**A demo app using Compose, Koin based on modern Android tech-stacks and follows a reactive programming model with [Unidirectional data flow](https://developer.android.com/jetpack/compose/architecture#udf-compose).**

## Screenshots 
<p align="center">
<img src="/preview/preview1.png" width="270"/>
<img src="/preview/preview2.png" width="270"/>
<img src="/preview/preview3.png" width="270"/>
</p>

## Tech stack & Open-source libraries
- Minimum SDK level 23
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Koin for dependency injection](https://github.com/InsertKoinIO/koin) : written in Kotlin, super-easy to learn & use, lightweight DSL, increase build speed,...
- JetPack
  - [Compose](https://developer.android.com/jetpack/compose) - A modern toolkit for building native Android UI.
  - ViewModel - UI related data holder, lifecycle aware.
  - [App Startup](https://developer.android.com/topic/libraries/app-startup) - Provides a straightforward, performant way to initialize components at application startup.
- Architecture
  - MVVM Architecture (Declarative View - ViewModel - Model)
  - Repository pattern
  - [Unidirectional data flow](https://developer.android.com/jetpack/compose/architecture#udf-compose)
- [Coil](https://github.com/coil-kt/coil) - An image loading library for Android backed by Kotlin.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Sandwich](https://github.com/skydoves/Sandwich): Construct a lightweight and modern response interface to handle network payload for Android.
- [Material-Components](https://github.com/material-components/material-components-android): Material design components for building ripple animation, and CardView.
- [Kotin Serialzation](https://kotlinlang.org/docs/serialization.html): Kotlin-based & created by JetBrains team.
- [Ktlint](https://github.com/pinterest/ktlint) - Coding convention.
- [Modularization](https://developer.android.com/topic/modularization#what-is-modularization) and [Gradle Convention Plugin](https://docs.gradle.org/current/samples/sample_convention_plugins.html).
- [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - For writing Gradle build scripts using Kotlin.


## Contribute
If you want to contribute to this, you're always welcome!

## Discuss 💬

Have any questions, doubts or want to present your opinions, views? You're always welcome.



# License
```xml
Designed and developed by 2023

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
