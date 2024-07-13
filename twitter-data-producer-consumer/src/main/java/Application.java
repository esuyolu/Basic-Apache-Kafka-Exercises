import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.confluent.kafka.serializers.KafkaJsonDeserializer;
import io.confluent.kafka.serializers.KafkaJsonSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException, CsvValidationException, InterruptedException {
        //producer();
        consumer();
    }

    public static void producer() throws IOException, CsvValidationException, InterruptedException {
        String TOPIC = "tweets_squid_game";

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.23:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());

        KafkaProducer<Integer, TweetModel> producer = new KafkaProducer<>(properties);

        CSVReader reader = new CSVReader(new FileReader("C:\\Dev\\tweets_v8.csv"));
        String[] data = null;
        int partition = 0;
        while ((data = reader.readNext()) != null) {
            TweetModel tweetModel = new TweetModel();
            tweetModel.setUser_name(data[0]);
            tweetModel.setUser_followers(data[4]);
            tweetModel.setUser_friends(data[5]);
            tweetModel.setUser_favourites(data[6]);

            //System.out.println(tweetModel);

            ProducerRecord<Integer, TweetModel> record = new ProducerRecord<>(TOPIC, partition, null, tweetModel);

            producer.send(record);
            producer.flush();
            partition++;
            if (partition == 6) {
                partition = 0;
            }

            Thread.sleep(1000);
        }
    }

    public static void consumer() throws JsonProcessingException {
        String TOPIC = "tweets_squid_game";

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.23:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "twitter-consumer-group1");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaJsonDeserializer.class.getName());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<Integer, TweetModel> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(TOPIC));
        ConsumerRecords<Integer, TweetModel> records = consumer.poll(Duration.ofMinutes(120));
        ObjectMapper mapper = new ObjectMapper();

        for (ConsumerRecord<Integer, TweetModel> record : records) {
            TweetModel tweetModel = mapper.convertValue(record.value(), new TypeReference<>() {});
            System.out.println(tweetModel.getUser_name());
        }
    }
}
