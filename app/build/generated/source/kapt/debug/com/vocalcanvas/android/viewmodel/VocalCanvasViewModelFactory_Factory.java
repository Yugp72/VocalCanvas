package com.vocalcanvas.android.viewmodel;

import com.vocalcanvas.android.data.repository.VocalCanvasRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class VocalCanvasViewModelFactory_Factory implements Factory<VocalCanvasViewModelFactory> {
  private final Provider<VocalCanvasRepository> repositoryProvider;

  public VocalCanvasViewModelFactory_Factory(Provider<VocalCanvasRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public VocalCanvasViewModelFactory get() {
    return newInstance(repositoryProvider.get());
  }

  public static VocalCanvasViewModelFactory_Factory create(
      Provider<VocalCanvasRepository> repositoryProvider) {
    return new VocalCanvasViewModelFactory_Factory(repositoryProvider);
  }

  public static VocalCanvasViewModelFactory newInstance(VocalCanvasRepository repository) {
    return new VocalCanvasViewModelFactory(repository);
  }
}
