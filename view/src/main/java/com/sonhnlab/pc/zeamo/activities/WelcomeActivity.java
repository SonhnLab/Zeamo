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

    //region Override method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
        setBindingContentView(R.layout.activity_welcome, BR.viewModel);
    }

    //endregion
}
