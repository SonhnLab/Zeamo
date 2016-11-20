package com.sonhnlab.pc.core.view;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.multidex.MultiDexApplication;

import java.util.concurrent.TimeUnit;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class BaseApplication extends MultiDexApplication implements Application.ActivityLifecycleCallbacks {

    //region Properties

    private Activity mCurrentActivity;

    //endregion

    //region Setters and Getters

    public Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    public boolean isCurrentActivityAvailable() {
        return mCurrentActivity != null;
    }

    //endregion

    //region Application Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }

    //endregion

    //region ActivityLifecycleCallback implements

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (mCurrentActivity != activity) {
            mCurrentActivity = activity;
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if (mCurrentActivity != activity) {
            mCurrentActivity = activity;
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    //endregion
}
