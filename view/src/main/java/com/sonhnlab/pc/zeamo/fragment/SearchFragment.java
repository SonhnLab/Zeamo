package com.sonhnlab.pc.zeamo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.sonhnlab.pc.core.view.BaseFragment;
import com.sonhnlab.pc.core.viewmodel.SearchViewModel;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.adapter.SportListAdapter;
import com.sonhnlab.pc.zeamo.common.DividerItemDecoration;
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

        //Setup Toolbar
        Toolbar toolbar = (Toolbar) binding.getRoot().findViewById(R.id.toolbar_search);
        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        //Setup SearchBar
        final ImageView closeButton = (ImageView) binding.getRoot().findViewById(R.id.im_search_close);
        final EditText search = (EditText) binding.getRoot().findViewById(R.id.edt_search_bar);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    closeButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.setText("");
                search.setHint("Search nearby");
                closeButton.setVisibility(View.GONE);
            }
        });

        //Setup RecyclerView
        RecyclerView recyclerView = (RecyclerView) binding.getRoot().findViewById(R.id.recycler_view_search);
        SportListAdapter adapter = new SportListAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext()));

        recyclerView.setNestedScrollingEnabled(false);
        adapter.setViewModel(mViewModel);
        recyclerView.setAdapter(adapter);

        setViewDataBinding(binding);

        return binding.getRoot();
    }

    //endregion

    //region Private method



    //endregion
}
