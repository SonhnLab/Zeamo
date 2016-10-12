package com.sonhnlab.pc.zeamo;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 10/12/2016.
 */

public class App extends Application {

    //region Override method

    @Override
    public void onCreate() {
        super.onCreate();

        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }

    //endregion
}
