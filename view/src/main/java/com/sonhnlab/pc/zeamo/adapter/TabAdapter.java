package com.sonhnlab.pc.zeamo.adapter;

import android.databinding.ObservableList;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by SonhnLab on 11/27/2016.
 */

public abstract class TabAdapter<T> extends FragmentStatePagerAdapter {

    //region Property

    private FragmentManager mFragmentManager;

    private ObservableList<T> mData;

    //endregion

    //region Getter and Setter

    public FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

    public void setData(ObservableList<T> data) {
        if (mData != data) {
            mData = data;

            notifyDataSetChanged();
        }
    }

    public ObservableList<T> getData() {
        return mData;
    }

    //endregion

    //region Constructor

    public TabAdapter(FragmentManager fm) {
        super(fm);

        mFragmentManager = fm;
    }

    //endregion
}
