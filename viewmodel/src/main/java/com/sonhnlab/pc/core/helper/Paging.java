package com.sonhnlab.pc.core.helper;

/**
 * Created by SonhnLab on 11/27/2016.
 */

public class Paging {

    //region Property

    public static final int LIMIT = 20;

    private int mPage = 0;
    private boolean mLoading = false;
    private boolean mRefreshing = false;
    private boolean mFullData = false;

    //endregion

    //region Getter and Setter

    public boolean isLoading() {
        return mLoading;
    }

    public void setLoading(boolean loading) {
        mLoading = loading;
    }

    public boolean isFullData() {
        return mFullData;
    }

    public void setFullData(boolean isLoadFull) {
        mFullData = isLoadFull;
    }

    public boolean isRefreshing() {
        return mRefreshing;
    }

    public void setRefreshing(boolean refreshing) {
        mRefreshing = refreshing;
    }

    //endregion

    //region Public method

    public boolean canLoadMore() {
        return !isLoading() && !isFullData();
    }

    public int nextPage() {
        mPage++;
        return mPage;
    }

    public void reset() {
        mPage = 0;
        mLoading = false;
        mFullData = false;
        mRefreshing = false;
    }

    //endregion
}
