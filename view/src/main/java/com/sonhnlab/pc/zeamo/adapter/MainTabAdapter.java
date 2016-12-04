package com.sonhnlab.pc.zeamo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.sonhnlab.pc.zeamo.fragment.AccountFragment;
import com.sonhnlab.pc.zeamo.fragment.BookingsFragment;
import com.sonhnlab.pc.zeamo.fragment.FavoritesFragment;
import com.sonhnlab.pc.zeamo.fragment.InsuranceFragment;
import com.sonhnlab.pc.zeamo.fragment.SearchFragment;

/**
 * Created by SonhnLab on 11/27/2016.
 */

public class MainTabAdapter extends TabAdapter {

    //region Constructor

    public MainTabAdapter(FragmentManager fm) {
        super(fm);
    }

    //endregion

    //region Override method

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SearchFragment.newInstance();
            case 1:
                return BookingsFragment.newInstance();
            case 2:
                return FavoritesFragment.newInstance();
            case 3:
                return InsuranceFragment.newInstance();
            default:
                return AccountFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    //endregion
}
