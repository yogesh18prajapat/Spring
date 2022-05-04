package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnoExample {

	private String name;

	public AnnoExample() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AnnoExample (" + name + ")";
	}

	
	// Note that both the @PostConstruct and @PreDestroy annotations are part of
	// Java EE. Since Java EE was deprecated in Java 9, and removed in Java 11, we
	// have to add an additional dependency to use these annotations:
	@PostConstruct
	public void create() {
		System.out.println("Creating AnnoExample Object");
	}

	@PreDestroy
	public void delete() {
		System.out.println("Destroying AnnoExample Object");
	}

}
