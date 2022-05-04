package com.springcore.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("person")
//by default the scope of this class will be 'Singleton' so we can change scope if we want.
@Scope("prototype")
public class Person {
	@Value("name")
	private String name;
	@Value("city")
	private String city;
	@Value("#{temp}")
	private List<String> addresses;
	
	
	public Person() {}
	
	public Person(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Person [" + name + " : " + city + " : " + addresses + "]";
	}


	
	
	
}
