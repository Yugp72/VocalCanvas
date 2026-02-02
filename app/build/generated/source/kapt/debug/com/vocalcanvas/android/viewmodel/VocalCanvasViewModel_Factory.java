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
public final class VocalCanvasViewModel_Factory implements Factory<VocalCanvasViewModel> {
  private final Provider<VocalCanvasRepository> repositoryProvider;

  public VocalCanvasViewModel_Factory(Provider<VocalCanvasRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public VocalCanvasViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static VocalCanvasViewModel_Factory create(
      Provider<VocalCanvasRepository> repositoryProvider) {
    return new VocalCanvasViewModel_Factory(repositoryProvider);
  }

  public static VocalCanvasViewModel newInstance(VocalCanvasRepository repository) {
    return new VocalCanvasViewModel(repository);
  }
}
