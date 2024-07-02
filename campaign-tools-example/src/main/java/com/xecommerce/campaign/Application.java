package com.xecommerce.campaign;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xecommerce.campaign.model.ClickEventModel;
import com.xecommerce.campaign.model.KafkaConsumeData;
import io.confluent.kafka.serializers.KafkaJsonDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Application {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.23:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "instance1");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaJsonDeserializer.class.getName());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, JsonNode> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("click_event_data"));

        ConsumerRecords<String, JsonNode> records = consumer.poll(Duration.ofMinutes(10));
        List<String> cantPayWhoUsers = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for (ConsumerRecord<String, JsonNode> record : records) {
            ClickEventModel value = mapper.convertValue(record.value(), new TypeReference<ClickEventModel>() {});

            if (value.getButtonName().equals("paymentByCreditCard")) {
                cantPayWhoUsers.add(value.getCustomerId());
            }
        }

        consumer.commitSync();

        cantPayWhoUsers.forEach(c -> System.out.println("mail service call for " + c));
    }
}
