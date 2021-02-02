/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapplication.myapplication;

import com.myapplication.myapplication.models.Users;
import com.myapplication.myapplication.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepoIntegrationTest {
    
    @Autowired
    private TestEntityManager testEntityManager;
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    public void findUser_withUserName(){
        long id=10;
        Users users=new Users(id,"kennedy","mwangi");
        testEntityManager.persist(users);
        testEntityManager.flush();
        Users usersFound=userRepository.findByFname(users.getFname());
        assertThat(usersFound.getFname())
                .isEqualTo(users.getFname());  
    }
}
