package com.myway.tok.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myway.tok.HomeController;
import com.myway.tok.model.Student;

@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 방법 1
	@RequestMapping(value = "/student01" , method = RequestMethod.GET)
	public String student01(Model model) {
		model.addAttribute("student", new Student());
		return "student/student";
	}
	
	// 방법 2
	@RequestMapping(value = "/student02" ,method = RequestMethod.GET)
	public ModelAndView student02() {
		return new ModelAndView("student/student","student",new Student());
	}
	
	@RequestMapping(value="add/student",method = RequestMethod.POST)
	public String addStudent(Model model, @ModelAttribute Student student) {
		model.addAttribute("student",student);
		return "student/result";
	}
}
