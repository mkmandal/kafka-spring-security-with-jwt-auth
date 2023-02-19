package com.manoj.spring.cloud.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.manoj.spring.cloud.model.UserInfo;
import com.manoj.spring.cloud.security.UserInfoUserDetail;
import com.manoj.spring.cloud.service.UserInfoService;
import com.manoj.spring.cloud.userRepository.UserInfoRepository;

@Component
public class UserInfoImpl implements UserDetailsService, UserInfoService {

	@Autowired
	UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
		return userInfo.map(UserInfoUserDetail::new)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Foud " + username));

	}

	@Override
	public UserInfo saveUser(UserInfo user) {
     
		
		return userInfoRepository.save(user);
	}

}
