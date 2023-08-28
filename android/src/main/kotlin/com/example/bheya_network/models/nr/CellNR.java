package com.example.bheya_network.models.nr;

import com.example.bheya_network.models.common.Cell;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CellNR extends Cell implements Serializable {
    @SerializedName("nci")
    private Long nci;
    @SerializedName("tac")
    private Integer tac;
    @SerializedName("pci")
    private Integer pci;
    @SerializedName("bandNR")
    private BandNR bandNR;
    @SerializedName("signalNR")
    private SignalNR signalNR;


    public CellNR() {
    }

    public Long getNci() {
        return nci;
    }

    public void setNci(Long nci) {
        this.nci = nci;
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

    public BandNR getBandNR() {
        return bandNR;
    }

    public void setBandNR(BandNR bandNR) {
        this.bandNR = bandNR;
    }

    public SignalNR getSignalNR() {
        return signalNR;
    }

    public void setSignalNR(SignalNR signalNR) {
        this.signalNR = signalNR;
    }
}

