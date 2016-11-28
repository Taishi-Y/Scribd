# Scribd
<img src="https://github.com/Taishi-Y/Scribd/blob/master/images/screenshot.png?raw=true" 
alt="" width="240" border="10" />

## Overview

This project is getting venue datas from Google Books API.( https://developers.google.com/books/ )
You can just clone this sample repository and know how it works very easily.

#### MainActivity


Get 5 books from each 6 genres 
 - Science fiction
 - Romance
 - Mystery
 - Horror
 - Travel
 - Art

<img src="https://github.com/Taishi-Y/Scribd/blob/master/images/screenshot.png?raw=true" 
alt="" width="180" border="10" />


#### SubActivity

After the user tapped the one book move to this Activity.

<img src="https://github.com/Taishi-Y/Scribd/blob/master/images/Screenshot_20161128-133435.png?raw=true" 
alt="" width="180" border="10" />

#### WevViewActivity

This activity use webview and Embedded Viewr API from Google. 
( https://developers.google.com/books/docs/viewer/developers_guide )

<img src="https://github.com/Taishi-Y/Scribd/blob/master/images/Screenshot_20161128-133445.png?raw=true" 
alt="" width="180" border="10" />

## Setup

1. We need to put INTERNET permisison line and some of Activities.
AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="com.taishi.scribd">

    <uses-permission android:name="android.permission.INTERNET"/>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>

                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
        <activity android:name=".SubActivity">
        </activity>
        <activity android:name=".WebViewActivity"
                  android:theme="@style/AppTheme.NoActionBar">
        </activity>
       
    </application>

</manifest>
```
2. Add some dependencies on module level gradle file
```java
apply plugin: 'com.android.application'

android {
    compileSdkVersion 25
    buildToolsVersion "25.0.0"
    defaultConfig {
        applicationId "com.taishi.scribd"
        minSdkVersion 16
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:25.0.1'
    compile 'com.android.support:design:25.0.1'
    testCompile 'junit:junit:4.12'


    // add these line below
    compile 'com.android.support:cardview-v7:25.0.1'
    compile 'com.android.support:recyclerview-v7:25.0.1'
    compile 'org.jsoup:jsoup:1.8.3'
    compile 'com.github.bumptech.glide:glide:3.6.1'

    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
    provided 'org.glassfish:javax.annotation:10.0-b28'
}
```


## Make MainActivity

activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.DrawerLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true"
    tools:openDrawer="start">

    <include
        layout="@layout/app_bar_main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

    <android.support.design.widget.NavigationView
        android:id="@+id/nav_view"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:fitsSystemWindows="true"
        app:headerLayout="@layout/nav_header_main"
        app:menu="@menu/activity_main_drawer"/>

</android.support.v4.widget.DrawerLayout>
```

app_bar_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true"
    tools:context="com.taishi.scribd.MainActivity">

    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/AppTheme.AppBarOverlay">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            app:popupTheme="@style/AppTheme.PopupOverlay"/>

    </android.support.design.widget.AppBarLayout>

    <include layout="@layout/content_main"/>

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="@dimen/fab_margin"
        app:srcCompat="@drawable/ic_search_white_24dp"/>

</android.support.design.widget.CoordinatorLayout>
```

content_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/content_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_margin_4dp"
    android:paddingLeft="@dimen/activity_margin_4dp"
    android:paddingRight="@dimen/activity_margin_4dp"
    android:paddingTop="@dimen/activity_margin_4dp"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context="com.taishi.scribd.MainActivity"
    tools:showIn="@layout/app_bar_main">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/my_recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="none" />
</RelativeLayout>
```



