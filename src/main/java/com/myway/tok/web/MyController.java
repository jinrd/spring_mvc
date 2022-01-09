package com.myway.tok.web;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myway.tok.model.TokTok;

@Controller
public class MyController {
	
	@RequestMapping(value="/my/my_string",method = RequestMethod.GET)
	public String myString(Model model) {
		model.addAttribute("tok",new TokTok("my_String"));
		return "my/my_string"; 
	}
	@RequestMapping(value="my/my_modelAndView",method = RequestMethod.GET)
	public ModelAndView myString() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("my/my_modelAndView");
		mav.addObject("tok",new TokTok("my_modeAndView"));
		return mav;
	}
	
	@RequestMapping(value="my/my_toktok",method = RequestMethod.GET)
	public TokTok myTokTok(Model model) {
		return new TokTok("my_toktok");
	}
	
	// 본문을 리턴해준다.
//	@ResponseBody
//	@RequestMapping(value="my/my_body",method = RequestMethod.GET)
//	public String myBody() {
//		String html = "<h2>korea</h2>";
//		return html;
//	}
	
	@ResponseBody
	@RequestMapping(value="my/my_body",method = RequestMethod.GET)
	public ResponseEntity<String> myBody() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","text/html; Cssharset=UTF-8");
		String html = "<h2>korea</h2> <h2>asdf</h2>";
		return new ResponseEntity<String>(html,HttpStatus.OK);
	}
}
