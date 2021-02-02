/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.myapplication.controlleradvice;

import com.myapplication.myapplication.exceptionhandler.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Kennedy
 */
@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(value=UserNotFoundException.class)
    public ResponseEntity<Object> exception(UserNotFoundException exception){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }   
}
