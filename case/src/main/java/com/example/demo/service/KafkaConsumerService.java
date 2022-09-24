package com.example.demo.service;

import com.example.demo.dto.KafkaMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class KafkaConsumerService {

    private final UserFollowersService userFollowersService;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}")
    public void listen(@Payload KafkaMessage kafkaMessage) throws NoSuchFieldException {
        log.info("Message received. MessageID : {} Message: {} Date : {}",
                kafkaMessage.getId(), kafkaMessage.getMessage(), kafkaMessage.getMessageDate());
       userFollowersService.createUserFollowers(kafkaMessage);
    }
}
