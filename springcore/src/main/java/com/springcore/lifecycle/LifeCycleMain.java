package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleMain {
	 public static void main(String[] args) {
		//We have to use AbstractApplicationContext to perform registerShutdownHook() method. 
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/lifecycleconfig.xml");
		Food f1 = (Food)context.getBean("f1");
		System.out.println(f1);
		Drink d1 = (Drink)context.getBean("d1");
		System.out.println(d1);
		AnnoExample a1 = (AnnoExample)context.getBean("a1");
		System.out.println(a1);
		
		//this method destroys object
		context.registerShutdownHook();
	}

}
