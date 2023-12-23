# Guess your age

This is an application that will try to guess your real age based on your age!

### Build instructions

#### Dependencies

- [Gradle](https://gradle.org)

#### Build and run

##### JRE

Build the application:

```shell
./gradlew build
```

Run the application:

```shell
cd ./build/distributions
tar xvf guessyourage-1.0-SNAPSHOT.tar

./guessyourage-1.0-SNAPSHOT/bin/guessyourage
```

##### JLink

Build a runtime image with JLink:

```shell
./gradlew jlink
```

Run the application:

```shell
./build/image/bin/app
```
