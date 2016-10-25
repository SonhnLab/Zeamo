package com.sonhnlab.pc.zeamo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.sonhnlab.pc.zeamo.R;

/**
 * Created by PC on 10/13/2016.
 */

public class WelcomeActivity extends AppCompatActivity {

    //region Properties

    ImageView mButtonCreateAccount;

    ImageView mTextLogin;

    //endregion

    //region Override method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mTextLogin = (ImageView) findViewById(R.id.im_text_login_welcome);
        mTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        mButtonCreateAccount = (ImageView) findViewById(R.id.im_button_create_account_welcome);
        mButtonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    //endregion
}
