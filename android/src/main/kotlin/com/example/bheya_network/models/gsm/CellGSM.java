package com.example.bheya_network.models.gsm;



import com.example.bheya_network.models.common.Cell;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CellGSM extends Cell implements Serializable {
    @SerializedName("cid")
    private Integer cid;
    @SerializedName("lac")
    private Integer lac;
    @SerializedName("bsic")
    private Integer bsic;
    @SerializedName("ncc")
    private Integer ncc;
    @SerializedName("bcc")
    private Integer bcc;
    @SerializedName("cgi")
    private Integer cgi;
    @SerializedName("bandGSM")
    private BandGSM bandGSM;
    @SerializedName("signalGSM")
    private SignalGSM signalGSM;


    public CellGSM() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getLac() {
        return lac;
    }

    public void setLac(Integer lac) {
        this.lac = lac;
    }

    public Integer getBsic() {
        return bsic;
    }

    public void setBsic(Integer bsic) {
        this.bsic = bsic;
    }

    public Integer getNcc() {
        return ncc;
    }

    public void setNcc(Integer ncc) {
        this.ncc = ncc;
    }

    public Integer getBcc() {
        return bcc;
    }

    public void setBcc(Integer bcc) {
        this.bcc = bcc;
    }

    public Integer getCgi() {
        return cgi;
    }

    public void setCgi(Integer cgi) {
        this.cgi = cgi;
    }

    public BandGSM getBandGSM() {
        return bandGSM;
    }

    public void setBandGSM(BandGSM bandGSM) {
        this.bandGSM = bandGSM;
    }

    public SignalGSM getSignalGSM() {
        return signalGSM;
    }

    public void setSignalGSM(SignalGSM signalGSM) {
        this.signalGSM = signalGSM;
    }
}

