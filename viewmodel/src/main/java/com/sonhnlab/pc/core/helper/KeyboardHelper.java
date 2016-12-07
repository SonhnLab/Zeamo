package com.sonhnlab.pc.core.helper;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
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

    public static void showSoftKeyboard(Context context, View viewFocus) {
        if (viewFocus != null) {
            InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.toggleSoftInputFromWindow(viewFocus.getWindowToken(), InputMethodManager.SHOW_FORCED, 0);
        }
    }

    public static void hideSoftKeyboardOnTap(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static void hideSoftKeyboard(Context context, IBinder windowToken) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(windowToken,0);
    }

    //endregion
}
