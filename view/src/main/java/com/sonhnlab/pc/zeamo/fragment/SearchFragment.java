package com.sonhnlab.pc.zeamo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sonhnlab.pc.core.view.BaseFragment;
import com.sonhnlab.pc.core.viewmodel.SearchViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.databinding.FragmentSearchBinding;

/**
 * Created by SonhnLab on 11/27/2016.
 */

public class SearchFragment extends BaseFragment<FragmentSearchBinding,SearchViewModel> {

    //region Constructor

    public static SearchFragment newInstance() {
        return new SearchFragment();
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
        FragmentSearchBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_search,
                container,
                false
        );
        binding.setViewModel(mViewModel);
        setViewDataBinding(binding);

        return binding.getRoot();
    }

    //endregion
}
