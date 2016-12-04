package com.sonhnlab.pc.zeamo.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by SonhnLab on 11/27/2016.
 */

public class HoldViewPager extends ViewPager {

    //region Property

    private boolean swipeEnabled;

    //endregion

    //region Getter and Setter

    public boolean isSwipeEnabled() {
        return swipeEnabled;
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.swipeEnabled = swipeEnabled;
    }

    //endregion

    //region Constructor

    public HoldViewPager(Context context) {
        super(context);
    }

    public HoldViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //endregion

    //region Override method

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return swipeEnabled && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return swipeEnabled && super.onInterceptTouchEvent(ev);
    }

    //endregion
}
