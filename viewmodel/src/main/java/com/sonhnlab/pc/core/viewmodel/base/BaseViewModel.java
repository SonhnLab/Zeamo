package com.sonhnlab.pc.core.viewmodel.base;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.sonhnlab.pc.core.view.INavigator;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public abstract class BaseViewModel extends BaseObservable implements IViewModelLifecycle {

    //region Properties

    private INavigator mNavigator;

    //endregion

    //region Setters and Getters

    protected Activity getCurrentActivity() {
        return getNavigator().getApplication().getCurrentActivity();
    }

    protected String getString(@StringRes int resId) {
        return getCurrentActivity().getString(resId);
    }

    protected INavigator getNavigator() {
        return mNavigator;
    }

    //endregion

    //region Constructors;

    protected BaseViewModel(INavigator navigator) {
        mNavigator = navigator;
    }

    protected BaseViewModel() {
        super();
    }

    //endregion

    //region IViewModelLifecycle implements

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onResult(int requestCode) {

    }

    //endregion

    //region Command

    public void goBackCommand() {
        getNavigator().goBack();
    }

    //endregion

    //region Protected methods

    protected static final void post(Object event) {
        EventBus.getDefault().post(event);
    }

    protected  static final void postSticky(Object event) {
        EventBus.getDefault().postSticky(event);
    }

    protected final void register() {
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    protected final void unregister() {
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(this)) {
            eventBus.unregister(this);
        }

    }

    protected final void showMessage(String message) {
        Toast.makeText(getNavigator().getApplication().getCurrentActivity(), message, Toast.LENGTH_LONG).show();
    }


    //endregion
}
