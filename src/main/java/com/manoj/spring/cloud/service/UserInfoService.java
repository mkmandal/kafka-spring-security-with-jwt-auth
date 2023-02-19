package com.manoj.spring.cloud.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.manoj.spring.cloud.model.UserInfo;

@Service("userInfoService")
public interface UserInfoService {

	UserInfo saveUser(UserInfo user);

	UserDetails loadUserByUsername(String username);
    

}
