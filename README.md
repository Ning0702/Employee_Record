# Employee_Record

## 1. Introduction
This system is for creating, saving, searching, deleting and updating the employees' information. The user can use the system to manage the employees' imformation.

## 2. Structure
Class 1: The main method class. All the system starts from it.
Class 2: The utility class. All the methods reading the user's input are in this class.
Class 3: The view class. It shows the user interface, and accepts the user's input.
Class 4: The service class. It deals with all the data that the user inputs from the view class, and returns the results back to the view class.
Class 5: The domain class. It builds the basic object model of the employee.

## 3. Methods in View Class
* The mainMenu method shows the main menu.
* listEmployee() shows the saved information in the system.
* addEmployee() asks the user to input the new employee information.
* delEmployee() deletes the existing employee information in the syestm.
* findEmployee() accepts the employee id from the user.
* updateEmployee() receives the employee id for updating the information.

## 4. Methods in Service Class
* list() works with listEmployee() in View Class to return all the employees information in the system.
* add(Employee newEmployee) adds the new employee information to the system after addEmployee() gets the user's required id, and returns a boolean value.
* del(int delId) deletes the employee's information after the user inputs the employee id in delEmployee() in View Class, and returns a boolean value.
* findById(int findId) returns the Employee object after findEmployee() works. If the employee id does not exists in the system, this method will return null.
