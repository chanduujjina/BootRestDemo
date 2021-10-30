package com.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.Employee;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/empInfo")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/getAll")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employeeList = employeeService.getEmployees();
		ResponseEntity responseEntity = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping("/getById/{id}")
	public ResponseEntity<Employee> getEmployees(@PathVariable("id") int id) {
		Employee employee = employeeService.getEmployeeById(id);
		ResponseEntity responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/save")
	public ResponseEntity saveEmployee(@RequestBody Employee emp) {
		List<Employee> employeeList =  employeeService.saveEmployee(emp);
		ResponseEntity responseEntity = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity upEmployee(@RequestBody Employee emp,@PathVariable("id") int id) {
		List<Employee> employeeList =  employeeService.updateEmployee(emp, id);
		ResponseEntity responseEntity = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.CREATED);
		return responseEntity;
	}

}
