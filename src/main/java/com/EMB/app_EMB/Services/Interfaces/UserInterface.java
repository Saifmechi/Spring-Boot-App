package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;


import com.EMB.app_EMB.Entity.User;

public interface UserInterface {
 
    User saveUser(User user);
    User updateUser(Integer id, User user);
    void deleteUserById(Integer id);
    User getUserById(Integer id);
    List<User> getAllUsers();    
}
