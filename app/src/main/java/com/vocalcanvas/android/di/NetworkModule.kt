package com.vocalcanvas.android.di

import com.vocalcanvas.android.data.remote.VocalCanvasApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Network module for providing Retrofit and OkHttp instances.
 * Currently configured to use MockVocalCanvasApi, but can be easily
 * switched to real API endpoints by changing the base URL.
 */
@Module
class NetworkModule {
    
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.vocalcanvas.example.com/") // Mock base URL
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    
    /**
     * In production, uncomment this and remove MockVocalCanvasApi from AppModule
     */
    /*
    @Provides
    @Singleton
    fun provideVocalCanvasApi(retrofit: Retrofit): VocalCanvasApi {
        return retrofit.create(VocalCanvasApi::class.java)
    }
    */
}

