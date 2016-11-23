package com.sonhnlab.pc.zeamo;

import com.sonhnlab.pc.core.di.ViewModelModule;
import com.sonhnlab.pc.zeamo.activities.CreateAccountActivity;
import com.sonhnlab.pc.zeamo.activities.ForgotPasswordActivity;
import com.sonhnlab.pc.zeamo.activities.LoginActivity;
import com.sonhnlab.pc.zeamo.activities.WelcomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by SonhnLab on 11/20/2016.
 */

@Singleton
@Component(modules = {ViewModelModule.class })
public interface AppComponent {

    void inject(WelcomeActivity welcomeActivity);
    void inject(LoginActivity loginActivity);
    void inject(CreateAccountActivity createAccountActivity);
    void inject(ForgotPasswordActivity forgotPasswordActivity);
}
