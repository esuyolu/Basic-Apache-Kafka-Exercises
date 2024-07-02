package com.xecommerce.campaign.model;

public class ClickEventModel {
    private String customerId;
    private String city;
    private String deviceId;
    private String buttonName;
    private String currentTimeStamp;

    public ClickEventModel() {
    }

    public ClickEventModel(String customerId, String city, String deviceId, String buttonName, String currentTimeStamp) {
        this.customerId = customerId;
        this.city = city;
        this.deviceId = deviceId;
        this.buttonName = buttonName;
        this.currentTimeStamp = currentTimeStamp;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(String currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }
}
