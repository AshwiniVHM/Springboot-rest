package com.user.demo.userdemo.service;

import java.util.List;
import java.util.Optional;

import com.user.demo.userdemo.entity.User;

public interface UserService {

	Optional<User> findUserById(Long id);

	List<User> findAllUsers();

	User saveUser(User user);

	String deleteUserById(Long id);

	User updateUser(User user);
	
	//User getUserByName(String name);

}
