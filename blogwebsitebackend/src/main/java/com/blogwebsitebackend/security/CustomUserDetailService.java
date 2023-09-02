package com.blogwebsitebackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.blogwebsitebackend.exceptions.ResourceNotFoundException;
import com.blogwebsitebackend.model.User;
import com.blogwebsitebackend.repositories.UserRepository;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "email : " + username,0));
    }
    
}
