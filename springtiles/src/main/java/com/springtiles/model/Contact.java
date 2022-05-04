package com.springtiles.model;

import java.beans.JavaBean;

@JavaBean
public class Contact {
	private String firstnme,lastname,email,phone;

	public Contact(String firstnme, String lastname, String email, String phone) {
		super();
		this.setFirstnme(firstnme);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setPhone(phone);
	}

	public String getFirstnme() {
		return firstnme;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setFirstnme(String firstnme) {
		this.firstnme = firstnme;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [" + firstnme + " : " + lastname + " : " + email + " : " + phone + "]";
	}
	
	
	
	
	
}
