package com.EMB.app_EMB.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Entity.User;
import com.EMB.app_EMB.Repository.UserRepository;
import com.EMB.app_EMB.Services.Interfaces.UserInterface;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserImpl implements UserInterface {

	@Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("User not found with id " + id));
       
        //existingUser.setFormulaires(user.getFormulaires());
        //existingUser.setCommentaires(user.getCommentaires());

        
        // Update other properties
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUserById(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RessourceNotFoundException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("User not found with id " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



}
