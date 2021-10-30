package com.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.dto.Employee;

@Service
public class EmployeeService {
	
	public Employee getEmployeeById(int id) {
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		Optional<Employee> optionEmployee =employeeList.stream().filter(emp->emp.getId()==id).findAny();
		if(optionEmployee.isPresent()) {
			return optionEmployee.get();
		}
		
		return null;
	}
	
	public List<String> getEmployeeNames() {
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		List<String> nameList = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
		
		return nameList;
	}
	
	public List<Employee> saveEmployee(Employee employee){
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		employeeList.add(employee);
		return employeeList;
	}
	
	public List<Employee> updateEmployee(Employee employee,int id){
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		employeeList.stream().forEach(emp->{
			if(emp.getId()==id) {
				emp.setSalary(employee.getSalary());
			}
		});
		
		
		return employeeList;
	}
	
	public List<Employee> getEmployees(){
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		return employeeList;
	}
	
	public Employee getEmployeeById_v1(int id) {
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		for(Employee employee :employeeList) {
			if(employee.getId()==id) {
				return employee;
			}
		}
		
		return null;
	}

}
