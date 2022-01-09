package com.myway.tok.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.myway.tok.model.Student;

@Component
public class StudentDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(Student student) {
		System.out.println(student.getId()+student.getName()+student.getAge());
		String sql = "INSERT into Student(stuno,id, sname, age) values(seq.nextval,?,?,?) ";
		
		jdbcTemplate.update(sql,student.getId(),student.getName(),student.getAge());
	}
}
