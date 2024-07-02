package com.xcommerce.clickevent.model;

public class ClickResponse {

    private String status;
    private KafkaDataModel model;

    public ClickResponse() {
    }

    public ClickResponse(String status, KafkaDataModel model) {
        this.status = status;
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public KafkaDataModel getModel() {
        return model;
    }

    public void setModel(KafkaDataModel model) {
        this.model = model;
    }
}
