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
Then define the flavors for the release
Create dimension and add the release types to the dimension. 
```sh
flavorDimensions 'default'
    productFlavors {
        alpha_release {
            dimension = 'default'
            applicationId = 'com.area51.alpha_release'
            manifestPlaceholders = [appName: "Alpha Release"]
            versionCode = 10003
            versionName = '0.0.3'
            targetSdkVersion 29
            signingConfig signingConfigs.release
        }
        beta_release {
            dimension = 'default'
            applicationId = 'com.area51.beta_release'
            manifestPlaceholders = [appName: "Beta Release"]
            versionCode = 10004
            versionName = '0.0.4'
            targetSdkVersion 29
            signingConfig signingConfigs.release
        }
    }
```
To define app name from flavors,
Create different app names, create strings.xml with same key
in beta_release/src/values/strings.xml
```sh
<resources>
    <string name="textViewLabel">Beta Release</string>
</resources>
```
in alpha_release/src/values/strings.xml
```sh
<resources>
    <string name="textViewLabel">Alpha Release</string>
</resources>
```
# OR
In manifest
```sh
<application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="${appName}"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:label="${appName}">
```
In app.build
```sh
productFlavors {
        alpha_release {
            dimension = 'default'
            applicationId = 'com.area51.alpha_release'
            manifestPlaceholders = [appName: "Alpha Release"]
            versionCode = 10003
            versionName = '0.0.3'
            targetSdkVersion 29
            signingConfig signingConfigs.release
        }
     }
```
## References

- [Link 1](https://www.journaldev.com/21533/android-build-types-product-flavors)
- [Link 2](https://developer.android.com/studio/build/build-variants)
- [Link 3](https://www.androidauthority.com/building-multiple-flavors-android-app-706436/)

