package com.springcore.referencetype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.collectiontype.Employee;

public class ReferenceMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/referencetype/referenceconfig.xml");
		Teacher teach1 = (Teacher)context.getBean("teach1");
		Teacher teach2 = (Teacher)context.getBean("teach2");
		System.out.println(teach1);
		System.out.println(teach2);
	}

}
