package com.sonhnlab.pc.zeamo.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sonhnlab.pc.core.BR;
import com.sonhnlab.pc.core.view.BaseActivity;
import com.sonhnlab.pc.core.viewmodel.LoginViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.databinding.ActivityLoginBinding;

/**
 * Created by PC on 10/13/2016.
 */

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    //region Properties

    private Toolbar mToolbar;

    private TextView mToolbarTitle, mUsername, mPassword;

    //endregion

    //region Override method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
        setBindingContentView(R.layout.activity_login, BR.viewModel);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_login);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToolbarTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        mToolbarTitle.setText("Login");

        Typeface OpenSans = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");
        mToolbarTitle.setTypeface(OpenSans);

        mUsername = (TextView) findViewById(R.id.edt_username_login);
        mUsername.setTypeface(OpenSans);

        mPassword = (TextView) findViewById(R.id.edt_password_login);
        mPassword.setTypeface(OpenSans);

        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_btn_back));

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    //endregion

}
