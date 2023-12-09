package com.user.demo.userdemo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.user.demo.userdemo.entity.User;
import com.user.demo.userdemo.service.UserService;

import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
public class UserController {
	@Autowired
	UserService service;
	
	

	@GetMapping("/user/findUser/{id}")
	public Optional<User> findUser(@PathVariable Long id) {
		Optional<User> user = service.findUserById(id);
		return user;

	}

	@GetMapping("/user/findAllUsers")
	List<User> findAllUsers() {
		return service.findAllUsers();
	}

	@PostMapping("/user/saveUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		service.saveUser(user);
		URI locationl = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(locationl).build();
	}

	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<User> deleteUsers(@PathVariable Long id) {
		service.deleteUserById(id);
		return ResponseEntity.ok(null);

	}

	@PutMapping("/user/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		service.updateUser(user);
		return ResponseEntity.ok(null);
	}

}
