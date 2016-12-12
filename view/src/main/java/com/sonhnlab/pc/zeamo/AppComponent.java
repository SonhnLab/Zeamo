package com.sonhnlab.pc.zeamo;

import com.sonhnlab.pc.core.di.ViewModelModule;
import com.sonhnlab.pc.zeamo.activities.CreateAccountActivity;
import com.sonhnlab.pc.zeamo.activities.ForgotPasswordActivity;
import com.sonhnlab.pc.zeamo.activities.LoginActivity;
import com.sonhnlab.pc.zeamo.activities.MainActivity;
import com.sonhnlab.pc.zeamo.activities.WelcomeActivity;
import com.sonhnlab.pc.zeamo.fragment.AccountFragment;
import com.sonhnlab.pc.zeamo.fragment.BookingsFragment;
import com.sonhnlab.pc.zeamo.fragment.FavoritesFragment;
import com.sonhnlab.pc.zeamo.fragment.InsuranceFragment;
import com.sonhnlab.pc.zeamo.fragment.SearchFragment;
import com.sonhnlab.pc.zeamo.fragment.SearchResultFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by SonhnLab on 11/20/2016.
 */

@Singleton
@Component(modules = {ViewModelModule.class })
public interface AppComponent {

    //region Activity

    void inject(WelcomeActivity welcomeActivity);
    void inject(LoginActivity loginActivity);
    void inject(CreateAccountActivity createAccountActivity);
    void inject(ForgotPasswordActivity forgotPasswordActivity);
    void inject(MainActivity mainActivity);

    //endregion

    //region Fragment

    void inject(SearchFragment searchFragment);
    void inject(BookingsFragment bookingsFragment);
    void inject(FavoritesFragment favoritesFragment);
    void inject(InsuranceFragment insuranceFragment);
    void inject(AccountFragment accountFragment);
    void inject(SearchResultFragment searchResultFragment);

    //endregion
}
