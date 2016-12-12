package com.sonhnlab.pc.model.entity;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

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

    private int mAvatar;

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

    public int getAvatar() {
        return mAvatar;
    }

    public void setAvatar(int avatar) {
        mAvatar = avatar;
    }

    public @RatingStar int getRatingStar() {
        String star = mRating.replace("Rating ", "");
        if ("One".equals(star)) {
            return ONE;
        }
        if ("Two".equals(star)) {
            return TWO;
        }
        if ("Three".equals(star)) {
            return THREE;
        }
        if ("Four".equals(star)) {
            return FOUR;
        }
        return FIVE;
    }

    //endregion

    //region Constructor

    public Place(int id, String name, String address, String rating, String distance, int avatar) {
        mId = id;
        mName = name;
        mAddress = address;
        mRating = rating;
        mDistance = distance;
        mAvatar = avatar;
    }

    public Place() {
    }

    //endregion

    //region RatingStar define

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({
            ONE,
            TWO,
            THREE,
            FOUR,
            FIVE
    })

    public @interface RatingStar {}

    public static final int ONE = 0;
    public static final int TWO = 1;
    public static final int THREE = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;

}
