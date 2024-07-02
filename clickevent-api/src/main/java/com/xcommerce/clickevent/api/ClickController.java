package com.xcommerce.clickevent.api;

import com.xcommerce.clickevent.model.ClickRequest;
import com.xcommerce.clickevent.model.ClickResponse;
import com.xcommerce.clickevent.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickController {
    @Autowired
    @Qualifier("click")
    ProducerService producerService;

    @PostMapping("/click")
    public ClickResponse clickEvent(@RequestBody ClickRequest request) {
        ClickResponse producer = producerService.producer(request);
        return producer;
    }
}
