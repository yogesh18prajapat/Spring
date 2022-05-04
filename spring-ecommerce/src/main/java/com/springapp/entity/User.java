package com.springapp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@JoinColumn()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, username, email, password, phone_no;
	
	@OneToMany(mappedBy = "user")
	private List<UserCart> userCart;
	
	@OneToMany(mappedBy = "user")
	private List<UserOrders> userOrders;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	@Override
	public String toString() {
		return id +" : " + name + " : " + username + " : " + email + " : " + password + " : " + phone_no;
	}

	public List<UserCart> getUserCart() {
		return userCart;
	}

	public void setUserCart(List<UserCart> userCart) {
		this.userCart = userCart;
	}

	public List<UserOrders> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<UserOrders> userOrders) {
		this.userOrders = userOrders;
	}







}
