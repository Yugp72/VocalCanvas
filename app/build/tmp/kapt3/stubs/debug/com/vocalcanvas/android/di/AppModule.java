package com.vocalcanvas.android.di;

import android.app.Application;
import android.content.Context;
import androidx.room.Room;
import com.vocalcanvas.android.data.local.VocalCanvasDatabase;
import com.vocalcanvas.android.data.local.VocalMessageDao;
import com.vocalcanvas.android.data.remote.MockVocalCanvasApi;
import com.vocalcanvas.android.data.remote.VocalCanvasApi;
import com.vocalcanvas.android.data.repository.VocalCanvasRepository;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0007J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\nH\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/vocalcanvas/android/di/AppModule;", "", "()V", "provideContext", "Landroid/content/Context;", "application", "Landroid/app/Application;", "provideVocalCanvasApi", "Lcom/vocalcanvas/android/data/remote/VocalCanvasApi;", "provideVocalCanvasDatabase", "Lcom/vocalcanvas/android/data/local/VocalCanvasDatabase;", "context", "provideVocalCanvasRepository", "Lcom/vocalcanvas/android/data/repository/VocalCanvasRepository;", "api", "dao", "Lcom/vocalcanvas/android/data/local/VocalMessageDao;", "provideVocalCanvasViewModelFactory", "Lcom/vocalcanvas/android/viewmodel/VocalCanvasViewModelFactory;", "repository", "provideVocalMessageDao", "database", "app_debug"})
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final android.content.Context provideContext(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vocalcanvas.android.data.local.VocalCanvasDatabase provideVocalCanvasDatabase(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vocalcanvas.android.data.local.VocalMessageDao provideVocalMessageDao(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.data.local.VocalCanvasDatabase database) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vocalcanvas.android.data.remote.VocalCanvasApi provideVocalCanvasApi() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vocalcanvas.android.data.repository.VocalCanvasRepository provideVocalCanvasRepository(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.data.remote.VocalCanvasApi api, @org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.data.local.VocalMessageDao dao) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory provideVocalCanvasViewModelFactory(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.data.repository.VocalCanvasRepository repository) {
        return null;
    }
}