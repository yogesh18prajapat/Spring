package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entity.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("..............Starting operation...............");
		//Creating Student object
		Student s1 = new Student(1003,"ww","new york");
		
		// SpringJdbc => jdbcTemplet
		ApplicationContext context =
				new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao =context.getBean("studentDaoImp",StudentDao.class);
		
		System.out.println(studentDao.getStudent(1001));
		System.out.println("-----------------------------------------------------------------");
		 List<Student> studs = studentDao.getAllStudents();
		 for(Student s:studs) {
			 System.out.println(s);
		 }
		System.out.println("-----------------------------------------------------------------");
	
		
		System.out.println("..............successfully completed............");
	}
}
