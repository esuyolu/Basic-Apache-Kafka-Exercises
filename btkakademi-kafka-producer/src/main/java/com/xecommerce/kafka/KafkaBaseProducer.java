package com.xecommerce.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaBaseProducer {

    public static int partition = 0;

    public static void main(String[] args) throws InterruptedException {

        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.23:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(config);

        /*
        ProducerRecord<String, String> record = new ProducerRecord<>("transaction_eft", "hi esma");
        producer.send(record);
        producer.flush();
         */

        /*
        for (int i = 101; i <= 200; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("transaction_eft", "hi esma " + i);
            System.out.println("hi esma " + i);
            producer.send(record);
            Thread.sleep(200);
        }
         */

        /*
        for (int i = 1; i < 61; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("java_test_partition", i%6, String.valueOf(i%6), String.valueOf(i));
            System.out.println(i);
            producer.send(record);
            producer.flush();
        }
         */

        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
        sendKafkaProducer();
    }

    public static void sendKafkaProducer() {
        ProducerRecord<String, String> record = new ProducerRecord<>("java_test_partition", partition, String.valueOf(partition), "selam");
        System.out.println(partition);
        partition++;
        if (partition == 5) {
            partition = 0;
        }
    }
}
