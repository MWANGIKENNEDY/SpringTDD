package com.myapplication.myapplication;



import com.myapplication.myapplication.models.Users;
import com.myapplication.myapplication.repository.UserRepository;
import com.myapplication.myapplication.services.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.doReturn;



@SpringBootTest
class MyapplicationApplicationTests {

	@Test
	void contextLoads() {
	}
        
        @Autowired
        private UserService userService;
        
        @MockBean
        private UserRepository userRepository;
        
        @Test
        @DisplayName("Test find all")
        void testFindAllUsers(){
            long id1=10;
            long id2=10;
            Users users=new Users(id1,"kennedy","mwangi");
            Users users1=new Users(id2,"james","bond");
            doReturn(Arrays.asList(users,users1)).when(userRepository).findAll();
            List<Users> allUsers=userService.getAllUsers();
            Assertions.assertEquals(2, allUsers.size(), "findAll should return 2 users");  
        }
        
        @Test
        @DisplayName("Test save user")
        void testSave(){
            long id1=10;
            Users users=new Users(id1,"kennedy","mwangi");
            doReturn(users).when(userRepository).save(users);
            Users usersSave=userService.registerUser(users);
            // Assert the response
            Assertions.assertNotNull(usersSave, "The saved widget should not be null");
        }
        
        @Test
        @DisplayName("Test find by ID")
        void testFindById(){
            long id1=10;
            Users users=new Users(id1,"kennedy","mwangi");
            doReturn(Optional.of(users)).when(userRepository).findById(id1);
             // Execute the service call
            Optional<Users> returnedUser = userService.getOneUser(id1);
            Assertions.assertTrue(returnedUser.isPresent(), "Widget was not found");
            Assertions.assertSame(returnedUser.get(), users, "The widget returned was not the same as the mock");  
        }
         
}
