package com.example.bheya_network.models.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Network implements Serializable {

    @SerializedName("mcc")
    private String mcc;
    @SerializedName("mnc")
    private String mnc;
    @SerializedName("iso")
    private String iso;

    public Network() {
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }
}
