package com.springcore.standalone.collections;

import java.util.List;
import java.util.Map;

public class Person {
	private List<String> language;
	private Map<String,Double> coursfee;
	
	
	public Map<String,Double> getCoursfee() {
		return coursfee;
	}
	public void setCoursfee(Map<String,Double> coursfee) {
		this.coursfee = coursfee;
	}
	public List<String> getLanguage() {
		return language;
	}
	public void setLanguage(List<String> language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Person [" + language + " : " + coursfee + "]";
	}

	
}
