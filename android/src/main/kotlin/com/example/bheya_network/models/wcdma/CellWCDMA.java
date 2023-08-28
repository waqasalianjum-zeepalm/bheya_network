package com.example.bheya_network.models.wcdma;

import com.example.bheya_network.models.common.Cell;
import com.google.gson.annotations.SerializedName;


import java.io.Serializable;

public class CellWCDMA extends Cell implements Serializable {
    @SerializedName("ci")
    private Integer ci;
    @SerializedName("lac")
    private Integer lac;
    @SerializedName("psc")
    private Integer psc;
    @SerializedName("cid")
    private Integer cid;
    @SerializedName("rnc")
    private Integer rnc;
    @SerializedName("cgi")
    private Integer cgi;
    @SerializedName("bandWCDMA")
    private BandWCDMA bandWCDMA;
    @SerializedName("signalWCDMA")
    private SignalWCDMA signalWCDMA;

    public CellWCDMA() {
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    public Integer getPsc() {
        return psc;
    }

    public void setPsc(Integer psc) {
        this.psc = psc;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRnc() {
        return rnc;
    }

    public void setRnc(Integer rnc) {
        this.rnc = rnc;
    }

    public Integer getCgi() {
        return cgi;
    }

    public void setCgi(Integer cgi) {
        this.cgi = cgi;
    }

    public BandWCDMA getBandWCDMA() {
        return bandWCDMA;
    }

    public void setBandWCDMA(BandWCDMA bandWCDMA) {
        this.bandWCDMA = bandWCDMA;
    }

    public SignalWCDMA getSignalWCDMA() {
        return signalWCDMA;
    }

    public void setSignalWCDMA(SignalWCDMA signalWCDMA) {
        this.signalWCDMA = signalWCDMA;
    }
}

