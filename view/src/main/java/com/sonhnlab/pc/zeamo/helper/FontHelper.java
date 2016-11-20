package com.sonhnlab.pc.zeamo.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class FontHelper {

    //region Property

    private static final LruCache<String, Typeface> sCache = new LruCache<>(6);

    //endregion

    //region Constructor

    private FontHelper() {

    }

    //endregion

    //region Public method

    public static Typeface getTypeface(Context context, String name) {
        Typeface typeface = sCache.get(name);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), "font/" + name);
            sCache.put(name, typeface);
        }
        return typeface;
    }

    //endregion
}
