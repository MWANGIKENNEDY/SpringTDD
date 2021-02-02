package com.myapplication.myapplication.services;

import com.myapplication.myapplication.models.Users;
import java.util.List;
import java.util.Optional;

public interface UserService {
    //register a user
    public void registerUser(Users users);
    //get all users
    public List<Users> getAllUsers(); 
    //get one user
    public Optional<Users> getOneUser(Long id);
    //update user
    public void updateUser(Users users);
    //deleteUsers
    public void deleteUser(Long id);
}
