package com.myapplication.myapplication;

import com.myapplication.myapplication.controllers.Controllers;
import com.myapplication.myapplication.models.Users;
import com.myapplication.myapplication.services.UserService;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(Controllers.class)
public class ServiceLevelTesting {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UserService userService;
    
    @Test
    private void testGetAllEmployees() throws Exception{
        long id=10;
        Users users=new Users(id,"Kennedy","Mwangi");
        List<Users> allUsers=Arrays.asList(users);
        
        given(userService.getAllUsers()).willReturn(allUsers);
        
        mockMvc.perform(
          get("/api/v1/employees")
          .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));              
    }
    
    
    
    
    
    
    
}
