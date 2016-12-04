package com.sonhnlab.pc.zeamo.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sonhnlab.pc.core.BR;
import com.sonhnlab.pc.core.helper.KeyboardHelper;
import com.sonhnlab.pc.core.view.BaseActivity;
import com.sonhnlab.pc.core.viewmodel.ForgotPasswordViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.databinding.ActivityForgotPasswordBinding;

/**
 * Created by SonhnLab on 11/23/2016.
 */

public class ForgotPasswordActivity extends BaseActivity<ActivityForgotPasswordBinding, ForgotPasswordViewModel> {

    //region Properties

    private EditText mEmail;

    private TextView mValidate;

    ImageView mSubmitButton;

    LinearLayout mLayout;

    //endregion

    //region Override method

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
        setBindingContentView(R.layout.activity_forgot_password, BR.viewModel);

        mEmail = (EditText) findViewById(R.id.edt_forgot);
        mValidate = (TextView) findViewById(R.id.tv_forgot_validate);
        mSubmitButton = (ImageView) findViewById(R.id.btn_forgot_submit);
        mLayout = (LinearLayout) findViewById(R.id.layout_forgot_edt);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

        setupToolbar();
        setupParent(findViewById(R.id.layout_forgot_password));
    }

    //endregion

    //region Private method

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_forgot_password);
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
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    KeyboardHelper.hideSoftKeyboardOnTap(ForgotPasswordActivity.this);
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

    public boolean validate() {
        boolean valid = true;

        String email = mEmail.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mValidate.setVisibility(View.VISIBLE);
            valid = false;
        }
        return valid;
    }

    public void submit() {
        if (!validate()) {
            mLayout.setBackground(getDrawable(R.drawable.textfill_a));
            return;
        }
        mLayout.setBackground(getDrawable(R.drawable.textfill));
        mValidate.setVisibility(View.GONE);
        finish();
        Toast.makeText(getApplicationContext(), "Instruction to reset password have been emailed to "
                + mEmail.getText().toString()
                + ". Please check your email for these next steps.", Toast.LENGTH_LONG).show();
    }

    //endregion
}
