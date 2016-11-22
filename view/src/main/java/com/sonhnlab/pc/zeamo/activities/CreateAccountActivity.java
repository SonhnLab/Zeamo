package com.sonhnlab.pc.zeamo.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.sonhnlab.pc.core.BR;
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
}
