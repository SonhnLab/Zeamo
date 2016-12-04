package com.sonhnlab.pc.core.viewmodel;

import com.sonhnlab.pc.core.utility.Constants;
import com.sonhnlab.pc.core.view.INavigator;
import com.sonhnlab.pc.core.viewmodel.base.BaseViewModel;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class LoginViewModel extends BaseViewModel {

    //region Properties


    //endregion

    //region Getters and Setters


    //endregion

    //region Constructors

    public LoginViewModel(INavigator navigator) {
        super(navigator);
    }


    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //endregion

    //region Private methods


    //endregion

    //region Public methods

    public void showForgotPasswordPageCommand() {
        getNavigator().navigateTo(Constants.FORGOT_PASSWORD_PAGE);
    }

    public void showMainPageCommand() {
        getNavigator().navigateTo(Constants.MAIN_PAGE);
    }

    //endregion
}
