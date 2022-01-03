package com.ninglearn.employeerecord.domain;

public class Employee {
	private int id;
	private String name;
	private char gender; 
	private String phone;
	private int salary;
	private String department; 
	public Employee(int id, String name, char gender, String phone, int salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.salary = salary;
		this.department = department;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return id + 
				"\t" + name + 
				"\t" + gender + 
				"\t" + phone + 
				"\t" + salary+ 
				"\t" + department;
	}
	
	

}
