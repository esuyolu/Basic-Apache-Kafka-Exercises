package com.xecommerce.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONObject;

import java.util.Properties;

public class KafkaJsonProducer {

    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.23:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(config);

        JSONObject data = new JSONObject();
        data.put("customerId", 123456);
        data.put("customerName", "Ahmet Çetin");
        data.put("current_view", "Login");

        ProducerRecord<String, String> record = new ProducerRecord<>("java_json_test", data.toString());
        producer.send(record);
        producer.flush();
    }
}
