package com.blogwebsitebackend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                    .authorizeHttpRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic();
                    
        return httpSecurity.build();
    }
}
