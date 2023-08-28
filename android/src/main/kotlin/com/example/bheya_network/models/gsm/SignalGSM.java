package com.example.bheya_network.models.gsm;

import com.example.bheya_network.models.common.Signal;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SignalGSM extends Signal implements Serializable {
    @SerializedName("rssi")
    private int rssi;
    @SerializedName("bitErrorRate")
    private int bitErrorRate;
    @SerializedName("timingAdvance")
    private int timingAdvance;


    public SignalGSM() {
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getBitErrorRate() {
        return bitErrorRate;
    }

    public void setBitErrorRate(int bitErrorRate) {
        this.bitErrorRate = bitErrorRate;
    }

    public int getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(int timingAdvance) {
        this.timingAdvance = timingAdvance;
    }
}
