package com.sonhnlab.pc.zeamo.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.sonhnlab.pc.core.helper.Validator;
import com.sonhnlab.pc.core.view.RefreshDataListener;

import java.util.List;

/**
 * Created by SonhnLab on 12/4/2016.
 */

public class FragmentHelper {

    //region Constructor

    private FragmentHelper() {

    }

    //endregion

    //region Public method

    public static Fragment getFragment(FragmentManager manager, int position) {
        List<Fragment> fragments = manager.getFragments();
        if (!Validator.validCollection(fragments)) {
            return null;
        }

        if (position < 0 || position >= fragments.size()) {
            return null;
        }
        return fragments.get(position);
    }

    public static RefreshDataListener getRefreshDataListener(FragmentManager manager, int position) {
        return (RefreshDataListener) getFragment(manager, position);
    }

    //endregion
}
