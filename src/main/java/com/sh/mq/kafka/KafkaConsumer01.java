package com.sh.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author sh
 * @date 2020/9/23 10:22 上午
 */
public class KafkaConsumer01 {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "47.92.214.223:9092");
        props.put("group.id", "consumer-tutorial1111");
        props.put("auto.offset.reset", "earliest");
        props.put("enable.auto.commit", false);
        props.put("max.poll.records", 1);
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("USER_AUTH_TOPIC"));
        while (true) {
            System.out.println("执行了。。。。");
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000));
            System.out.println("每次拉去的长度" + consumerRecords.count());
            for (ConsumerRecord<String, String> record : consumerRecords) {
                System.out.println(record.offset() + ":" + record.value());
            }
            Thread.sleep(1000);
        }
    }
}
