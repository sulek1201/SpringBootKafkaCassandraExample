package com.example.demo.service;


import com.example.demo.dto.FollowersDto;
import com.example.demo.dto.KafkaMessage;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component("UserServiceImpl")
@AllArgsConstructor
public class UserServiceImpl implements UserService  {


    private final UserRepository userRepository;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void createUser(UserDto userDto) {
        User user = new User();
        user.setId(ThreadLocalRandom.current().nextLong(100));
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setCreated_at(new Date());
        user = userRepository.save(user);
        List<KafkaMessage> kafkaMessageList = new ArrayList<>();
        KafkaMessage kafkaMessage = new KafkaMessage();
        FollowersDto followersDto = new FollowersDto();
        followersDto.setUserId(user.getId());
        followersDto.setFollowerId(userDto.getFollowerList());
        kafkaMessage.setMessage(followersDto);
        kafkaMessageList.add(kafkaMessage);
        kafkaProducerService.sendMessage(kafkaMessageList);
    }
}
