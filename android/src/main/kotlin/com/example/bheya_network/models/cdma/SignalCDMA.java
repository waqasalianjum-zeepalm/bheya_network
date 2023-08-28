package com.example.bheya_network.models.cdma;

import com.example.bheya_network.models.common.Signal;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SignalCDMA extends Signal implements Serializable {
    @SerializedName("cdmaRssi")
    private int cdmaRssi;
    @SerializedName("evdoRssi")
    private int evdoRssi;
    @SerializedName("evdoSnr")
    private int evdoSnr;
    @SerializedName("cdmaEcio")
    private double cdmaEcio;
    @SerializedName("evdoEcio")
    private double evdoEcio;


    public SignalCDMA() {
    }

    public int getCdmaRssi() {
        return cdmaRssi;
    }

    public void setCdmaRssi(int cdmaRssi) {
        this.cdmaRssi = cdmaRssi;
    }

    public int getEvdoRssi() {
        return evdoRssi;
    }

    public void setEvdoRssi(int evdoRssi) {
        this.evdoRssi = evdoRssi;
    }

    public int getEvdoSnr() {
        return evdoSnr;
    }

    public void setEvdoSnr(int evdoSnr) {
        this.evdoSnr = evdoSnr;
    }

    public double getCdmaEcio() {
        return cdmaEcio;
    }

    public void setCdmaEcio(double cdmaEcio) {
        this.cdmaEcio = cdmaEcio;
    }

    public double getEvdoEcio() {
        return evdoEcio;
    }

    public void setEvdoEcio(double evdoEcio) {
        this.evdoEcio = evdoEcio;
    }
}
