package org.javacource.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.javacource.activemq.jms.JmsProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@SpringBootApplication
@EnableJms
@Slf4j
public class JmsActivempApplication implements ApplicationRunner {

    @Autowired
    private JmsProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(JmsActivempApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        String topicStr = "test.topic";
        String queueStr = "test.queue";
        Destination queue = new ActiveMQQueue(queueStr);
        Destination topic = new ActiveMQTopic(topicStr);
        Map<String, String> queue_message = new HashMap<>(1);
        queue_message.put("test-topic", "test-topic");
        log.info("send message to queue " + queueStr + " :: " + queue_message);
        producer.sendMessage(topic, queue_message);
        Map<String, String> topic_message = new HashMap<>(1);
        topic_message.put("test-topic", "test-topic");
        log.info("send message to topic " + topicStr + " :: " + topic_message);
        producer.sendMessage(topic, topic_message);
    }
}
