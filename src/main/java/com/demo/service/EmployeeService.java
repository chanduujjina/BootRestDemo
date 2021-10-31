package com.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.dto.Employee;
import com.demo.exception.EmployeeNotFoundException;

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
	
	/**
	 * @param employee
	 * @return
	 * purpose of this method to dave employee data
	 */
	public List<Employee> saveEmployee(Employee employee){
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		employeeList.add(employee);
		return employeeList;
	}
	
	public List<Employee> updateEmployee(Employee employee,int id) throws EmployeeNotFoundException{
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
	
		//verify whether the record prtesent in mockservice or not
		Optional<Employee> optionEmployee =employeeList.stream().filter(emp->emp.getId()==id).findAny();
		
		if(optionEmployee.isPresent()) {
			Employee updtemployee =	optionEmployee.get();
			if(employee.getSalary() != 0) {
				updtemployee.setSalary(employee.getSalary());
				}
				if(employee.getName() != null) {
					updtemployee.setName(employee.getName());	
				}
				if(employee.getDeptName() != null) {
					updtemployee.setDeptName(employee.getDeptName());	
				}
				if(employee.getGender() != null) {
					updtemployee.setGender(employee.getGender());	
				}
				return employeeList;
		}
		
		throw new EmployeeNotFoundException("No Employee found to update");
		
	}
	
	public List<Employee> saveOrupdateEmployee(Employee employee,int id){
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		//verify whether the record prtesent in mockservice or not
		Optional<Employee> optionEmployee =employeeList.stream().filter(emp->emp.getId()==id).findAny();
		if(optionEmployee.isPresent()) {
			Employee updtemployee =	optionEmployee.get();
			if(employee.getSalary() != 0) {
				updtemployee.setSalary(employee.getSalary());
				}
				if(employee.getName() != null) {
					updtemployee.setName(employee.getName());	
				}
				if(employee.getDeptName() != null) {
					updtemployee.setDeptName(employee.getDeptName());	
				}
				if(employee.getGender() != null) {
					updtemployee.setGender(employee.getGender());	
				}
		}
		else {
			employeeList.add(employee);
		}
		
		return employeeList;
	}
	
	
	public List<Employee> deleteEmployee(int id) throws EmployeeNotFoundException {
		List<Employee> employeeList = MockEmployeeService.getEmployeeList();
		Optional<Employee> optionEmployee =employeeList.stream().filter(emp->emp.getId()==id).findAny();
		
		if(optionEmployee.isPresent()) {
			Employee employee = optionEmployee.get();
			employeeList.remove(employee);
			return employeeList;
		}
		
		throw new EmployeeNotFoundException("No employee found to delete");
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
