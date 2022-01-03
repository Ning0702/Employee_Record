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
	
	/*
	 * add(object) for adding, and returns boolean
	 */
	public boolean add(Employee newEmployee) {
		//not thinking enlarge the saving space
		if(employeeNums == employees.length) {
			System.out.println("The saving space is full. No more adding");
			return false;
		}
		//add new data to array
		employees[employeeNums++] = newEmployee;
		newEmployee.setId(++idCounter);
		return true;
	}
	
	/*
	 * delete the employee's info 
	 */
	public boolean del(int delId) {
		//find the index of the employee to delete. delId != index
		int index = -1;
		for(int i = 0; i < employeeNums; i++) {
			if(delId == employees[i].getId()) {
				index = i;
			}
		}
		if(index == -1) {
			return false;
		}
		//If the employee's info is found, all other info following will be moved one position ahead
		for(int i = index; i < employeeNums - 1; i++) {
			employees[i] = employees[i+1];
		}
		employees[--employeeNums] = null; //The last info position becomes null
		return true;
	}
	
	/*
	 * find employee
	 */
	public Employee findById(int findId) {
		for(int i = 0; i < employeeNums; i++) {
			if(findId == employees[i].getId()) {
				return employees[i];
			}
		}
		return null;
	}
}

