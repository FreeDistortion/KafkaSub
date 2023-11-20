package com.example.kafkasub;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

@SpringBootApplication
public class KafkaSubApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSubApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(KafkaMessageListenerContainer<String,String> messageListenerContainer){
        return args ->
        messageListenerContainer.start();
    }
}
