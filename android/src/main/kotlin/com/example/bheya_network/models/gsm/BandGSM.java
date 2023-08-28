package com.example.bheya_network.models.gsm;


import com.example.bheya_network.models.common.Band;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BandGSM extends Band implements Serializable {
    @SerializedName("arfcn")
    private int arfcn;

    public BandGSM() {
    }


    public int getArfcn() {
        return arfcn;
    }

    public void setArfcn(int arfcn) {
        this.arfcn = arfcn;
    }
}
