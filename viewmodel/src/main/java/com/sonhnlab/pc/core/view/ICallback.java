package com.sonhnlab.pc.core.view;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public interface ICallback<T> {

    void onResult(T result);

    void onFailure(Throwable t);
}
