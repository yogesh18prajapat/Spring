package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entity.Student;

@Component
public class StudentDaoImp implements StudentDao{
	
	@Autowired
	private JdbcTemplate  jTemplet;

	public JdbcTemplate getJTemplet() {
		return jTemplet;
	}

	public void setJTemplet(JdbcTemplate jTemplet) {
		this.jTemplet = jTemplet;
	}

	public int insert(Student student) {
		// create a  query
		String query = "INSERT INTO student(id,name,city) values(?,?,?)";
		// fire query
		int change = this.jTemplet.update(query,student.getId(),student.getName(),student.getCity());
		//returning no of columns changed
		return change;
	}

	public int update(Student student) {
		String query ="update student set name=? , city=? where id=? ";
		int change = this.jTemplet.update(query,student.getName(),student.getCity(),student.getId());
		return change;
	}

	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int change = this.jTemplet.update(query,studentId);
		return change;
	}
	
	public Student getStudent(int studentId) {
		//query to get single Student object
		String query = "select * from student where id=?";
		//Fire query
		//we can use 'new BeanPropertyRowMapper<T>(T.class)' instead of creating RowMapper<T> object
		Student student = this.jTemplet.queryForObject(query,new BeanPropertyRowMapper<Student>(Student.class),studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		//query to get all Student objects
		String query = "select * from student";
		//Creating RowMapper<T> object
		RowMapper<Student> rowMapper = new RowMapperImp();
		//Fire query
		List<Student> students = this.jTemplet.query(query,rowMapper);
		return students;
	}

}
