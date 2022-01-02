package com.ninglearn.employeerecord.view;
import com.ninglearn.employeerecord.utils.Utility;

public class EmployeeView {
	private boolean loop = true;
	private char key = ' ';
	
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
				System.out.println("show record");
				break;
			case '2':
				System.out.println("add");
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

}
