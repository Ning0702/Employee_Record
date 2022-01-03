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
				delEmployee();
				break;
			case '4':
				findEmployee();
				break;
			case '5':
				updateEmployee();
				break;
			case '6':
				exit();
				System.out.println("The System is Stopped");
				break;
			}
		}while(loop);
	}
	
	/*
	 * show the employees information stored in the system
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
	
	/*
	 * delete the employee information in the system
	 */
	public void delEmployee() {
		System.out.println("----------------Delete Employee Info----------------");
		System.out.println("Please input the employee's ID to delete (Input -1 to exit): ");
		int delId = Utility.readInt();
		if(delId == -1) {
			System.out.println("----------------Exit the Deletion Function----------------");
			return;
		}
		char choice = Utility.readConfirmSelection();
		if(choice == 'Y') {
			if(employeeService.del(delId)) {
				System.out.println("----------------Delete Employee Info Successfully----------------");
			} else {
				System.out.println("----------------ID is not Found. Fail to Delete.----------------");
			}
		} else {
			System.out.println("----------------Exit the Delete----------------");
		}
	}
	
	/*
	 * find the employee info
	 */
	public void findEmployee() {
		System.out.println("----------------Find Employee----------------");
		System.out.print("Please input the employee's ID: ");
		int findId = Utility.readInt();
		Employee employee = employeeService.findById(findId);
		if(employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("----------------The Employee cann't be found----------------");
		}
	}
	
	/*
	 * Update the employee's info by setXxx()
	 */
	public void updateEmployee() {
		System.out.println("----------------Update Info----------------");
		System.out.print("Please input ID to update info (Input -1 to exit): ");
		int updateId = Utility.readInt();
		if(updateId == -1) {
			System.out.println("----------------Exit the Update----------------");
			return;
		}
		Employee employee = employeeService.findById(updateId);
		if(employee == null) {
			System.out.println("----------------The ID does not Exist----------------");
			return;
		}
		System.out.print("Name(" + employee.getName() + "): ");
		String name = Utility.readString(15, "");
		if(!"".equals(name)) {
			employee.setName(name);
		}
		System.out.print("Gender(" + employee.getGender() + "): ");
		char gender = Utility.readChar();
		if(gender != employee.getGender()) {
			employee.setGender(gender);
		}
		System.out.print("Phone(" + employee.getPhone() + "): ");
		String phone = Utility.readString(12, "");
		if(!"".equals(phone)) {
			employee.setPhone(phone);
		}
		System.out.print("Salary(" + employee.getSalary() + "): ");
		int salary = Utility.readInt();
		if(salary != employee.getSalary()) {
			employee.setSalary(salary);
		}
		System.out.print("Department(" + employee.getDepartment() + "): ");
		String department = Utility.readString(15, "");
		if(!"".equals(department)) {
			employee.setDepartment(department);
		}
		System.out.println("----------------Update Successfully----------------");
	}
	/*
	 * Exit function
	 */
	public void exit() {
		char c = Utility.readConfirmSelection();
		if(c == 'Y') {
			loop = false;
		}
	}
}
