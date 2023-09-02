package com.blogwebsitebackend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blogwebsitebackend.payloads.UserDto;

@Service
public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Long UserId);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
}
