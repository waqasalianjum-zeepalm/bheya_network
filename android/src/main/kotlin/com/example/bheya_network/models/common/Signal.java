package com.example.bheya_network.models.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Signal implements Serializable {
    @SerializedName("dbm")
    private int dbm;

    public Signal() {
    }

    public int getDbm() {
        return dbm;
    }

    public void setDbm(int dbm) {
        this.dbm = dbm;
    }
}
