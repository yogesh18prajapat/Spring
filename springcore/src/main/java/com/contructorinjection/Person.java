package com.contructorinjection;

import java.util.List;

public class Person {
	private String name;
	private int age;
	private Language language;
	private List<String> list;
	
	public Person() {}

	public Person(String name, int age, Language language, List<String> list) {
		super();
		this.name = name;
		this.age = age;
		this.language = language;
		this.list=list;
	}

	@Override
	public String toString() {
		return name + " : " + age + " : " + language+ " : " + list;
	}
	
	
}
