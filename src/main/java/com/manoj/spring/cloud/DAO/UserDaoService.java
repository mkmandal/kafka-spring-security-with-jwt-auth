package com.manoj.spring.cloud.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.manoj.spring.cloud.model.User;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int userCount = 3;

	static {
		users.add(new User(1, "Manoj", new Date()));
		users.add(new User(2, "Mohit", new Date()));
		users.add(new User(3, "Rahul", new Date()));
	}

	public List<User> getAlluser() {

		return users;
	}

	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(Integer id) {

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}

		return null;
	}

	public void deletOne(Integer id) {

		for (User user : users) {
			if (user.getId() == id) {
				users.remove(user);
			}
		}

	}

}
