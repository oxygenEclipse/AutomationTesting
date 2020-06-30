package org.emp;

import java.util.Scanner;

public class Employee {
/*public int empId(int Id){
	return Id;
	System.out.println("Employee ID");
}
public void empName() {
System.out.println("Employee Name");
}
public void empDob() {
System.out.println("Employee Date of Birth");
}*/
public static void main(String[] args) {
	//Employee e = new Employee();
	/*e.empId();
	e.empName();
	e.empDob();*/
	//Input Block
	Scanner employee = new Scanner(System.in);
	System.out.println("Enter the Employee ID :");
	int id = employee.nextInt();
	System.out.println("Enter the Employee Name :");
	String empName = employee.next();
	System.out.println("Enter the Employee Email : ");
	String empEmail = employee.next();
	System.out.println("Enter the Phone No : ");
	int phoneNo = employee.nextInt();
	System.out.println("Enter the Salary : ");
	int salary = employee.nextInt();
	System.out.println("Enter the Gender : ");
	String gender = employee.next();
	System.out.println("Enter the City : ");
	String city = employee.next();

	//Print Block
	System.out.println("Employee Id : " + id);
	System.out.println("Employee Name : " + empName);
	System.out.println("Employee Email : " + empEmail);
	System.out.println("Employee Phone No : " + phoneNo);
	System.out.println("Employee Salary : " + salary);
	System.out.println("Employee Gender : " + gender);
	System.out.println("Employee City : " + city);
	employee.close(); 
}
}
