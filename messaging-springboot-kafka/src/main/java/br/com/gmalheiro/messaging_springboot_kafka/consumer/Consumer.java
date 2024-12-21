package br.com.gmalheiro.messaging_springboot_kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @KafkaListener(topics = "hello-topic",groupId = "group-1")
    public void receiveMessage(String message) {
        System.out.println("Consumer message: "+ message);
        logger.info("app-dev received message at consumer! message: -> {}",message);
    }
}
