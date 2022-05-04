package com.contructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConInjMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/contructorinjection/coninjconfig.xml");
		Person person1 = (Person)context.getBean("person1");
		System.out.println(person1);
	}

}
