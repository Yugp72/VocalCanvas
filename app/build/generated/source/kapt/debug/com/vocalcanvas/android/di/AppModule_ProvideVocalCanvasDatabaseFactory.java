package com.vocalcanvas.android.di;

import android.content.Context;
import com.vocalcanvas.android.data.local.VocalCanvasDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppModule_ProvideVocalCanvasDatabaseFactory implements Factory<VocalCanvasDatabase> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideVocalCanvasDatabaseFactory(AppModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public VocalCanvasDatabase get() {
    return provideVocalCanvasDatabase(module, contextProvider.get());
  }

  public static AppModule_ProvideVocalCanvasDatabaseFactory create(AppModule module,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideVocalCanvasDatabaseFactory(module, contextProvider);
  }

  public static VocalCanvasDatabase provideVocalCanvasDatabase(AppModule instance,
      Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideVocalCanvasDatabase(context));
  }
}
