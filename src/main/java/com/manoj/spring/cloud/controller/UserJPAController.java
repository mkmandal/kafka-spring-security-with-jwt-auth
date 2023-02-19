package com.manoj.spring.cloud.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manoj.spring.cloud.exception.UserNotFoundException;
import com.manoj.spring.cloud.model.AuthRequest;
import com.manoj.spring.cloud.model.User;
import com.manoj.spring.cloud.model.UserInfo;
import com.manoj.spring.cloud.security.JwtService;
import com.manoj.spring.cloud.security.WebSecurityConfig;
import com.manoj.spring.cloud.service.UserInfoService;
import com.manoj.spring.cloud.service.UserService;

@RestController
@RequestMapping("restservice/jpa/v1")
public class UserJPAController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserInfoService userInfoService;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/getAllUser")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> getAllUser() {
		List<User> users = userService.getAllUser();
		return users;
	}

	@GetMapping("/getOne/{id}")
	@PreAuthorize("hasAuthority('USER')")
	public Optional<User> getOne(@PathVariable Integer id) {
		Optional<User> user = userService.getUserById(id);
		if (user == null) {
			throw new UserNotFoundException("id ==" + id);
		}

		return user;
	}

	@PostMapping("/user")
	public ResponseEntity saveUser(@RequestBody User user) {
		User us = userService.saveUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(us.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@PostMapping("/add-newUser")
	public ResponseEntity saveUserInfo(@RequestBody UserInfo userInfo) {
		String password= userInfo.getPassword();
		userInfo.setPassword(encoder.encode(password));
		UserInfo us = userInfoService.saveUser(userInfo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(us.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@DeleteMapping("/deleteUser/{id}")
	public void saveUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

	@PostMapping("/authenticate")
	    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	        org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(authRequest.getUsername());
	        } else {
	            throw new UsernameNotFoundException("invalid user request !");
	        }
	        
	}

}
