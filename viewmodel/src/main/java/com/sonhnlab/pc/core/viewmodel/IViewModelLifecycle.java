package com.sonhnlab.pc.core.viewmodel;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public interface IViewModelLifecycle {

    void onCreate();
    void onStart();
    void onStop();
    void onDestroy();

}
