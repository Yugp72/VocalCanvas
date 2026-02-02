package com.vocalcanvas.android.di;

import com.vocalcanvas.android.data.repository.VocalCanvasRepository;
import com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory;
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
public final class AppModule_ProvideVocalCanvasViewModelFactoryFactory implements Factory<VocalCanvasViewModelFactory> {
  private final AppModule module;

  private final Provider<VocalCanvasRepository> repositoryProvider;

  public AppModule_ProvideVocalCanvasViewModelFactoryFactory(AppModule module,
      Provider<VocalCanvasRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public VocalCanvasViewModelFactory get() {
    return provideVocalCanvasViewModelFactory(module, repositoryProvider.get());
  }

  public static AppModule_ProvideVocalCanvasViewModelFactoryFactory create(AppModule module,
      Provider<VocalCanvasRepository> repositoryProvider) {
    return new AppModule_ProvideVocalCanvasViewModelFactoryFactory(module, repositoryProvider);
  }

  public static VocalCanvasViewModelFactory provideVocalCanvasViewModelFactory(AppModule instance,
      VocalCanvasRepository repository) {
    return Preconditions.checkNotNullFromProvides(instance.provideVocalCanvasViewModelFactory(repository));
  }
}
