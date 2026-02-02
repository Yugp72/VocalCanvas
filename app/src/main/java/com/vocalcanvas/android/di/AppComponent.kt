package com.vocalcanvas.android.di

import android.app.Application
import com.vocalcanvas.android.VocalCanvasApplication
import com.vocalcanvas.android.ui.MainActivity
import com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    
    fun inject(application: VocalCanvasApplication)
    fun inject(activity: MainActivity)
    
    fun viewModelFactory(): VocalCanvasViewModelFactory
    
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}

