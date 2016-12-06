package com.sonhnlab.pc.zeamo.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sonhnlab.pc.zeamo.R;

/**
 * Created by SonhnLab on 12/6/2016.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    //region Property

    private Drawable mDivider;

    //endregion

    //region Constructor

    public DividerItemDecoration(Context context) {
        mDivider = context.getResources().getDrawable(R.drawable.divider);
    }

    //endregion

    //region Override method

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    //endregion
}
