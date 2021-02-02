/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.myapplication.config;

import com.myapplication.myapplication.services.UserService;
import com.myapplication.myapplication.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Kennedy
 */
@Configuration
public class AppConfig {
    
    //declaring a bean of type user-service for dependency injection
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
    
}
