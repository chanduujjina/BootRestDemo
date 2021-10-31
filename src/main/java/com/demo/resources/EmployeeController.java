package com.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.Employee;
import com.demo.exception.EmployeeNotFoundException;
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
		
		
		if(employee !=null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/empByName")
	public ResponseEntity getEmployeesByName(@RequestParam ("name") String name) {
		List<Employee> employeeList = employeeService.getEmployeesByName(name);
		if(employeeList.size()>0) {
		return 	new ResponseEntity(employeeList,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/names")
	public ResponseEntity getEmployeeNames() {
		List<String> nameList = employeeService.getEmployeeNames();
		ResponseEntity responseEntity = new ResponseEntity(nameList,HttpStatus.OK);
	    return responseEntity;	
	}
	@PostMapping("/save")
	public ResponseEntity saveEmployee(@RequestBody Employee emp) {
		List<Employee> employeeList =  employeeService.saveEmployee(emp);
		ResponseEntity responseEntity = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity updateEmployee(@RequestBody Employee emp,@PathVariable("id") int id) {
		List<Employee> employeeList;
		ResponseEntity responseEntity = null;
		try {
			employeeList = employeeService.updateEmployee(emp, id);
			responseEntity  = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.ACCEPTED);
		} catch (EmployeeNotFoundException e) {
			responseEntity  = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@PatchMapping("saveOrupdate/{id}")
	public ResponseEntity saveOrUpdate(@RequestBody Employee emp,@PathVariable("id") int id) {
		List<Employee> employeeList = employeeService.saveOrupdateEmployee(emp, id);
		ResponseEntity responseEntity = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity deleteById(@ PathVariable int id) {
		List<Employee> employeeList;
		ResponseEntity responseEntity = null;
		try {
			employeeList = employeeService.deleteEmployee(id);
		   responseEntity = new ResponseEntity<List<Employee>>(employeeList, HttpStatus.ACCEPTED);
		} catch (EmployeeNotFoundException e) {
			responseEntity  = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

}
