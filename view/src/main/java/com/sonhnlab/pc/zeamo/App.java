package com.sonhnlab.pc.zeamo;

import com.sonhnlab.pc.core.di.AppModule;
import com.sonhnlab.pc.core.di.CloudModule;
import com.sonhnlab.pc.core.di.ViewModelModule;
import com.sonhnlab.pc.core.utility.Constants;
import com.sonhnlab.pc.core.view.BaseApplication;
import com.sonhnlab.pc.core.view.INavigator;
import com.sonhnlab.pc.zeamo.activities.CreateAccountActivity;
import com.sonhnlab.pc.zeamo.activities.ForgotPasswordActivity;
import com.sonhnlab.pc.zeamo.activities.LoginActivity;
import com.sonhnlab.pc.zeamo.activities.MainActivity;
import com.sonhnlab.pc.zeamo.activities.WelcomeActivity;

/**
 * Created by PC on 10/12/2016.
 */

public class App extends BaseApplication {

    //region Properties

    private static AppComponent sAppComponent;

    //endregion

    //region Getter and Setter

    public synchronized static AppComponent sharedComponent() {
        return sAppComponent;
    }

    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this);
        INavigator navigator = appModule.getNavigator();

        navigator.configure(Constants.WELCOME_PAGE, WelcomeActivity.class);
        navigator.configure(Constants.LOGIN_PAGE, LoginActivity.class);
        navigator.configure(Constants.CREATE_ACCOUNT_PAGE, CreateAccountActivity.class);
        navigator.configure(Constants.FORGOT_PASSWORD_PAGE, ForgotPasswordActivity.class);
        navigator.configure(Constants.MAIN_PAGE, MainActivity.class);

        sAppComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .cloudModule(new CloudModule())
                .viewModelModule(new ViewModelModule())
                .build();

    }

    //endregion
}
