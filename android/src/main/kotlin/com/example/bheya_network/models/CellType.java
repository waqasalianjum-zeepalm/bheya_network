package com.example.bheya_network.models;


import com.example.bheya_network.models.cdma.CellCDMA;
import com.example.bheya_network.models.gsm.CellGSM;
import com.example.bheya_network.models.lte.CellLTE;
import com.example.bheya_network.models.nr.CellNR;
import com.example.bheya_network.models.tdscdma.CellTDSCDMA;
import com.example.bheya_network.models.wcdma.CellWCDMA;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CellType implements Serializable {

    @SerializedName("type")
    private String type;
    @SerializedName("cdma")
    private CellCDMA cdma;
    @SerializedName("gsm")
    private CellGSM gsm;
    @SerializedName("lte")
    private CellLTE lte;
    @SerializedName("nr")
    private CellNR nr;
    @SerializedName("tdscdma")
    private CellTDSCDMA tdscdma;
    @SerializedName("wcdma")
    private CellWCDMA wcdma;

    public CellType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CellCDMA getCdma() {
        return cdma;
    }

    public void setCdma(CellCDMA cdma) {
        this.cdma = cdma;
    }

    public CellGSM getGsm() {
        return gsm;
    }

    public void setGsm(CellGSM gsm) {
        this.gsm = gsm;
    }

    public CellLTE getLte() {
        return lte;
    }

    public void setLte(CellLTE lte) {
        this.lte = lte;
    }

    public CellNR getNr() {
        return nr;
    }

    public void setNr(CellNR nr) {
        this.nr = nr;
    }

    public CellTDSCDMA getTdscdma() {
        return tdscdma;
    }

    public void setTdscdma(CellTDSCDMA tdscdma) {
        this.tdscdma = tdscdma;
    }

    public CellWCDMA getWcdma() {
        return wcdma;
    }

    public void setWcdma(CellWCDMA wcdma) {
        this.wcdma = wcdma;
    }
}
