package com.sonhnlab.pc.zeamo.fragment;

import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sonhnlab.pc.core.helper.KeyboardHelper;
import com.sonhnlab.pc.core.view.BaseFragment;
import com.sonhnlab.pc.core.viewmodel.SearchViewModel;
import com.sonhnlab.pc.model.entity.Sport;
import com.sonhnlab.pc.zeamo.App;
import com.sonhnlab.pc.zeamo.R;
import com.sonhnlab.pc.zeamo.adapter.SportListAdapter;
import com.sonhnlab.pc.zeamo.common.DividerItemDecoration;
import com.sonhnlab.pc.zeamo.databinding.FragmentSearchBinding;
import com.sonhnlab.pc.zeamo.listener.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SonhnLab on 11/27/2016.
 */

public class SearchFragment extends BaseFragment<FragmentSearchBinding, SearchViewModel> {

    //region Property

    private RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManager;

    public SportListAdapter mAdapter;

    public EditText mSearch;

    public CardView mCardView;

    //endregion

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

        //Setup RecyclerView
        mRecyclerView = (RecyclerView) binding.getRoot().findViewById(R.id.recycler_view_search);
        mAdapter = new SportListAdapter();
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this.getContext()));

        mRecyclerView.setNestedScrollingEnabled(false);
        mAdapter.setViewModel(mViewModel);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "" + mViewModel.getSports().get(position).getName(), Toast.LENGTH_SHORT).show();
                BookingsFragment bookingsFragment = new BookingsFragment();
                Bundle bundle = new Bundle();
                bookingsFragment.setArguments(bundle);
                ((BaseFragment) getParentFragment()).replaceFragment(bookingsFragment, true);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));

        //Setup SearchBar
        final ImageView closeButton = (ImageView) binding.getRoot().findViewById(R.id.im_search_close);
        final TextView hideText = (TextView) binding.getRoot().findViewById(R.id.tv_search_popular);
        mSearch = (EditText) binding.getRoot().findViewById(R.id.edt_search_bar);

        mSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (!mSearch.getText().toString().matches("")) {
                    closeButton.setVisibility(View.VISIBLE);
                    hideText.setVisibility(View.GONE);
                } else {
                    closeButton.setVisibility(View.GONE);
                    hideText.setVisibility(View.VISIBLE);
                }
                charSequence = charSequence.toString().toLowerCase();
                final List<Sport> filteredList = new ArrayList<>();

                for (int i = 0; i < mViewModel.getSports().size(); i++) {
                    final String nameSport = mViewModel.getSports().get(i).getName().toLowerCase();
                    if (nameSport.contains(charSequence)) {
                        filteredList.add(mViewModel.getSports().get(i));
                    }
                }

                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new SportListAdapter(filteredList, getContext());
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext()));

                mRecyclerView.setNestedScrollingEnabled(false);
                mAdapter.setViewModel(mViewModel);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSearch.setText("");
                mSearch.setHint("Search nearby");
                closeButton.setVisibility(View.GONE);
            }
        });

        //Setup Parent
        setupParent(binding.getRoot().findViewById(R.id.layout_search));

        setViewDataBinding(binding);

        return binding.getRoot();
    }

    //endregion

    //region Public method

    public void setupParent(View view) {
        //Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        if (mSearch.isFocused()) {
                            Rect outRect = new Rect();
                            if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                                mSearch.clearFocus();
                                KeyboardHelper.hidden(getContext(), getActivity().getCurrentFocus());
                            }
                        }
                    }
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

    //endregion
}
