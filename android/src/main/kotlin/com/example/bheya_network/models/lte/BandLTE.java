package com.example.bheya_network.models.lte;

import com.example.bheya_network.models.common.Band;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BandLTE extends Band implements Serializable {

    @SerializedName("downlinkEarfcn")
    private int downlinkEarfcn;

    public BandLTE() {
    }

    public int getDownlinkEarfcn() {
        return downlinkEarfcn;
    }

    public void setDownlinkEarfcn(int downlinkEarfcn) {
        this.downlinkEarfcn = downlinkEarfcn;
    }
}
