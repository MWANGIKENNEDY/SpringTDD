/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.myapplication.services;

import com.myapplication.myapplication.models.Users;
import com.myapplication.myapplication.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kennedy
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepository;

    @Override
    public void registerUser(Users users) {
        userRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getOneUser(Long id) {
        return userRepository.findById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(Users users) {
        userRepository.save(users);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);//To change body of generated methods, choose Tools | Templates.
    }
    
}
