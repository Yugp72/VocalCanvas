package com.vocalcanvas.android.di;

import com.vocalcanvas.android.data.remote.VocalCanvasApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideVocalCanvasApiFactory implements Factory<VocalCanvasApi> {
  private final AppModule module;

  public AppModule_ProvideVocalCanvasApiFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public VocalCanvasApi get() {
    return provideVocalCanvasApi(module);
  }

  public static AppModule_ProvideVocalCanvasApiFactory create(AppModule module) {
    return new AppModule_ProvideVocalCanvasApiFactory(module);
  }

  public static VocalCanvasApi provideVocalCanvasApi(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideVocalCanvasApi());
  }
}
