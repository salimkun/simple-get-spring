package com.example.springbootoopproject.service;

import com.example.springbootoopproject.model.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "product-events", groupId = "product-group")
    public void listen(Product product) {
        System.out.println("Received Product event: " + product);
        // Here you would typically process the event, e.g., update another microservice,
        // trigger a notification, or re-index in ElasticSearch.
    }
}
