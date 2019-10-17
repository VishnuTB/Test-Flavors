# Flavors

While in development, the app may need to be released in defferent types (free/premium). These type of releases can be contrlled by flavors.

By using flavors, launcher icon, name and other variables can be organized specificaly for a particular release.

## Instructions
Inorder to define flavors for android app, we need to define the type of builds (release, alpha)

```sh
buildTypes {
        release {
            minifyEnabled true
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
            signingConfig signingConfigs.release
        }
//        debug {
//            applicationIdSuffix ".debug"
//            versionNameSuffix "-debug"
//            signingConfig signingConfigs.debug
//            minifyEnabled = false
//        }
//        beta {
//            applicationIdSuffix ".beta"
//            versionNameSuffix "-beta"
//            signingConfig signingConfigs.release
//            minifyEnabled = true
//        }
    }
```

## References

- [Link 1](https://www.journaldev.com/21533/android-build-types-product-flavors)
- [Link 2](https://developer.android.com/studio/build/build-variants)
- [Link 3](https://www.androidauthority.com/building-multiple-flavors-android-app-706436/)