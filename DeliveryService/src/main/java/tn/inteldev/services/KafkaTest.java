package tn.inteldev.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaTest {
    @KafkaListener(topics = "pizzaApp", groupId = "testing")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group testing: " + message);
    }
}
