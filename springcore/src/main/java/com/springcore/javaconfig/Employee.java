package com.springcore.javaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Employee {
	public static String name;
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee(Address address) {
		super();
		this.address = address;
	}

	public void getMessage() {
		this.address.displayAddress();
		System.out.println("I'm in Employee class");
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
