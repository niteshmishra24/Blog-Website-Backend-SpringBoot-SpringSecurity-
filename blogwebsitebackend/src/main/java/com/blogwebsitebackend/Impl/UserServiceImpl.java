package com.blogwebsitebackend.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogwebsitebackend.model.User;
import com.blogwebsitebackend.payloads.UserDto;
import com.blogwebsitebackend.repositories.UserRepository;
import com.blogwebsitebackend.services.UserService;
import com.blogwebsitebackend.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," ID ",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword((userDto.getPassword()));
        user.setAbout(userDto.getAbout());
        User updateduser = this.userRepository.save(user);

        return this.userToDto(updateduser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " ID ", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " ID ", userId));
        this.userRepository.delete(user);
    }
    
    private User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto,User.class);
        // user.setId(userDto.getId());
        // user.setName(userDto.getName());
        // user.setEmail(userDto.getEmail());
        // user.setPassword(userDto.getPassword());
        // user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user,UserDto.class);
        // userDto.setId(user.getId());
        // userDto.setName(user.getName());
        // userDto.setEmail(user.getEmail());
        // userDto.setPassword(user.getPassword());
        // userDto.setAbout(user.getAbout());
        return userDto;
    }
}
