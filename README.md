## Android Activity as a Service
[![DevOps By Rultor.com](http://www.rultor.com/b/g4s8/ActivityService)](http://www.rultor.com/p/g4s8/ActivityService)

[![Build Status](https://img.shields.io/travis/g4s8/ActivityService.svg?style=flat-square)](https://travis-ci.org/g4s8/ActivityService)
[![License](https://img.shields.io/github/license/g4s8/ActivityService.svg?style=flat-square)](https://github.com/g4s8/ActivityService/blob/master/LICENSE)
[![Bintray](https://img.shields.io/bintray/v/g4s8/maven-android/com.g4s8.activityservice.svg?style=flat-square)](https://bintray.com/g4s8/maven-android/com.g4s8.activityservice/_latestVersion)

Purposed to be used in view-based applications with single `Activity`.

**ActivityService** ~~abuses~~ is injected as base Android's `Context` and provides `Activity` via standard system-services mechanism. This library helps you to access single `Activity` instance in your views, it may be usefull when you are requesting permissions, touching fragments (e.g. Google map fragment), getting data via content-providers, starting external activities, etc.

### Usage
Add library dependency in `build.gradle` (see released [versions](https://github.com/g4s8/ActivityService/releases)):
```gradle
dependencies {
  implementation "com.g4s8:activityservice:<latest-version>"
}
```
Override `attachBaseContext` method to inject the `Activity`:
```java
@Override
protected void attachBaseContext(final Context base) {
  super.attachBaseContext(
    new ActivityService.Wrap(base, this)
  );
}
```
To retrieve the `Activity` back in some `View` use `ActivityService.From` class:
```java
final Activity activity = new ActivityService.From(context).activity();
```
Also appcompat version `ActivityServiceCompat` is available for `AppCompatActivity`.
