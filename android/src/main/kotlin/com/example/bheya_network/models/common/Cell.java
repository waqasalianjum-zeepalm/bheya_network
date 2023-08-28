package com.example.bheya_network.models.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cell implements Serializable {
    @SerializedName("subscriptionId")
    private Integer subscriptionId;
    @SerializedName("connectionStatus")
    private String connectionStatus;
    @SerializedName("type")
    private String type;
    @SerializedName("network")
    private Network network;

    public Cell() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }


    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

}
