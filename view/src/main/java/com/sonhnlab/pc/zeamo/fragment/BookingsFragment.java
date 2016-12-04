package com.sonhnlab.pc.zeamo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.core.view.BaseFragment;
import com.sonhnlab.pc.core.viewmodel.BookingsViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.databinding.FragmentAccountBinding;
import com.sonhnlab.pc.zeamo.databinding.FragmentBookingsBinding;

/**
 * Created by SonhnLab on 11/27/2016.
 */

public class BookingsFragment extends BaseFragment<FragmentBookingsBinding,BookingsViewModel> {

    //region Constructor

    public static BookingsFragment newInstance() {
        return new BookingsFragment();
    }


    //endregion

    //region Lifecycle

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBookingsBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_bookings,
                container,
                false
        );
        binding.setViewModel(mViewModel);
        setViewDataBinding(binding);

        return binding.getRoot();
    }

    //endregion
}
