package com.xcommerce.clickevent.service;

import com.xcommerce.clickevent.mapper.KafkaRequestMapper;
import com.xcommerce.clickevent.model.ClickRequest;
import com.xcommerce.clickevent.model.ClickResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("click")
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    KafkaCustomerProducer kafkaCustomerProducer;

    @Override
    public ClickResponse producer(ClickRequest request) {
        ClickResponse response = KafkaRequestMapper.clickRequestToClickResponse(request);
        try {
            kafkaCustomerProducer.send(KafkaRequestMapper.clickRequestToKafkaDataModel(request));
            response.setStatus("SUCCESS");
        } catch (Exception e) {
            response.setStatus("FAIL");
        }
        JSONObject jsonObject = new JSONObject(response);
        System.out.println(jsonObject);
        return response;
    }
}
