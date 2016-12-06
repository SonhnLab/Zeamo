package com.sonhnlab.pc.zeamo.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sonhnlab.pc.core.view.BaseRecyclerViewAdapter;
import com.sonhnlab.pc.core.view.ViewHolder;
import com.sonhnlab.pc.core.viewmodel.SearchViewModel;
import com.sonhnlab.pc.model.entity.Sport;
import com.sonhnlab.pc.zeamo.BR;
import com.sonhnlab.pc.zeamo.R;

import java.util.List;

/**
 * Created by SonhnLab on 12/6/2016.
 */

public class SportListAdapter extends BaseRecyclerViewAdapter<SearchViewModel, List<Sport>>{

    //region Override method

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_sport,
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding binding = ((ViewHolder) holder).getViewDataBinding();

        binding.setVariable(BR.sport, mData.get(position));
        binding.setVariable(BR.viewModel, mViewModel);

        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    //endregion
}
