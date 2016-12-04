package com.sonhnlab.pc.core.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.sonhnlab.pc.core.helper.Validator;
import com.sonhnlab.pc.core.viewmodel.base.BaseViewModel;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public abstract class BaseActivity<B extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    //region Properties

    private Toolbar mToolbar;

    protected B mViewDataBinding;

    @Inject
    protected V mViewModel;

    //endregion

    //region Getter and Setter

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public B getViewDataBinding() {
        return mViewDataBinding;
    }

    //endregion

    //region Lifecycle

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState);
        if (Validator.validNotNull(mViewModel)) {
            mViewModel.onCreate();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Validator.validNotNull(mViewModel)) {
            mViewModel.onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (Validator.validNotNull(mViewModel)) {
            mViewModel.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (Validator.validNotNull(mViewModel)) {
            mViewModel.onDestroy();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && Validator.validNotNull(mViewModel)) {
            mViewModel.onResult(requestCode);
        }
    }

    //endregion

    //region Override method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (Validator.validNotNull(mViewModel)) {
                    mViewModel.goBackCommand();
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //endregion

    //region Protected method

    protected void setBindingContentView(int layoutResId, int variableId) {
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutResId);
        mViewDataBinding.setVariable(variableId, mViewModel);
    }

    protected void setToolbar(int resId, boolean isEnabledHome) {
        mToolbar = (Toolbar) findViewById(resId);
        if (Validator.validNotNull(mToolbar)) {
            setSupportActionBar(mToolbar);
        }

        if (isEnabledHome) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    protected void setTitle(int resId, int stringId) {
        setTitle(resId, getString(stringId));
    }

    protected void setTitle(int resId, String title) {
        setTitle("");

        TextView textView = (TextView) findViewById(resId);
        if (textView != null) {
            textView.setText(title);
        }
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

    protected final void post(Object object) {
        EventBus.getDefault()
                .post(object);
    }

    protected final void postSticky(Object object) {
        EventBus.getDefault()
                .postSticky(object);
    }

    protected final void removeSticky(Class classEvent) {
        Object event = EventBus.getDefault().getStickyEvent(classEvent);
        if (Validator.validNotNull(event)) {
            EventBus.getDefault().removeStickyEvent(event);
        }
    }

    //endregion

}
