package com.example.demo.service;

import com.example.demo.dto.KafkaMessage;
import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;


@Service
public interface UserFollowersService {

    void createUserFollowers(KafkaMessage kafkaMessage);
}
