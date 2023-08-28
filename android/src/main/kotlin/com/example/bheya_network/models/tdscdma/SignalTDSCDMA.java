package com.example.bheya_network.models.tdscdma;

import com.example.bheya_network.models.common.Signal;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SignalTDSCDMA extends Signal implements Serializable {
    @SerializedName("rssi")
    private int rssi;
    @SerializedName("bitErrorRate")
    private int bitErrorRate;
    @SerializedName("rscp")
    private int rscp;
    @SerializedName("rscpAsu")
    private int rscpAsu;
    @SerializedName("rssiAsu")
    private int rssiAsu;


    public SignalTDSCDMA() {
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

    public int getRscp() {
        return rscp;
    }

    public void setRscp(int rscp) {
        this.rscp = rscp;
    }

    public int getRscpAsu() {
        return rscpAsu;
    }

    public void setRscpAsu(int rscpAsu) {
        this.rscpAsu = rscpAsu;
    }

    public int getRssiAsu() {
        return rssiAsu;
    }

    public void setRssiAsu(int rssiAsu) {
        this.rssiAsu = rssiAsu;
    }
}
