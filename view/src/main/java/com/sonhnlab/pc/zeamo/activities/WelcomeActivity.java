package com.sonhnlab.pc.zeamo.activities;

import android.os.Bundle;
import android.widget.ImageView;

import com.sonhnlab.pc.core.BR;
import com.sonhnlab.pc.core.view.BaseActivity;
import com.sonhnlab.pc.core.viewmodel.WelcomeViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.databinding.ActivityWelcomeBinding;


/**
 * Created by PC on 10/13/2016.
 */

public class WelcomeActivity extends BaseActivity<ActivityWelcomeBinding, WelcomeViewModel> {

    //region Properties

    ImageView mButtonCreateAccount;

    ImageView mTextLogin;

    //endregion

    //region Override method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
        setBindingContentView(R.layout.activity_welcome, BR.viewModel);

//        mTextLogin = (ImageView) findViewById(R.id.im_text_login_welcome);
//        mTextLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//            }
//        });
//
//        mButtonCreateAccount = (ImageView) findViewById(R.id.im_button_create_account_welcome);
//        mButtonCreateAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//            }
//        });
    }

    //endregion

    //region Private method

    private void goForwardAnimation() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    //endregion
}
