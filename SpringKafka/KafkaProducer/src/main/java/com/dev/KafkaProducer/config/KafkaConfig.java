package com.dev.KafkaProducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    /**
     * If you already have the Kafka topic created and you are confident
     * that it will always exist when your application runs,
     * then you do not strictly need to define the NewTopic bean in your Spring configuration.
     * The NewTopic bean is primarily useful for environments
     * where you want to ensure the topic is created automatically
     * (such as during development, testing, or in environments where infrastructure might be ephemeral or managed through code).
     */
   @Bean
    public NewTopic topic(){
        return TopicBuilder.name(AppConstants.KAFKA_TOPIC_NAME)
//                .partitions()
//                .replicas()
                .build();
    }
}
