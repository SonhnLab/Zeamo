package com.sonhnlab.pc.model.entity;

/**
 * Created by SonhnLab on 12/6/2016.
 */

public class Sport {

    //region Property

    private int mId;

    private String mName;

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

    //endregion

    //region Constructor


    public Sport() {
    }

    public Sport(int id, String name) {
        mId = id;
        mName = name;
    }

    //endregion

}
