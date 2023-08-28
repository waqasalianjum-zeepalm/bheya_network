package com.example.bheya_network.models.tdscdma;

import com.example.bheya_network.models.common.Band;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BandTDSCDMA extends Band implements Serializable {

    @SerializedName("downlinkUarfcn")
    private int downlinkUarfcn;

    public BandTDSCDMA() {
    }

    public int getDownlinkUarfcn() {
        return downlinkUarfcn;
    }

    public void setDownlinkUarfcn(int downlinkUarfcn) {
        this.downlinkUarfcn = downlinkUarfcn;
    }
    
}
