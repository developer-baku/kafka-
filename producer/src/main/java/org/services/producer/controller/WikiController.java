package org.services.producer.controller;

import lombok.RequiredArgsConstructor;
import org.services.producer.stream.WikiStreamConsumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wiki")
@RequiredArgsConstructor
public class WikiController {
    private final WikiStreamConsumer wikiStreamConsumer;
    @GetMapping
    public ResponseEntity<String> getPublishing(){
        wikiStreamConsumer.consumeWikiStreamAndPublish();
        return ResponseEntity.ok("getPublishing");
    }
}
