package com.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springapp.dao.UserDao;
import com.springapp.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void save(User user) {
		this.userDao.insert(user);
	}
	
	@Transactional
	public boolean containsUser(User user) {
		boolean hasUser = this.userDao.containsUser(user);
		return hasUser;
	}
	
	@Transactional
	public User getUserById(int userId) {
		User u = this.userDao.getUserById(userId);
		return u;
	}
	
	@Transactional
	public void update(User user) {
		this.userDao.update(user);
	}
	
	@Transactional
	public String isValid(String username, String password) {
	 String result = this.userDao.isAValidUser(username, password);
	 return result;
	}
	
	@Transactional
	public User getUserByUsername(String username) {
		User u = this.userDao.getUserByUsername(username);
		return u;
	}
	
	@Transactional
	public int getUserId(String username) {
		int id = this.userDao.getUserId(username);
		return id;
	}
	
	
	
	

}
