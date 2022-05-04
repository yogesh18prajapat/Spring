package com.springapp.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springapp.entity.User;

@Repository("userDao")
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	public void insert(User user) {
		this.hibernateTemplate.saveOrUpdate(user);

	}
	
	public User getUserById(int userId) {
		User u = this.hibernateTemplate.get(User.class, userId);
		return u;
	}
	
	public User getUserByUsername(String username) {
		List<User> users = this.hibernateTemplate.loadAll(User.class);
		for(User x : users ) {
			if(username.equals(x.getUsername())){
				return x;
			}
		}
		return null;
	}
	
	public boolean containsUser(User user) {
		List<User> users = this.hibernateTemplate.loadAll(User.class);
		for(User x : users ) {
			if(user.getUsername().equals(x.getUsername())){
				return true;
			}
		}
		return false;
	}
	
	public String isAValidUser(String username, String password) {
		List<User> users = this.hibernateTemplate.loadAll(User.class);
		if(!(users.equals(null))) {
		for(User x : users ) {
			if(username.equals(x.getUsername())){
				 if(password.equals(x.getPassword())) {
					 return "valid";
				 }
				return "invalid_password";
			}
		 }
		}
		return "invalid_username";
	}
	
	public void update(User user) {
		this.hibernateTemplate.update(user);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int getUserId(String username) {
		List<User> users = this.hibernateTemplate.loadAll(User.class);
		for(User x : users ) {
			if(username.equals(x.getUsername())) {
				return x.getId();
			}
		}
		return 0;
	}
	
	
	

}
