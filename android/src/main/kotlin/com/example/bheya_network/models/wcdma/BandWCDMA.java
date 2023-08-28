package com.example.bheya_network.models.wcdma;

import com.example.bheya_network.models.common.Band;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BandWCDMA extends Band implements Serializable {
    @SerializedName("downlinkUarfcn")
    private int downlinkUarfcn;

    public BandWCDMA() {
    }

    public int getDownlinkUarfcn() {
        return downlinkUarfcn;
    }

    public void setDownlinkUarfcn(int downlinkUarfcn) {
        this.downlinkUarfcn = downlinkUarfcn;
    }
    
}
