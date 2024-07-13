package com.neehait.emptask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neehait.emptask.entity.Employee;
import com.neehait.emptask.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		
		Employee creteEmployee = service.creteEmployee(emp);
		
		return new ResponseEntity<Employee>(creteEmployee,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		
		Employee employeebyId = service.getEmployeebyId(id);
		
		return new ResponseEntity<Employee>(employeebyId,HttpStatus.OK);
		
	}

}
