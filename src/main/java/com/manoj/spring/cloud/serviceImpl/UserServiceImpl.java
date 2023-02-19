package com.manoj.spring.cloud.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.manoj.spring.cloud.model.User;
import com.manoj.spring.cloud.service.UserService;
import com.manoj.spring.cloud.userRepository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		User saveUser = userRepository.save(user);

		return saveUser;

	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<User> getAllUser() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

	@Override
	public Optional<User> getUserById(Integer id) {

		Optional<User> user = userRepository.findById(id);

		return user;
	}

}
