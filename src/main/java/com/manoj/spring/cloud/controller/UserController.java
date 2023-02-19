package com.manoj.spring.cloud.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manoj.spring.cloud.DAO.UserDaoService;
import com.manoj.spring.cloud.exception.UserNotFoundException;
import com.manoj.spring.cloud.model.User;

@RestController
@RequestMapping("restservice/v1")
public class UserController {
	
	@Autowired
	private UserDaoService userDao;
	
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		List<User> users= userDao.getAlluser();
		return users;
	}
	
	
	@GetMapping("/getOne/{id}")
	public User getOne(@PathVariable  Integer id){
		User user= userDao.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id =="+ id);
		}
		
		
		
		return user;
	}
	
	@PostMapping("/user")
	public ResponseEntity saveUser(@RequestBody User user) {
		User us =   userDao.saveUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(us.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
		 
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void saveUser(@PathVariable Integer id) {
		userDao.deletOne(id);
	}
	

}
