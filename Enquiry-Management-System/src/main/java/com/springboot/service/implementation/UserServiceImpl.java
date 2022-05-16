package com.springboot.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.dao.UserDao;
import com.springboot.entity.User;
import com.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public List<User> getAllUsers() {
		
		return userDao.findAll();
	}



	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}



	@Override
	public User getUserById(Long id) {
		return userDao.findById(id).get();
	}



	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}



	@Override
	public void deleteUserById(Long id) {
		userDao.deleteById(id);
		
	}

}
