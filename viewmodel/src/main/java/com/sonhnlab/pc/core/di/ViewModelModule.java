package com.sonhnlab.pc.core.di;

import com.sonhnlab.pc.core.view.INavigator;
import com.sonhnlab.pc.core.viewmodel.AccountViewModel;
import com.sonhnlab.pc.core.viewmodel.BookingsViewModel;
import com.sonhnlab.pc.core.viewmodel.CreateAccountViewModel;
import com.sonhnlab.pc.core.viewmodel.FavoritesViewModel;
import com.sonhnlab.pc.core.viewmodel.ForgotPasswordViewModel;
import com.sonhnlab.pc.core.viewmodel.InsuranceViewModel;
import com.sonhnlab.pc.core.viewmodel.LoginViewModel;
import com.sonhnlab.pc.core.viewmodel.MainViewModel;
import com.sonhnlab.pc.core.viewmodel.PlaceViewModel;
import com.sonhnlab.pc.core.viewmodel.SportViewModel;
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

    @Provides
    @Singleton
    CreateAccountViewModel providesCreateAccountViewModel (INavigator navigator) {
        return new CreateAccountViewModel(navigator);
    }

    @Provides
    @Singleton
    ForgotPasswordViewModel providesForgotPasswordViewModel (INavigator navigator) {
        return new ForgotPasswordViewModel(navigator);
    }

    @Provides
    @Singleton
    MainViewModel providesMainViewModel (INavigator navigator) {
        return new MainViewModel(navigator);
    }

    @Provides
    @Singleton
    SportViewModel providesSearchViewModel (INavigator navigator) {
        return new SportViewModel(navigator);
    }

    @Provides
    @Singleton
    BookingsViewModel providesBookingsViewModel (INavigator navigator) {
        return new BookingsViewModel(navigator);
    }

    @Provides
    @Singleton
    FavoritesViewModel providesFavoritesViewModel (INavigator navigator) {
        return new FavoritesViewModel(navigator);
    }

    @Provides
    @Singleton
    InsuranceViewModel providesInsuranceViewModel (INavigator navigator) {
        return new InsuranceViewModel(navigator);
    }

    @Provides
    @Singleton
    AccountViewModel providesAccountViewModel (INavigator navigator) {
        return new AccountViewModel(navigator);
    }

    @Provides
    @Singleton
    PlaceViewModel providesPlaceViewModel (INavigator navigator) {
        return new PlaceViewModel(navigator);
    }

    //endregion
}
