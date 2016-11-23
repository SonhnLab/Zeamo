package com.sonhnlab.pc.core.utility;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class Constants {

    //region Constructor

    private Constants() {

    }

    //endregion

    //region Pages

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            WELCOME_PAGE, CREATE_ACCOUNT_PAGE, LOGIN_PAGE, FORGOT_PASSWORD_PAGE

    })
    public @interface PageKey {}

    public static final int WELCOME_PAGE = 0;
    public static final int CREATE_ACCOUNT_PAGE = 1;
    public static final int LOGIN_PAGE = 2;
    public static final int FORGOT_PASSWORD_PAGE = 3;

    //endregion

    //region Codes


    //endregion
}
