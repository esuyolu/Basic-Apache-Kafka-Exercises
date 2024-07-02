package com.xecommerce.campaign.model;

public class KafkaConsumeData {
    private String key;
    private ClickEventModel value;
    private String offset;
    private String topic;

    public KafkaConsumeData() {

    }
    public KafkaConsumeData(String key, ClickEventModel value, String offset, String topic) {
        this.key = key;
        this.value = value;
        this.offset = offset;
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ClickEventModel getValue() {
        return value;
    }

    public void setValue(ClickEventModel value) {
        this.value = value;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
