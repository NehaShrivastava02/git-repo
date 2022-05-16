package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	
	
	

}
