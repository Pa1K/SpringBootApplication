package com.pavan.restapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pavan.restapi.dao.EmployeeRepo;
import com.pavan.restapi.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeeRepo;

	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee){
		employeeRepo.save(employee);
		return "home";
	}
	
	@RequestMapping(path="/employeesE",method=RequestMethod.POST)
	@ResponseBody
	public Employee addEmployee2(@RequestBody Employee employee){
		Employee emp =  employeeRepo.save(employee);
		return emp;
	}
	
	
	@RequestMapping("/getEmployee")
	ModelAndView getEmployeeById(@RequestParam int id){
		ModelAndView mv = new ModelAndView("employeeDetails");
		Employee employee = employeeRepo.findById(id).orElse(new Employee());
		mv.addObject(employee);
		
		System.out.println(employeeRepo.findByTech("java"));
		System.out.println(employeeRepo.findByIdGreaterThan(2));
		System.out.println(employeeRepo.findByIdLessThan(2));
		System.out.println(employeeRepo.findByIdEquals(2));
		System.out.println(employeeRepo.findByTechSorted("java"));
		
		return mv;
	}
	
	@RequestMapping("/employees/{id}")
	@ResponseBody
	public String getEmployeeById2(@PathVariable int id) {
		 return employeeRepo.findById(id).orElse(new Employee()).toString();
	}
	
	@RequestMapping("/employeesE/{eid}")
	@ResponseBody
	public Employee getEmployeeById3(@PathVariable("eid") int id) {
		 return employeeRepo.findById(id).orElse(new Employee());
	}
	
	
	@RequestMapping("/employees")
	@ResponseBody
	public String getAllEmployees() {
		 return employeeRepo.findAll().toString();
	}
	
	@RequestMapping(path = "/employeesE", produces = {"application/xml"})
	@ResponseBody
	public List<Employee> getAllEmployees3() {
		 return employeeRepo.findAll();
	}
	
	
	@RequestMapping("updateEmployee")
	public String updateEmployee(Employee employee){
		
		if (employeeRepo.existsById(employee.getId())) {
			 Employee existingEmployee = employeeRepo.findById(employee.getId()).orElse(new Employee());
			 
			 if(employee.getName() == null)
				 employee.setName( existingEmployee.getName());
			 if(employee.getTech().isEmpty())
				 employee.setTech(existingEmployee.getTech());
		}
		
		employeeRepo.save(employee);
		return "home";
	}
	
	
	@PutMapping("/employeesE")
	@ResponseBody
	public Employee updateEmployee2(@RequestBody Employee employee) {
		Employee emp =  employeeRepo.save(employee);
		return emp;
	}
	
	@DeleteMapping("/employeesE/{id}")
	@ResponseBody
	public String deleteEmployee2(@PathVariable int id) {
		employeeRepo.deleteById(id);
		return "Deleted "+id+" successfully" ;
	}
	
}
