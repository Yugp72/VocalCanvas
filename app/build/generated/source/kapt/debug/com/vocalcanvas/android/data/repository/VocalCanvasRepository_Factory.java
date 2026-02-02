package com.vocalcanvas.android.data.repository;

import com.vocalcanvas.android.data.local.VocalMessageDao;
import com.vocalcanvas.android.data.remote.VocalCanvasApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class VocalCanvasRepository_Factory implements Factory<VocalCanvasRepository> {
  private final Provider<VocalCanvasApi> apiProvider;

  private final Provider<VocalMessageDao> daoProvider;

  public VocalCanvasRepository_Factory(Provider<VocalCanvasApi> apiProvider,
      Provider<VocalMessageDao> daoProvider) {
    this.apiProvider = apiProvider;
    this.daoProvider = daoProvider;
  }

  @Override
  public VocalCanvasRepository get() {
    return newInstance(apiProvider.get(), daoProvider.get());
  }

  public static VocalCanvasRepository_Factory create(Provider<VocalCanvasApi> apiProvider,
      Provider<VocalMessageDao> daoProvider) {
    return new VocalCanvasRepository_Factory(apiProvider, daoProvider);
  }

  public static VocalCanvasRepository newInstance(VocalCanvasApi api, VocalMessageDao dao) {
    return new VocalCanvasRepository(api, dao);
  }
}
