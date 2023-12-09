package com.user.demo.userdemo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.user.demo.userdemo.entity.User;
import com.user.demo.userdemo.service.UserService;    




@WebMvcTest(UserController.class)
class UserControllerTest {
	
	@MockBean
	UserService service;
	User user1;
	User user2;
	List<User> users = new ArrayList<User>();
	
	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		user1= new User(1L,"Ashwini","ashwini@gmail.com",111);
		user1= new User(2L,"Srikanth","srikanth@gmail.com",112);
		users.add(user1);
		users.add(user2);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		user1=null;
		user2=null;
	}

	@Test
	@DisplayName("Save user")
	void testSaveUser()throws Exception {
		
		  when(service.saveUser(user1)).thenReturn(user1);
		 
	    
		mockMvc.perform(post("/user/saveUser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(user1)))
		.andExpect(status().isCreated());
	}
	
	@Test
	@DisplayName("update user")
	void testUpdateUser()throws Exception {
		
		  when(service.updateUser(user1)).thenReturn(user1);
		 
	    
		mockMvc.perform(put("/user/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(user1)))
		.andExpect(status().isOk());
	}
	
	
	@Test
	@DisplayName("testing get user by id")
	public void getUserById() throws Exception {
		when(service.findUserById(user1.getId()))
		.thenReturn(Optional.ofNullable(user1));
		
	this.mockMvc.perform(get("/user/findUser/1"))
			.andExpect(status().isOk());
				
	}
	@Test
	@DisplayName("testing get all users by ")
	public void getAllUsers() throws Exception {
		when(service.findAllUsers())
		.thenReturn(users);
		
	this.mockMvc.perform(get("/user/findAllUsers"))
			.andExpect(status().isOk());
				
	}
	@Test
	@DisplayName("delete user details by id")
	public void deleteUser()throws Exception {
		when(service.deleteUserById(1L)).thenReturn("success");
		this.mockMvc.perform(delete("/user/delete/1"))
		.andExpect(status().isOk());
	}

}
