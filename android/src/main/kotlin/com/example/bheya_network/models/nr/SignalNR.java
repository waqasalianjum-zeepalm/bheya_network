package com.example.bheya_network.models.nr;

import com.example.bheya_network.models.common.Signal;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SignalNR extends Signal implements Serializable {
    @SerializedName("csiRsrp")
    private int csiRsrp;
    @SerializedName("csiRsrq")
    private int csiRsrq;
    @SerializedName("csiSinr")
    private int csiSinr;
    @SerializedName("ssRsrp")
    private int ssRsrp;
    @SerializedName("ssRsrq")
    private int ssRsrq;
    @SerializedName("ssSinr")
    private int ssSinr;
    @SerializedName("csiRsrpAsu")
    private int csiRsrpAsu;
    @SerializedName("ssRsrpAsu")
    private int ssRsrpAsu;


    public SignalNR() {
    }

    public int getCsiRsrp() {
        return csiRsrp;
    }

    public void setCsiRsrp(int csiRsrp) {
        this.csiRsrp = csiRsrp;
    }

    public int getCsiRsrq() {
        return csiRsrq;
    }

    public void setCsiRsrq(int csiRsrq) {
        this.csiRsrq = csiRsrq;
    }

    public int getCsiSinr() {
        return csiSinr;
    }

    public void setCsiSinr(int csiSinr) {
        this.csiSinr = csiSinr;
    }

    public int getSsRsrp() {
        return ssRsrp;
    }

    public void setSsRsrp(int ssRsrp) {
        this.ssRsrp = ssRsrp;
    }

    public int getSsRsrq() {
        return ssRsrq;
    }

    public void setSsRsrq(int ssRsrq) {
        this.ssRsrq = ssRsrq;
    }

    public int getSsSinr() {
        return ssSinr;
    }

    public void setSsSinr(int ssSinr) {
        this.ssSinr = ssSinr;
    }

    public int getCsiRsrpAsu() {
        return csiRsrpAsu;
    }

    public void setCsiRsrpAsu(int csiRsrpAsu) {
        this.csiRsrpAsu = csiRsrpAsu;
    }

    public int getSsRsrpAsu() {
        return ssRsrpAsu;
    }

    public void setSsRsrpAsu(int ssRsrpAsu) {
        this.ssRsrpAsu = ssRsrpAsu;
    }
}
