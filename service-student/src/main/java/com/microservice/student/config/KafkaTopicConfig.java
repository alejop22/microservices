package com.microservice.student.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic() {

        Map<String, String> topicConfigurations = new HashMap<>();

        topicConfigurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete (borra mensajes) // compact (Mantiene el mas actual)
        topicConfigurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Cuanto van a durar los mensajes en el topic - default -1 = no se borran nunca
        topicConfigurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamaño maximo de los segmentos dentro del topic (1GB)
        topicConfigurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // Tamaño maximo de cada mensaje - default 1mb

        return TopicBuilder.name("alejo-topic")
                .partitions(2) // 2 particiones del topic
                .replicas(2) // 2 copias del mensaje que se produzca en este topic
                .configs(topicConfigurations)
                .build();
    }
}
