package com.faranjit.hilt.mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Bulent Turkmen on 9.10.2021.
 */
@HiltAndroidApp
class MvvmApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}