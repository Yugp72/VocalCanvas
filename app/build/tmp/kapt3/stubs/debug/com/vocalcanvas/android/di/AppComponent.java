package com.vocalcanvas.android.di;

import android.app.Application;
import com.vocalcanvas.android.VocalCanvasApplication;
import com.vocalcanvas.android.ui.MainActivity;
import com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;

@javax.inject.Singleton
@dagger.Component(modules = {com.vocalcanvas.android.di.AppModule.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/vocalcanvas/android/di/AppComponent;", "", "inject", "", "application", "Lcom/vocalcanvas/android/VocalCanvasApplication;", "activity", "Lcom/vocalcanvas/android/ui/MainActivity;", "viewModelFactory", "Lcom/vocalcanvas/android/viewmodel/VocalCanvasViewModelFactory;", "Factory", "app_debug"})
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.VocalCanvasApplication application);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull
    com.vocalcanvas.android.ui.MainActivity activity);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory viewModelFactory();
    
    @dagger.Component.Factory
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/vocalcanvas/android/di/AppComponent$Factory;", "", "create", "Lcom/vocalcanvas/android/di/AppComponent;", "application", "Landroid/app/Application;", "app_debug"})
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.vocalcanvas.android.di.AppComponent create(@dagger.BindsInstance
        @org.jetbrains.annotations.NotNull
        android.app.Application application);
    }
}