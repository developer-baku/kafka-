package org.services.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WikiConsumerService {
    @KafkaListener(topics = "wiki-stream-topic",groupId = "my-group")
    public void consumeMessage(String event){
        log.info(String.format("Consuming Kafka event:%s",event));
        //here we can do whatever we want with events,like storing or sending them somewhere
    }
}
