package com.example.bheya_network.models.nr;


import com.example.bheya_network.models.common.Band;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BandNR extends Band implements Serializable {
    @SerializedName("downlinkArfcn")
    private int downlinkArfcn;
    @SerializedName("downlinkFrequency")
    private int downlinkFrequency;

    public BandNR() {
    }

    public int getDownlinkArfcn() {
        return downlinkArfcn;
    }

    public void setDownlinkArfcn(int downlinkArfcn) {
        this.downlinkArfcn = downlinkArfcn;
    }

    public int getDownlinkFrequency() {
        return downlinkFrequency;
    }

    public void setDownlinkFrequency(int downlinkFrequency) {
        this.downlinkFrequency = downlinkFrequency;
    }
}
