package com.xecommerce.kafka;

import io.confluent.kafka.serializers.KafkaJsonSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaClassProducer {

    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.23:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());

        KafkaProducer<String, Account> producer = new KafkaProducer<>(config);

        Account account = new Account(654321, "Seda Demir", "Şifre Unuttum");

        ProducerRecord<String, Account> record = new ProducerRecord<>("java_class_test", account);

        producer.send(record);
        producer.flush();
    }
}
