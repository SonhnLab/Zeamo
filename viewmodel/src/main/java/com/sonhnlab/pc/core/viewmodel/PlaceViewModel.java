package com.sonhnlab.pc.core.viewmodel;

import android.databinding.Bindable;

import com.sonhnlab.pc.core.BR;
import com.sonhnlab.pc.core.R;
import com.sonhnlab.pc.core.view.INavigator;
import com.sonhnlab.pc.core.viewmodel.base.BaseViewModel;
import com.sonhnlab.pc.model.entity.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SonhnLab on 12/11/2016.
 */

public class PlaceViewModel extends BaseViewModel {

    //region Properties

    private List<Place> mPlaces;

    //endregion

    //region Getters and Setters

    @Bindable
    public List<Place> getPlaces() {
        return mPlaces;
    }

    public void setPlaces(List<Place> places) {
        mPlaces = places;

        notifyPropertyChanged(BR.places);
    }


    //endregion

    //region Constructors

    public PlaceViewModel(INavigator navigator) {
        super(navigator);
    }


    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart() {
        super.onStart();
        loadPlace();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlaces = null;
    }

    @Override
    public void onResult(int requestCode) {
        super.onResult(requestCode);
    }

    //endregion

    //region Private methods

    private void loadPlace() {
        mPlaces = new ArrayList<>();

        mPlaces.add(new Place(1, "Green Fitness Studio", " - 266 E 10th St", "Four", "0.2 mi", R.drawable.place1));
        mPlaces.add(new Place(2, "Revolve Fitness", " - 52 E 13th St", "Three", "0.3 mi", R.drawable.place2));
        setPlaces(mPlaces);
    }

    //endregion

    //region Public methods


    //endregion
}
