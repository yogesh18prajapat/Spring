package com.contructorinjection;

public class Language {
	private String language;
	
	public Language() {}
	 
	public Language(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return this.language;
	}
	

}
