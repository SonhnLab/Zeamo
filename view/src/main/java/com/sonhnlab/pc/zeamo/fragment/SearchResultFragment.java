package com.sonhnlab.pc.zeamo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.sonhnlab.pc.core.view.BaseFragment;
import com.sonhnlab.pc.core.viewmodel.PlaceViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.adapter.SearchResultAdapter;
import com.sonhnlab.pc.zeamo.databinding.FragmentSearchResultBinding;

/**
 * Created by SonhnLab on 12/11/2016.
 */

public class SearchResultFragment extends BaseFragment<FragmentSearchResultBinding, PlaceViewModel> {

    //region Property



    //endregion

    //region Construction

    public static SearchResultFragment newInstance() {
        return new SearchResultFragment();
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
        final FragmentSearchResultBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_search_result,
                container,
                false
        );
        binding.setViewModel(mViewModel);

        //Setup Toolbar
        Toolbar toolbar = (Toolbar) binding.getRoot().findViewById(R.id.toolbar_search);
        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        //Setup SearchBar
        final ImageView closeButton = (ImageView) binding.getRoot().findViewById(R.id.im_search_close);
        final EditText search = (EditText) binding.getRoot().findViewById(R.id.edt_search_bar);
        search.setText("Spinning");
        closeButton.setVisibility(View.VISIBLE);

        search.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ((BaseFragment) getParentFragment()).popFragment();
                return true;
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((BaseFragment) getParentFragment()).popFragment();
            }
        });

        setViewDataBinding(binding);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Setup RecyclerView
        RecyclerView recyclerView = getViewDataBinding().recyclerViewSearchResult;
        SearchResultAdapter adapter = new SearchResultAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        adapter.setViewModel(mViewModel);
        recyclerView.setAdapter(adapter);
    }

    //endregion

}
