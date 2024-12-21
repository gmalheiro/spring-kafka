package br.com.gmalheiro.messaging_springboot_kafka.controller;

import br.com.gmalheiro.messaging_springboot_kafka.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/kafka")
public class AppController {
    @Autowired
    private Producer service;

    @GetMapping("/hello/{message}")
    public ResponseEntity<String> helloKafka (@PathVariable("message") String message) {
        service.sendMessage(message);
        return ResponseEntity.ok("OK! Message: " + message + " was sent!");
    }
}
