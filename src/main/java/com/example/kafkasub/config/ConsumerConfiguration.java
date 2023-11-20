package com.example.kafkasub.config;

import com.example.kafkasub.consumer.listener.ConsumerMessageListener;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
public class ConsumerConfiguration {
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,String> a = new ConcurrentKafkaListenerContainerFactory<>();
        a.setConsumerFactory(consumerFactory());
        return a;
    }
    @Bean
    public KafkaMessageListenerContainer<String,String> messageListenerContainer(){
        ContainerProperties properties = new ContainerProperties("kafkaexam1");
        properties.setGroupId("kafkaexam1groupid");
        properties.setAckMode(ContainerProperties.AckMode.BATCH);
        properties.setMessageListener(new ConsumerMessageListener());

        KafkaMessageListenerContainer container=new KafkaMessageListenerContainer(consumerFactory(),properties);
        container.setAutoStartup(false);
        return container;
    }

    private ConsumerFactory<String,String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerProperties());
    }
    private Map<String, Object> consumerProperties()   {
        Map<String,Object> props=new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }
}
