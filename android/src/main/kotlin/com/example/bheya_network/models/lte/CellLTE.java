package com.example.bheya_network.models.lte;

import com.example.bheya_network.models.common.Cell;
import com.google.gson.annotations.SerializedName;


import java.io.Serializable;

public class CellLTE extends Cell implements Serializable {

    @SerializedName("bandwidth")
    private Integer bandwidth;
    @SerializedName("eci")
    private Integer eci;
    @SerializedName("tac")
    private Integer tac;
    @SerializedName("pci")
    private Integer pci;
    @SerializedName("enb")
    private Integer enb;
    @SerializedName("cid")
    private Integer cid;
    @SerializedName("ecgi")
    private String ecgi;
    @SerializedName("bandLTE")
    private BandLTE bandLTE;
    @SerializedName("signalLTE")
    private SignalLTE signalLTE;



    public CellLTE() {
    }

    public SignalLTE getSignal() {
        return signalLTE;
    }

    public SignalLTE getSignalLTE() {
        return signalLTE;
    }

    public void setSignalLTE(SignalLTE signalLTE) {
        this.signalLTE = signalLTE;
    }

    public void setSignal(SignalLTE signal) {
        this.signalLTE = signal;
    }

    public BandLTE getBandLTE() {
        return bandLTE;
    }

    public void setBandLTE(BandLTE bandLTE) {
        this.bandLTE = bandLTE;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public Integer getEnb() {
        return enb;
    }

    public void setEnb(Integer enb) {
        this.enb = enb;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getEcgi() {
        return ecgi;
    }

    public void setEcgi(String ecgi) {
        this.ecgi = ecgi;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Integer getEci() {
        return eci;
    }

    public void setEci(Integer eci) {
        this.eci = eci;
    }

    public Integer getTac() {
        return tac;
    }

    public void setTac(Integer tac) {
        this.tac = tac;
    }

    public Integer getPci() {
        return pci;
    }

    public void setPci(Integer pci) {
        this.pci = pci;
    }
}

