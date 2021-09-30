package com.pavan.restapi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pavan.restapi.model.Employee;

@Controller
//@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping("home")
	//@ResponseBody
	public String home() {
		System.out.println("hi");
		//return "home.jsp";
		return "home"; //to declare like this we need to add prefix and suffix in application.properties
	}
	
	@RequestMapping("homeWithName")
	public String homeWithName(HttpServletRequest httpServletRequest) {
		
		HttpSession httpSession = httpServletRequest.getSession();
		String name = httpServletRequest.getParameter("name");
		System.out.println("Hi "+name);
		httpSession.setAttribute("name", name);
		return "home";
	}
	
	@RequestMapping("homeWithNameUsingModelAndView")
	public ModelAndView homeWithName(@RequestParam("name") String myName) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home");
		System.out.println("Hi "+myName);
		
		return mv;
	}
	
	@RequestMapping("homeWithObjectUsingModelAndView")
	public ModelAndView homeWithObject(Employee employee) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",employee);
		mv.setViewName("home");
		System.out.println("Hi "+employee);
		
		return mv;
	}

}
