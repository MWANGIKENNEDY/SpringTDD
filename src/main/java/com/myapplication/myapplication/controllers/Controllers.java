package com.myapplication.myapplication.controllers;

import com.myapplication.myapplication.exceptionhandler.UserNotFoundException;
import com.myapplication.myapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapplication.myapplication.models.Users;
import com.myapplication.myapplication.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/api/v1")
public class Controllers {
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserRepository userRepository;
    
    //register new user
    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerUser(@RequestBody Users users){
        userService.registerUser(users);
        return new ResponseEntity<>("User registered successfully",HttpStatus.CREATED);
    }
    //get all users
    @GetMapping(value = "/users")
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    //get one user
    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable("id") Long id){
        if(!userRepository.findById(id).isPresent()) throw new UserNotFoundException();
        return new ResponseEntity<>(userService.getOneUser(id),HttpStatus.OK);
    }
    //update a user
    @PutMapping(value = "/users/update/{id}")
    public  ResponseEntity<Object> updateUser(@PathVariable("id") Long id, @RequestBody Users users){
        if(!userRepository.findById(id).isPresent()) throw new UserNotFoundException();
        users.setId(id);
        return new ResponseEntity<>("User with id:"+id+" updated successfully",HttpStatus.OK);
    }
    //delete a user
    @DeleteMapping(value = "/users/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id){
        if(!userRepository.findById(id).isPresent()) throw new UserNotFoundException();
        userService.deleteUser(id);
        return new ResponseEntity<>("User with id:"+id+" deleted successfully",HttpStatus.OK);
    }
    
}
