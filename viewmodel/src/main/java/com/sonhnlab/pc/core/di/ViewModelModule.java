package com.sonhnlab.pc.core.di;

import com.sonhnlab.pc.core.view.INavigator;
import com.sonhnlab.pc.core.viewmodel.LoginViewModel;
import com.sonhnlab.pc.core.viewmodel.WelcomeViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by SonhnLab on 11/20/2016.
 */

@Module(includes = { CloudModule.class, StorageModule.class })
public class ViewModelModule {

    //region Provide methods

    @Provides
    @Singleton
    WelcomeViewModel providesWelcomeViewModel (INavigator navigator) {
        return new WelcomeViewModel(navigator);
    }

    @Provides
    @Singleton
    LoginViewModel providesLoginViewModel (INavigator navigator) {
        return new LoginViewModel(navigator);
    }

    //endregion
}