package com.sonhnlab.pc.zeamo.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sonhnlab.pc.core.helper.KeyboardHelper;
import com.sonhnlab.pc.core.view.BaseActivity;
import com.sonhnlab.pc.core.viewmodel.LoginViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.core.BR;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.databinding.ActivityLoginBinding;

/**
 * Created by PC on 10/13/2016.
 */

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    //region Properties

    private EditText mEmail, mPassword;

    private TextView mValidate;

    ImageView mSignInButton;

    LinearLayout mLayout;

    //endregion

    //region Override method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
        setBindingContentView(R.layout.activity_login, BR.viewModel);

        setupToolbar();
        setupParent(findViewById(R.id.layout_login));
    }

    //endregion

    //region Private method

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_login);
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
                    KeyboardHelper.hideSoftKeyboardOnTap(LoginActivity.this);
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
