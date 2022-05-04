package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Drink implements InitializingBean, DisposableBean {
	private String name;
	private double price;

	public Drink() {
	}

	public Drink(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public void setName(String name) {
		System.out.println("setting name: ");
		this.name = name;
	}

	public void setPrice(double price) {
		System.out.println("setting price: ");
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return this.name + " -> " + this.price;
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroy Drink object");
		
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Creating Drink object");
		
	}

}