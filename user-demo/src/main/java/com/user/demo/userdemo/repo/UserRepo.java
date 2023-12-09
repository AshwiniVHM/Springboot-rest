package com.user.demo.userdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.demo.userdemo.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,Long > {

	//User findByName(String name);

}
