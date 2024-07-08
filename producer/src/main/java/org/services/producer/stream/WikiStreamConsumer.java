package org.services.producer.stream;

import lombok.extern.slf4j.Slf4j;
import org.services.producer.service.WikiProducerService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikiStreamConsumer {
    private final WebClient webClient;
    private final WikiProducerService service;

    public WikiStreamConsumer(WebClient.Builder builder, WikiProducerService service) {
        this.webClient = builder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.service = service;
    }
    public void consumeWikiStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(service::sendMessage);

    }
}
