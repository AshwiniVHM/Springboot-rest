package com.user.demo.userdemo.service.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.user.demo.userdemo.entity.User;
import com.user.demo.userdemo.repo.UserRepo;
import com.user.demo.userdemo.service.UserService;

class UserServiceImplTest {
	@Mock
	private UserRepo repo;
	private UserService service;
	AutoCloseable autoCloseable;
	User user;
	
	@BeforeEach
	public void init() {
		autoCloseable=MockitoAnnotations.openMocks(this);
		service=new UserServiceImpl(repo);
		user=new User(6L,"jess","jess@gmail.com",122);
	}
	@AfterEach
	public void cleanup() throws Exception{
		autoCloseable.close();
		
	}
	@Test
	@DisplayName("testing save call")
	public void saveUser() {
		mock(User.class);
		mock(UserRepo.class);
		when(service.saveUser(user)).thenReturn(user);
		assertThat(service.saveUser(user)).isEqualTo(user);
	}
	@Test
	@DisplayName("testing update user call")
	public void updateUser() {
		mock(User.class);
		mock(UserRepo.class);
		when(service.updateUser(user)).thenReturn(user);
		assertThat(service.updateUser(user)).isEqualTo(user);
	}
	@Test
	@DisplayName("testing find by id call")
	public void findUserById() {
		mock(User.class);
		mock(UserRepo.class);
		Long id=6L;
		when(service.findUserById(id)).thenReturn(Optional.ofNullable(user));
		assertThat(service.findUserById(id).get().getId()).isEqualTo(id);
	}
	@Test
	@DisplayName("testing find all users call")
	public void findallUsers() {
		mock(User.class);
		mock(UserRepo.class);
		when(service.findAllUsers()).thenReturn(new ArrayList<User>(Collections.singleton(user)));
		assertThat(service.findAllUsers().get(0).getId()).isEqualTo(user.getId());
	}
	@Test
	@DisplayName("testing delete by id call")
	//@Disabled
	public void deleteUserById() {
		mock(User.class);
		mock(UserRepo.class, Mockito.CALLS_REAL_METHODS);
		Long id=6L;
		doAnswer(Answers.CALLS_REAL_METHODS).when(repo).deleteById(any());
		assertThat(service.deleteUserById(id)).isEqualTo("success");
		
	}


}
