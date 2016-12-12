package com.sonhnlab.pc.core.viewmodel;

import android.databinding.Bindable;

import com.sonhnlab.pc.core.BR;
import com.sonhnlab.pc.core.view.INavigator;
import com.sonhnlab.pc.core.viewmodel.base.BaseViewModel;
import com.sonhnlab.pc.model.entity.Sport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SonhnLab on 12/5/2016.
 */

public class SportViewModel extends BaseViewModel {

    //region Properties

    List<Sport> mSports;

    //endregion

    //region Getters and Setters

    @Bindable
    public List<Sport> getSports() {
        return mSports;
    }

    public void setSports(List<Sport> sports) {
        mSports = sports;

        notifyPropertyChanged(BR.sports);
    }

    //endregion

    //region Constructors

    public SportViewModel(INavigator navigator) {
        super(navigator);
    }

    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();
        loadSport();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSports = null;
    }


    //endregion

    //region Private methods

    private void loadSport() {
        mSports = new ArrayList<>();

        mSports.add(new Sport(1, "Gym"));
        mSports.add(new Sport(2, "Spinning"));
        mSports.add(new Sport(3, "Yoga"));
        mSports.add(new Sport(4, "Crossfit"));
        mSports.add(new Sport(5, "Swimming"));
        mSports.add(new Sport(6, "Tennis"));
        mSports.add(new Sport(7, "Martial Arts"));
        mSports.add(new Sport(8, "Rock Climbing"));
        mSports.add(new Sport(9, "Physiotherapy"));
        mSports.add(new Sport(10, "Football"));
        mSports.add(new Sport(11, "Judo"));
        mSports.add(new Sport(12, "Golf"));
        mSports.add(new Sport(13, "Hunting"));
        mSports.add(new Sport(14, "Fishing"));

        setSports(mSports);
    }

    //endregion

    //region Public methods


    //endregion
}
