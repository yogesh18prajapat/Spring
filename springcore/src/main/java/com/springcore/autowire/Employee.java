package com.springcore.autowire;


public class Employee {
	private Address address;
	
	public Employee() {}

	public Employee(Address address) {
		super();
		System.out.println("Employee constructor called: ");
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return this.address.toString();
	}
	

}
