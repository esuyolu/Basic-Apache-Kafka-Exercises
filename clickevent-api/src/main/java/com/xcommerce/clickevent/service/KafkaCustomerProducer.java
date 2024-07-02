package com.xcommerce.clickevent.service;

import com.xcommerce.clickevent.config.YamlConfig;
import com.xcommerce.clickevent.model.KafkaDataModel;
import io.confluent.kafka.serializers.KafkaJsonSerializer;
import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaCustomerProducer {

    @Autowired
    YamlConfig myConfig;
    Producer producer;

    @PostConstruct
    public void init() {
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, myConfig.getBootstrap_server());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());

        producer = new KafkaProducer(config);
    }

    public void send(KafkaDataModel model) {
        ProducerRecord<String, KafkaDataModel> record = new ProducerRecord<>(myConfig.getTopic(), model);
        producer.send(record);
        producer.flush();
    }

    public void close() {
        producer.close();
    }
}
