/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.myapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapplication.myapplication.models.Users;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Kennedy
 */
public interface UserRepository extends JpaRepository<Users, Long>{
    public Users findByFname(String name);
}
