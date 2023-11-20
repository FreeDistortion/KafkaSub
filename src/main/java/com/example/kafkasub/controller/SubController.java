package com.example.kafkasub.controller;

import com.example.kafkasub.consumer.MyConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubController {
    private final KafkaMessageListenerContainer<String,String> messageListenerContainer;
    @PostMapping("/login")
    public void login(String topic){
        messageListenerContainer.start();
//        new MyConsumer().l(pubbutton);
    }
}
