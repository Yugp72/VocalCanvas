package com.vocalcanvas.android.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.vocalcanvas.android.data.local.VocalCanvasDatabase
import com.vocalcanvas.android.data.local.VocalMessageDao
import com.vocalcanvas.android.data.remote.MockVocalCanvasApi
import com.vocalcanvas.android.data.remote.VocalCanvasApi
import com.vocalcanvas.android.data.repository.VocalCanvasRepository
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    
    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext
    
    @Provides
    @Singleton
    fun provideVocalCanvasDatabase(context: Context): VocalCanvasDatabase {
        return Room.databaseBuilder(
            context,
            VocalCanvasDatabase::class.java,
            VocalCanvasDatabase.DATABASE_NAME
        ).build()
    }
    
    @Provides
    @Singleton
    fun provideVocalMessageDao(database: VocalCanvasDatabase): VocalMessageDao {
        return database.vocalMessageDao()
    }
    
    @Provides
    @Singleton
    fun provideVocalCanvasApi(): VocalCanvasApi {
        // Using mock API for demonstration
        // In production, this would be a Retrofit instance
        return MockVocalCanvasApi()
    }
    
    @Provides
    @Singleton
    fun provideVocalCanvasRepository(
        api: VocalCanvasApi,
        dao: VocalMessageDao
    ): VocalCanvasRepository {
        return VocalCanvasRepository(api, dao)
    }
    
    @Provides
    @Singleton
    fun provideVocalCanvasViewModelFactory(
        repository: VocalCanvasRepository
    ): com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory {
        return com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory(repository)
    }
}

