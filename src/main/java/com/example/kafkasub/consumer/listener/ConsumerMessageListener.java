package com.example.kafkasub.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

@Slf4j
public class ConsumerMessageListener implements MessageListener<String,String> {
    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        log.info("!!!!!!!!!!!::::::::: LOOK! THIS IS LISTENER: {} :::::::::!!!!!!!!!!!",data);
    }
}
