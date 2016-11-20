package com.sonhnlab.pc.core.helper;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class KeyboardHelper {

    //region Constructor

    public KeyboardHelper() {
    }

    //endregion

    //region Public method

    public static void hidden(Context context, View viewFocus) {
        if (viewFocus != null) {
            InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(viewFocus.getWindowToken(), 0);
        }
    }

    //endregion
}
