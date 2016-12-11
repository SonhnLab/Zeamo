package com.sonhnlab.pc.zeamo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sonhnlab.pc.core.view.BaseFragment;
import com.sonhnlab.pc.zeamo.R;

/**
 * Created by SonhnLab on 12/11/2016.
 */

public class SearchContainerFragment extends BaseFragment {

    //region Property

    private boolean mIsViewInit;

    //endregion

    //region Constructor

    public static SearchContainerFragment newInstance() {
        return new SearchContainerFragment();
    }

    //endregion

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_container, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!mIsViewInit) {
            mIsViewInit = true;
            initView();
        }
    }

    //endregion

    //region Private method

    private void initView() {
        replaceFragment(new SearchFragment(), false);
    }

    //endregion
}
