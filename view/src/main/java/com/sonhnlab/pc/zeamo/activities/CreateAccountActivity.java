package com.sonhnlab.pc.zeamo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.sonhnlab.pc.core.BR;
import com.sonhnlab.pc.core.helper.KeyboardHelper;
import com.sonhnlab.pc.core.view.BaseActivity;
import com.sonhnlab.pc.core.viewmodel.CreateAccountViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.databinding.ActivityCreateAccountBinding;

/**
 * Created by PC on 10/13/2016.
 */

public class CreateAccountActivity extends BaseActivity<ActivityCreateAccountBinding, CreateAccountViewModel> {

    //region Override method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
        setBindingContentView(R.layout.activity_create_account, BR.viewModel);

        setupToolbar();
        setupParent(findViewById(R.id.layout_create_account));

        final ImageView checkBoxAgree = (ImageView) findViewById(R.id.checkbox_agree);
        checkBoxAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxAgree.setActivated(!checkBoxAgree.isActivated());
            }
        });
    }

    //endregion

    //region Private method

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_create_account);
        toolbar.setNavigationIcon(R.drawable.ic_btn_back);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

    }

    //endregion

    //region Public method

    public void setupParent(View view) {
        //Set up touch listener for non-text box views to hide keyboard.
        if(!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    KeyboardHelper.hideSoftKeyboardOnTap(CreateAccountActivity.this);
                    return false;
                }
            });
        }
        //If a layout container, iterate over children
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupParent(innerView);
            }
        }
    }

    //endregion
}
