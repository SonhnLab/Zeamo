package com.sonhnlab.pc.model.entity;

/**
 * Created by SonhnLab on 12/11/2016.
 */

public class Place {

    //region Property

    private int mId;

    private String mName;

    private String mAddress;

    private String mRating;

    private String mDistance;

    //endregion

    //region Getter and Setter

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public String getDistance() {
        return mDistance;
    }

    public void setDistance(String distance) {
        mDistance = distance;
    }

    //endregion

    //region Constructor

    public Place(int id, String name, String address, String rating, String distance) {
        mId = id;
        mName = name;
        mAddress = address;
        mRating = rating;
        mDistance = distance;
    }

    public Place() {
    }

    //endregion

}
