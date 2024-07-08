package org.services.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikiTopicConfig {
    @Bean
    public NewTopic wikiTopic(){
        return TopicBuilder.name("wiki-stream-topic")
                .build();
    }
}
