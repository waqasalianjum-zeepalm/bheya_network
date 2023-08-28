package com.example.bheya_network.models.tdscdma;

import com.example.bheya_network.models.common.Cell;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CellTDSCDMA extends Cell implements Serializable {

    @SerializedName("ci")
    private Integer ci;
    @SerializedName("lac")
    private Integer lac;
    @SerializedName("cpid")
    private Integer cpid;
    @SerializedName("cid")
    private Integer cid;
    @SerializedName("rnc")
    private Integer rnc;
    @SerializedName("cgi")
    private Integer cgi;
    @SerializedName("bandTDSCDMA")
    private BandTDSCDMA bandTDSCDMA;
    @SerializedName("signalTDSCDMA")
    private SignalTDSCDMA signalTDSCDMA;

    public CellTDSCDMA() {
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

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
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

    public BandTDSCDMA getBandTDSCDMA() {
        return bandTDSCDMA;
    }

    public void setBandTDSCDMA(BandTDSCDMA bandTDSCDMA) {
        this.bandTDSCDMA = bandTDSCDMA;
    }

    public SignalTDSCDMA getSignalTDSCDMA() {
        return signalTDSCDMA;
    }

    public void setSignalTDSCDMA(SignalTDSCDMA signalTDSCDMA) {
        this.signalTDSCDMA = signalTDSCDMA;
    }
}

