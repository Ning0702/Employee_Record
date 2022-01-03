package com.ninglearn.employeerecord.view;
import com.ninglearn.employeerecord.domain.Employee;
import com.ninglearn.employeerecord.service.EmployeeService;
import com.ninglearn.employeerecord.utils.Utility;

public class EmployeeView {
	private boolean loop = true;
	private char key = ' ';
	private EmployeeService employeeService = new EmployeeService(100);
	
	/*
	 * Add the main menu for the system
	 */
	public void mainMenu() {
		do {
			System.out.println("\n\n----------------Employee Record Menu----------------");
			System.out.println("\t\t1 Employee Record");
			System.out.println("\t\t2 Add Employee");
			System.out.println("\t\t3 Delete Employee");
			System.out.println("\t\t4 Find Employee");
			System.out.println("\t\t5 Update Employee");
			System.out.println("\t\t6 Sign out");
			System.out.print("Please input your choice(1-6): ");
			key = Utility.readChar();
			switch (key) {
			case '1':
				listEmployees();
				break;
			case '2':
				addEmployee();
				break;
			case '3':
				System.out.println("delete");
				break;
			case '4':
				System.out.println("find");
				break;
			case '5':
				System.out.println("update");
				break;
			case '6':
				System.out.println("log out");
				loop = false;
				break;
			}
		}while(loop);
	}
	
	/*
	 * show the employees information in the system
	 */
	public void listEmployees() {
		System.out.println("\n\n----------------The List of Employee----------------");
		System.out.println("ID\tName\tGender\tPhone\tSalary\tDepartment");
		Employee[] employees = employeeService.list();
		for(int i = 0; i < employees.length; i++) {
			if(employees[i] == null) {
				break;
			}
			System.out.println(employees[i]); //use toString
		}
		System.out.println("----------------Employee Info as above----------------");
	}
	
	/*
	 * Add employee's information
	 */
	public void addEmployee() {
		System.out.println("----------------Please Add Employee Info----------------");
		System.out.print("Name: ");
		String name = Utility.readString(10);
		System.out.print("Gender: ");
		char gender = Utility.readChar();
		System.out.print("Phone: ");
		String phone = Utility.readString(12);
		System.out.print("Salary: ");
		int salary = Utility.readInt();
		System.out.print("Department: ");
		String department = Utility.readString(15);
		
		Employee newEmployee = new Employee(0, name, gender, phone, salary, department);
		if(employeeService.add(newEmployee)) {
			System.out.println("----------------Info is successful added----------------");
		} else {
			System.out.println("----------------Info is not added----------------");
		}
	}
}
