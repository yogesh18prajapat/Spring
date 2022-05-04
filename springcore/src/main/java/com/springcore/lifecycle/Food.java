package com.springcore.lifecycle;

public class Food {
	private String name;
	private double price;

	public Food() {
	}

	public Food(String name, double price) {
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

	// method name can be customized but method signature must be same(i.e public
	// void and no parameters)
	public void create() {
		System.out.println("Creating Food Object");
	}

	// method name can be customized but method signature must be same(i.e public
	// void and no parameters)
	public void delete() {
		System.out.println("Destroying Food Object");
	}
}
