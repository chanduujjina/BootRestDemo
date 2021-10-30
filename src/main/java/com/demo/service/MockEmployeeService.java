package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.dto.Employee;

public class MockEmployeeService {
	
	private static List<Employee> employeeList = new ArrayList();//1
	
	static {// block load 2
		
		employeeList.add(new Employee(1, "chandu", "male", "it", 1000000));
		employeeList.add(new Employee(2, "sai", "male", "it", 3000000));
		employeeList.add(new Employee(3, "gouse", "male", "it", 4000000));
		employeeList.add(new Employee(4, "laxmi", "female", "it", 6000000));
		employeeList.add(new Employee(5, "divya", "female", "it", 3000000));
		employeeList.add(new Employee(6, "test", "male", "admin", 1000000));
		employeeList.add(new Employee(7, "test1", "male", "hr", 8000000));
		
	}
	
	public static  List<Employee> getEmployeeList(){//on call method load 3
		return employeeList;
	}

}
