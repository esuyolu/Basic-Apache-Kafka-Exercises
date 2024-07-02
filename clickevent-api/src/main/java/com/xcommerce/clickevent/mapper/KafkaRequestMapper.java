package com.xcommerce.clickevent.mapper;

import com.xcommerce.clickevent.model.ClickRequest;
import com.xcommerce.clickevent.model.ClickResponse;
import com.xcommerce.clickevent.model.KafkaDataModel;

import java.sql.Timestamp;

public class KafkaRequestMapper {

    public static KafkaDataModel clickRequestToKafkaDataModel(ClickRequest request) {
        KafkaDataModel model = new KafkaDataModel();
        model.setCustomerId(request.getCustomerId());
        model.setCity(request.getCity());
        model.setDeviceId(request.getDeviceId());
        model.setButtonName(request.getButtonName());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        model.setCurrentTimeStamp(timestamp.toString());

        return model;
    }

    public static ClickResponse clickRequestToClickResponse(ClickRequest request) {
        ClickResponse response = new ClickResponse();
        response.setModel(clickRequestToKafkaDataModel(request));
        return response;
    }
}
