package com.springcore.referencetype;

public class Subject {
	
	private String subject;
	private String experience;
	public Subject(String subject, String experience) {
		super();
		this.subject = subject;
		this.experience = experience;
	}
	
	public Subject() {}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString() {
		return "(" + subject + " : " + experience + ")";
	}

	
}
