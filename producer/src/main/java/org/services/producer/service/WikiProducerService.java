package org.services.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikiProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    //since we used StringSerializer for producer value and key, we have to use String for both types
    public void sendMessage(String event){
        log.info(String.format("publishing event:%s",event));
        kafkaTemplate.send("wiki-stream-topic",event);
    }
}
