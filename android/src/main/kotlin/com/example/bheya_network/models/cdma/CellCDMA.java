package com.example.bheya_network.models.cdma;
import com.google.gson.annotations.SerializedName;
import com.example.bheya_network.models.common.Band;
import com.example.bheya_network.models.common.Cell;


import java.io.Serializable;

public class CellCDMA extends Cell implements Serializable {

    @SerializedName("sid")
    private Integer sid;
    @SerializedName("nid")
    private Integer nid;
    @SerializedName("bid")
    private Integer bid;
    @SerializedName("lat")
    private Double lat;
    @SerializedName("lon")
    private Double lon;
    @SerializedName("band")
    private Band band;
    @SerializedName("signalCDMA")
    private SignalCDMA signalCDMA;


    public CellCDMA() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public SignalCDMA getSignalCDMA() {
        return signalCDMA;
    }

    public void setSignalCDMA(SignalCDMA signalCDMA) {
        this.signalCDMA = signalCDMA;
    }
}

