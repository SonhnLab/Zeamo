package com.sonhnlab.pc.core.view;

import android.app.Dialog;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import com.sonhnlab.pc.core.helper.Validator;
import com.sonhnlab.pc.core.viewmodel.base.BaseViewModel;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by SonhnLab on 12/5/2016.
 */

public class BaseDialogFragment<B extends ViewDataBinding, V extends BaseViewModel> extends DialogFragment {

    //region Property

    protected B mViewDataBinding;

    @Inject
    protected V mViewModel;

    //endregion

    //region Lifecycle

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Validator.validNotNull(mViewModel)) {
            mViewModel.onCreate();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (Validator.validNotNull(mViewModel)) {
            mViewModel.onStart();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (Validator.validNotNull(mViewModel)) {
            mViewModel.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (Validator.validNotNull(mViewModel)) {
            mViewModel.onDestroy();
        }
    }

    //endregion

    //region Protected method

    protected final void scaleSize(float dx, float dy) {
        int width = (int) (getResources().getDisplayMetrics().widthPixels * dx);
        int height = (int) (getResources().getDisplayMetrics().heightPixels * dy);

        scaleSize(width, height);
    }

    protected final void scaleSize(int width, int height) {
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(width, height);
        }
    }

    //endregion

    //region Protected method

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

    //endregion
}
