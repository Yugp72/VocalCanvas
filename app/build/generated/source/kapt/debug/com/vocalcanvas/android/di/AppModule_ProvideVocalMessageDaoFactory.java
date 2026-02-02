package com.vocalcanvas.android.di;

import com.vocalcanvas.android.data.local.VocalCanvasDatabase;
import com.vocalcanvas.android.data.local.VocalMessageDao;
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
public final class AppModule_ProvideVocalMessageDaoFactory implements Factory<VocalMessageDao> {
  private final AppModule module;

  private final Provider<VocalCanvasDatabase> databaseProvider;

  public AppModule_ProvideVocalMessageDaoFactory(AppModule module,
      Provider<VocalCanvasDatabase> databaseProvider) {
    this.module = module;
    this.databaseProvider = databaseProvider;
  }

  @Override
  public VocalMessageDao get() {
    return provideVocalMessageDao(module, databaseProvider.get());
  }

  public static AppModule_ProvideVocalMessageDaoFactory create(AppModule module,
      Provider<VocalCanvasDatabase> databaseProvider) {
    return new AppModule_ProvideVocalMessageDaoFactory(module, databaseProvider);
  }

  public static VocalMessageDao provideVocalMessageDao(AppModule instance,
      VocalCanvasDatabase database) {
    return Preconditions.checkNotNullFromProvides(instance.provideVocalMessageDao(database));
  }
}
