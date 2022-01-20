package com.myway.tok.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myway.tok.HomeController;
import com.myway.tok.dao.StudentDAO;
import com.myway.tok.model.Student;

@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private StudentDAO studentDAO;
	
	// 방법 1
	@RequestMapping(value = "/student01" , method = RequestMethod.GET)
	public String student01(Model model) {
		model.addAttribute("student", new Student());
		return "student/student";
	}
	
	// 방법 2
	@RequestMapping(value = "/student02.do" ,method = RequestMethod.GET)
	public ModelAndView student02() {
		
		// 학생 조회
		studentDAO.select();
		
		//return new ModelAndView("student/student","student",new Student());
		return new ModelAndView("student/student","stduent",new Student());
		
	}
	
	@RequestMapping(value="add/student.do",method = RequestMethod.POST)
	public String addStudent(Model model, @ModelAttribute Student student) {
		model.addAttribute("student",student);
		studentDAO.create(student);
		return "student/result";
	}
	
}
