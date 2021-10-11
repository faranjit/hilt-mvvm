# Hilt MVVM App

This is an application that developed with Kotlin using Hilt for dependency injection and MVVM architecture. This is my first hilt project so it may have wrong usages or bad implementations.

### Archtitecture

This app is built on MVVM with Clean Architecture principles. The app has 2 simple activities: Home and detail.
- An activity sends request from viewModel to fetch data and observes the response via LiveData to update UI.
- ViewModel uses usecases to send requests that started with Coroutines. An usecase means a bridge between ViewModel and Data layer.
- There are repositories to provide single source of data between usecases and data layers.
- Data layer has its own data sources(local or remote or both)., in this case just there is just a remote data source.
- Data source maps response to model and wraps it with corresponding state.

## Libraries and tools used

* [Hilt](https://github.com/bumptech/glide)
* [Glide](https://github.com/bumptech/glide)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Coroutines](https://developer.android.com/kotlin/coroutines)
* [Kotlinx.Serialization](https://github.com/Kotlin/kotlinx.serialization)

## Features
* Home(Feed)
* Detail

### Home
Entry point of the application. Basically it contains 3 recycler views, 1 horizontal, 1 vertical and 1 grid. 

### Details
After clicking a service item in home screen this activity will be opened. It simply shows a banner of the service and some info about the service. Thats it :)

## Code Quality
Run ```./gradlew checkCode``` to see lint and detekt warnings, errors. This task also runs all unit tests. If you want to run just unit tests then run ```./gradlew test```.
