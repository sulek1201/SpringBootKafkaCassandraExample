package com.example.demo.service;

import com.example.demo.dto.FollowersDto;
import com.example.demo.dto.KafkaMessage;
import com.example.demo.dto.UserDto;
import com.example.demo.model.UserFollowers;
import com.example.demo.repository.UserFollowerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component("UserFollowersServiceImpl")
@AllArgsConstructor
public class UserFollowersServiceImpl implements UserFollowersService {

    private final UserFollowerRepository userFollowerRepository;


    @Override
    public void createUserFollowers(KafkaMessage kafkaMessage) {
        List<UserFollowers> userFollowersList = new ArrayList<>();
        Long userId = ((Integer) ((LinkedHashMap) kafkaMessage.getMessage()).get("userId")).longValue();
        List<Integer> followersId = (List<Integer>) ((LinkedHashMap) kafkaMessage.getMessage()).get("followerId");
        FollowersDto followersDto = new FollowersDto(userId,followersId);
        for(Integer followerId : followersDto.getFollowerId()){
            UserFollowers userFollowers = new UserFollowers();
            userFollowers.setUser_id(followersDto.getUserId());
            userFollowers.setFollower_id(followerId.longValue());
            userFollowers.setId(ThreadLocalRandom.current().nextLong(100));
            userFollowersList.add(userFollowers);
        }
        userFollowerRepository.saveAll(userFollowersList);
    }
}
