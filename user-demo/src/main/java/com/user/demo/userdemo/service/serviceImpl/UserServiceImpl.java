package com.user.demo.userdemo.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.demo.userdemo.entity.User;
import com.user.demo.userdemo.repo.UserRepo;
import com.user.demo.userdemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo repo;
	
	
	  public UserServiceImpl(UserRepo repo) { 
		  this.repo=repo; 
		  } 
	 
	 

	@Override
	public Optional<User> findUserById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return repo.findAll();
	}

	@Override
	public User saveUser(User user) {
		repo.save(user);
		return user;
	}

	@Override
	public String deleteUserById(Long id) {
		repo.deleteById(id);
		return "success";

	}

	@Override
	public User updateUser(User user) {
		repo.save(user);
		return user;

	}



	/*
	 * @Override public User getUserByName(String name) { name="ashwini"; return
	 * repo.findByName(name); }
	 */

}
