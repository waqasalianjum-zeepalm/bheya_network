package com.example.bheya_network.models.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Band implements Serializable {
    @SerializedName("channelNumber")
    private int channelNumber;
    @SerializedName("number")
    private int number;
    @SerializedName("name")
    private String name;

    public Band() {
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
