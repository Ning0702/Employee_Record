package com.ninglearn.employeerecord.service;
import com.ninglearn.employeerecord.domain.Employee;

public class EmployeeService {
	private Employee[] employees;
	private int employeeNums = 1; //record how many employees in the system
	private int idCounter = 1; //record the id number
	
	/*
	 * constructor
	 */
	public EmployeeService(int size) {
		employees = new Employee[size];//when initializing EmployeeService object, set the size of the array
		//for test, set a value in the array
		employees[0] = new Employee(1, "Jack", 'M', "12345", 3500, "accounting");
	}
	
	/*
	 * list() method for showing the record
	 * return: houses
	 */
	public Employee[] list() {
		return employees;
	}
	

}
