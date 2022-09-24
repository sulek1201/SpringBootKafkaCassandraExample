package com.example.demo.service;

import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void createUser(UserDto userDto);
}
