package com.vocalcanvas.android

import android.app.Application
import com.vocalcanvas.android.di.DaggerAppComponent

class VocalCanvasApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory()
            .create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}

