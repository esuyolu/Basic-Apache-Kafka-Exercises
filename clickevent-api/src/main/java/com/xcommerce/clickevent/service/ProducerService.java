package com.xcommerce.clickevent.service;

import com.xcommerce.clickevent.model.ClickRequest;
import com.xcommerce.clickevent.model.ClickResponse;
import com.xcommerce.clickevent.model.KafkaDataModel;

public interface ProducerService {
    ClickResponse producer(ClickRequest request);
}
