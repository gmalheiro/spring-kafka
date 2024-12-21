package br.com.gmalheiro.messaging_springboot_kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("hello-topic",message);
        logger.info("app-dev message was sent to the broker by the producer! Message: -> {}",message);
    }

}
