package com.sonhnlab.pc.core.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

import com.sonhnlab.pc.core.R;
import com.sonhnlab.pc.core.helper.Validator;
import com.sonhnlab.pc.core.viewmodel.base.BaseViewModel;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class BaseFragment<B extends ViewDataBinding, V extends BaseViewModel> extends Fragment implements RefreshDataListener {

    //region Properties

    private B mViewDataBinding;

    @Inject
    protected V mViewModel;

    //endregion

    //region Getter and Setter

    public B getViewDataBinding() {
        return mViewDataBinding;
    }

    public void setViewDataBinding(B viewDataBinding) {
        mViewDataBinding = viewDataBinding;
    }

    //endregion

    //region Lifecycle

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && Validator.validNotNull(mViewModel)) {
            mViewModel.onResult(requestCode);
        }
    }

    //endregion

    //region Override method

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        super.onPrepareOptionsMenu(menu);
    }

    //endregion

    //region Protected Methods

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

    //region RefreshDataListener implement

    @Override
    public void onLoad() {

    }

    @Override
    public void onRefresh() {

    }

    //endregion

    //region Public method

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(R.id.layout_container, fragment);
        transaction.commit();
        getChildFragmentManager().executePendingTransactions();
    }

    public boolean popFragment() {
        boolean isPop = false;
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            isPop = true;
            getChildFragmentManager().popBackStack();
        }
        return isPop;
    }

    //endregion
}
