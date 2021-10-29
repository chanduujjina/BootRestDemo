package com.demo.resources;

public class Test {
	
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

	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + "]";
	}

	public Test(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private int id;
	
	private String name;

}
