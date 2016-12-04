package com.sonhnlab.pc.zeamo.adapter.binding;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;

import com.sonhnlab.pc.core.helper.Validator;
import com.sonhnlab.pc.core.view.RefreshDataListener;
import com.sonhnlab.pc.zeamo.adapter.TabAdapter;
import com.sonhnlab.pc.zeamo.helper.FragmentHelper;

/**
 * Created by SonhnLab on 12/4/2016.
 */

public class ViewPagerBindingAdapter {

    public interface OnPageSelected {

        void onPageSelected(int position);

    }

    @BindingAdapter(value = {"onPageChanged"})
    public static void setListener(ViewPager viewPager, boolean enabled) {
        if (!enabled) {
            return;
        }
        final TabAdapter adapter = (TabAdapter) viewPager.getAdapter();
        if (!Validator.validNotNull(adapter)) {
            return;
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RefreshDataListener listener = FragmentHelper.getRefreshDataListener(
                        adapter.getFragmentManager(),
                        position
                );
                if (Validator.validNotNull(listener)) {
                    listener.onLoad();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
    }

    @BindingAdapter(value = {"currentItem"})
    public static void setCurrentItem(ViewPager viewPager, int position) {
        if (position >= 0 && position < viewPager.getAdapter().getCount()) {
            viewPager.setCurrentItem(position, false);
        }
    }

}
