package com.vocalcanvas.android.di;

import com.vocalcanvas.android.data.local.VocalMessageDao;
import com.vocalcanvas.android.data.remote.VocalCanvasApi;
import com.vocalcanvas.android.data.repository.VocalCanvasRepository;
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
public final class AppModule_ProvideVocalCanvasRepositoryFactory implements Factory<VocalCanvasRepository> {
  private final AppModule module;

  private final Provider<VocalCanvasApi> apiProvider;

  private final Provider<VocalMessageDao> daoProvider;

  public AppModule_ProvideVocalCanvasRepositoryFactory(AppModule module,
      Provider<VocalCanvasApi> apiProvider, Provider<VocalMessageDao> daoProvider) {
    this.module = module;
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public VocalCanvasRepository get() {
    return provideVocalCanvasRepository(module, apiProvider.get(), daoProvider.get());
  }

  public static AppModule_ProvideVocalCanvasRepositoryFactory create(AppModule module,
      Provider<VocalCanvasApi> apiProvider, Provider<VocalMessageDao> daoProvider) {
    return new AppModule_ProvideVocalCanvasRepositoryFactory(module, apiProvider, daoProvider);
  }

  public static VocalCanvasRepository provideVocalCanvasRepository(AppModule instance,
      VocalCanvasApi api, VocalMessageDao dao) {
    return Preconditions.checkNotNullFromProvides(instance.provideVocalCanvasRepository(api, dao));
  }
}
