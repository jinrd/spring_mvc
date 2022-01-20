package com.myway.tok.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myway.tok.model.Student;

import lombok.extern.log4j.Log4j;

@Log4j
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
	
	
	// 학생 조회 메소드
	public void select() {
		
	}
	
	// 학생 수정 메서드
	public void update(Student student) {
		String sql = "INSERT into Student_Bad(stuno,id, sname, age) values(seq.nextval,?,?,?) ";
		
		jdbcTemplate.update(sql,student.getId(),student.getName(),student.getAge());
	}
	// 학생 삭제 메소드
	public void delete() {
		
	}
	
	// 학생 입력 후 에러가 발생하는 지점
	@Transactional
	public void sampleTransaction(Student student) {
		this.create(student);
		this.update(student);
	}
}
