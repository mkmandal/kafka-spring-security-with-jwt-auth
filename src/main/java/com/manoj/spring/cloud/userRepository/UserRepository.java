package com.manoj.spring.cloud.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manoj.spring.cloud.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}
