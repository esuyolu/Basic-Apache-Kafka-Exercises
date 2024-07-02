package com.xecommerce.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.json.JSONObject;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class KafkaParseConsumer {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.23:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer01");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        //consumer.subscribe(Arrays.asList("account", "transaction_havale"));
        consumer.subscribe(Arrays.asList("transaction_havale"));

        while (true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ZERO);

            for (ConsumerRecord<String, String> record : consumerRecords) {
                System.out.println("topic: " + record.topic());
                System.out.println("partition: " + record.partition());
                System.out.println("offset: " + record.offset());
                System.out.println("timestamp: " + record.timestamp());
                System.out.println("key: " + record.key());
                System.out.println("value: " + record.value());
                String data = record.value();
                JSONObject json = new JSONObject(data);

                if (json.getInt("afterBalance") < 1000) {
                    System.out.println("Merhaba " + json.getString("accountName") + " Hesabınızdaki para 1000 TL altına düşmüştür!!!");
                }

                System.out.println("*************************************");
            }

            consumer.commitSync();
        }
    }
}
