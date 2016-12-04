package com.sonhnlab.pc.zeamo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.roughike.bottombar.OnTabSelectListener;
import com.sonhnlab.pc.core.BR;
import com.sonhnlab.pc.core.helper.Validator;
import com.sonhnlab.pc.core.view.BaseActivity;
import com.sonhnlab.pc.core.view.RefreshDataListener;
import com.sonhnlab.pc.core.viewmodel.MainViewModel;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.adapter.MainTabAdapter;
import com.sonhnlab.pc.zeamo.databinding.ActivityMainBinding;
import com.sonhnlab.pc.zeamo.helper.FragmentHelper;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel>{

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setBindingContentView(R.layout.activity_main, BR.viewModel);
        setToolbar(R.id.toolbar, false);
        setTitle(R.id.toolbar_title, R.string.search);

        ActivityMainBinding binding = getViewDataBinding();
        binding.holdViewPager.setOffscreenPageLimit(5);
        binding.holdViewPager.setSwipeEnabled(false);
        binding.holdViewPager.setAdapter(new MainTabAdapter(getSupportFragmentManager()));
        binding.bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                switchTab(tabId);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment fragment = FragmentHelper.getFragment(
                getSupportFragmentManager(),
                getViewDataBinding().holdViewPager.getCurrentItem()
        );
        if (Validator.validNotNull(fragment)) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }


    //endregion

    //region Override method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = FragmentHelper.getFragment(
                getSupportFragmentManager(),
                getViewDataBinding().holdViewPager.getCurrentItem()
        );
        if (Validator.validNotNull(fragment)) {
            fragment.onOptionsItemSelected(item);
        }
        return true;
    }

    //endregion

    //region Private method

    private void switchTab(int tabId) {
        ViewPager viewPager = getViewDataBinding().holdViewPager;
        switch (tabId) {
            case R.id.tab_search:
                viewPager.setCurrentItem(0, false);

                setTitle(R.id.toolbar_title, R.string.search);
                setNavigationIcon(-1);
                setTitleIcon(-1);
                break;
            case R.id.tab_bookings:
                viewPager.setCurrentItem(1, false);

                setTitle(R.id.toolbar_title, R.string.bookings);
                setNavigationIcon(-1);
                setTitleIcon(-1);
                break;
            case R.id.tab_favorites:
                viewPager.setCurrentItem(2, false);

                setTitle(R.id.toolbar_title, R.string.favorites);
                setNavigationIcon(-1);
                setTitleIcon(-1);
                break;
            case R.id.tab_insurance:
                viewPager.setCurrentItem(3, false);

                setTitle(R.id.toolbar_title, R.string.insurance);
                setNavigationIcon(-1);
                setTitleIcon(-1);
                break;
            case R.id.tab_account:
                viewPager.setCurrentItem(4, false);

                setTitle(R.id.toolbar_title, R.string.account);
                setNavigationIcon(-1);
                setTitleIcon(-1);
                break;
            default:
                break;
        }

    }

    private void setNavigationIcon(int resId) {
        if (resId <= -1) {
            getToolbar().setNavigationIcon(null);
        } else {
            getToolbar().setNavigationIcon(resId);
        }
    }

    private void setTitleIcon(int resId) {
        ImageView imageView = (ImageView) findViewById(R.id.toolbar_icon);
        imageView.setVisibility(resId <= -1 ? View.GONE : View.VISIBLE);

        if (resId > -1) {
            imageView.setImageResource(resId);
        }
    }

    //endregion
}
