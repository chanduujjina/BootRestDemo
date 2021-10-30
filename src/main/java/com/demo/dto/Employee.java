package com.demo.dto;

public class Employee {
	
	public Employee(int id, String name, String gender, String deptName, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.deptName = deptName;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	private int id;
	
	private String name;
	
	private String gender;
	
	private String deptName;
	
	private double salary;

}
