package com.example.bheya_network.models.lte;

import com.example.bheya_network.models.common.Signal;
import com.google.gson.annotations.SerializedName;


import java.io.Serializable;

public class SignalLTE extends Signal implements Serializable {
    @SerializedName("rssi")
    private int rssi;
    @SerializedName("rsrp")
    private double rsrp;
    @SerializedName("rsrq")
    private double rsrq;
    @SerializedName("snr")
    private double snr;
    @SerializedName("cqi")
    private int cqi;
    @SerializedName("timingAdvance")
    private int timingAdvance;
    @SerializedName("rssiAsu")
    private int rssiAsu;
    @SerializedName("rsrpAsu")
    private int rsrpAsu;

    public SignalLTE() {
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public double getRsrp() {
        return rsrp;
    }

    public void setRsrp(double rsrp) {
        this.rsrp = rsrp;
    }

    public double getRsrq() {
        return rsrq;
    }

    public void setRsrq(double rsrq) {
        this.rsrq = rsrq;
    }

    public double getSnr() {
        return snr;
    }

    public void setSnr(double snr) {
        this.snr = snr;
    }

    public int getCqi() {
        return cqi;
    }

    public void setCqi(int cqi) {
        this.cqi = cqi;
    }

    public int getTimingAdvance() {
        return timingAdvance;
    }

    public void setTimingAdvance(int timingAdvance) {
        this.timingAdvance = timingAdvance;
    }

    public int getRssiAsu() {
        return rssiAsu;
    }

    public void setRssiAsu(int rssiAsu) {
        this.rssiAsu = rssiAsu;
    }

    public int getRsrpAsu() {
        return rsrpAsu;
    }

    public void setRsrpAsu(int rsrpAsu) {
        this.rsrpAsu = rsrpAsu;
    }
}
