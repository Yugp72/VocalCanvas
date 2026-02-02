package com.vocalcanvas.android.di;

import android.app.Application;
import android.content.Context;
import com.vocalcanvas.android.VocalCanvasApplication;
import com.vocalcanvas.android.data.local.VocalCanvasDatabase;
import com.vocalcanvas.android.data.local.VocalMessageDao;
import com.vocalcanvas.android.data.remote.VocalCanvasApi;
import com.vocalcanvas.android.data.repository.VocalCanvasRepository;
import com.vocalcanvas.android.ui.MainActivity;
import com.vocalcanvas.android.viewmodel.VocalCanvasViewModelFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DaggerAppComponent {
  private DaggerAppComponent() {
  }

  public static AppComponent.Factory factory() {
    return new Factory();
  }

  private static final class Factory implements AppComponent.Factory {
    @Override
    public AppComponent create(Application application) {
      Preconditions.checkNotNull(application);
      return new AppComponentImpl(new AppModule(), application);
    }
  }

  private static final class AppComponentImpl implements AppComponent {
    private final AppComponentImpl appComponentImpl = this;

    private Provider<VocalCanvasApi> provideVocalCanvasApiProvider;

    private Provider<Application> applicationProvider;

    private Provider<Context> provideContextProvider;

    private Provider<VocalCanvasDatabase> provideVocalCanvasDatabaseProvider;

    private Provider<VocalMessageDao> provideVocalMessageDaoProvider;

    private Provider<VocalCanvasRepository> provideVocalCanvasRepositoryProvider;

    private Provider<VocalCanvasViewModelFactory> provideVocalCanvasViewModelFactoryProvider;

    private AppComponentImpl(AppModule appModuleParam, Application applicationParam) {

      initialize(appModuleParam, applicationParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final AppModule appModuleParam, final Application applicationParam) {
      this.provideVocalCanvasApiProvider = DoubleCheck.provider(AppModule_ProvideVocalCanvasApiFactory.create(appModuleParam));
      this.applicationProvider = InstanceFactory.create(applicationParam);
      this.provideContextProvider = DoubleCheck.provider(AppModule_ProvideContextFactory.create(appModuleParam, applicationProvider));
      this.provideVocalCanvasDatabaseProvider = DoubleCheck.provider(AppModule_ProvideVocalCanvasDatabaseFactory.create(appModuleParam, provideContextProvider));
      this.provideVocalMessageDaoProvider = DoubleCheck.provider(AppModule_ProvideVocalMessageDaoFactory.create(appModuleParam, provideVocalCanvasDatabaseProvider));
      this.provideVocalCanvasRepositoryProvider = DoubleCheck.provider(AppModule_ProvideVocalCanvasRepositoryFactory.create(appModuleParam, provideVocalCanvasApiProvider, provideVocalMessageDaoProvider));
      this.provideVocalCanvasViewModelFactoryProvider = DoubleCheck.provider(AppModule_ProvideVocalCanvasViewModelFactoryFactory.create(appModuleParam, provideVocalCanvasRepositoryProvider));
    }

    @Override
    public void inject(VocalCanvasApplication application) {
    }

    @Override
    public void inject(MainActivity activity) {
    }

    @Override
    public VocalCanvasViewModelFactory viewModelFactory() {
      return provideVocalCanvasViewModelFactoryProvider.get();
    }
  }
}
