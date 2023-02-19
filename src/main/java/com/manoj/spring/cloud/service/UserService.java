package com.manoj.spring.cloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manoj.spring.cloud.model.User;

@Service
public interface UserService {
	
    User saveUser(User user);
    
    void deleteUser(Integer id);
    
    List<User> getAllUser();
    
    Optional<User> getUserById(Integer id);
    
   

}
