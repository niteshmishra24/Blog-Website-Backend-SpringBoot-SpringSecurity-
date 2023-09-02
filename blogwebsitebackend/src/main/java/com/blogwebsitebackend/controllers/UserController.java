package com.blogwebsitebackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogwebsitebackend.payloads.UserDto;
import com.blogwebsitebackend.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto,HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }    

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable("id") Long userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateuser(@RequestBody UserDto userDto,@PathVariable("id") Long userId){
        UserDto updatedUser = this.userService.updateUser(userDto,userId);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userId){
        this.userService.deleteUser(userId);
    }
}
