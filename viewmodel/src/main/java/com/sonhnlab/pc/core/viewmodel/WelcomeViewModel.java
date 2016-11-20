package com.sonhnlab.pc.core.viewmodel;

import com.sonhnlab.pc.core.utility.Constants;
import com.sonhnlab.pc.core.view.INavigator;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class WelcomeViewModel extends BaseViewModel {

    //region Properties


    //endregion

    //region Getters and Setters


    //endregion

    //region Constructors

    public WelcomeViewModel(INavigator navigator) {
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

    public void showCreateAccountPageCommand() {
        getNavigator().navigateTo(Constants.CREATE_ACCOUNT_PAGE);
    }

    public void showLoginPageCommand() {
        getNavigator().navigateTo(Constants.LOGIN_PAGE);
    }

    //endregion

}
