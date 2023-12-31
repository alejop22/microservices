package com.microservice.student.config;

import com.microservice.student.event.Event;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProviderConfig {

    @Value("${spring.kafka.bootstrapServers}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory<String, Event<?>> providerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, Event<?>> kafkaTemplate(ProducerFactory<String, Event<?>> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

    private Map<String, Object> producerConfig() { // Configuraciones necesarias para el KafkaTemplate, que es el que va a enviar el evento
        Map<String, Object> properties = new HashMap<>();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // El objeto que se encarga de convertir el mensaje de String bytes
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); //  Serielizacion del objeto

        return properties;
    }
}
