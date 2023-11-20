package com.example.kafkasub.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
public class MyConsumer {
    @KafkaListener(id = "kafkaexam1groupid",topics = "kafkaexam2",containerFactory = "concurrentKafkaListenerContainerFactory")
    public void l(String msg){
        log.info("%%%%%%%%%%%KafkaListner입니다... 제발요... MESSAGE: {}",msg);
    }
}
