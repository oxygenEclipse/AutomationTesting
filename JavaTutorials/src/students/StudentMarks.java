package students;

import java.util.Scanner;

public class StudentMarks {
	
public StudentMarks() {
 }	
public int StudentAverage(int mark1,int mark2,int mark3,int mark4,int mark5) {
	int average = (mark1 + mark2 + mark3 + mark4 + mark5) / 5;
return average;
}
public static void main(String[] args) {
	StudentMarks student = new StudentMarks();
	Scanner s = new Scanner(System.in);
	String Name;
	int m1,m2,m3,m4,m5;
	int avg;
	System.out.println("Enter the Student Name : ");
	Name = s.next();
	System.out.println("Enter the Marks : ");
	m1 = s.nextInt();
	m2 = s.nextInt();
	m3 = s.nextInt();
	m4 = s.nextInt();
	m5 = s.nextInt();
	avg = student.StudentAverage(m1,m2,m3,m4,m5);
	System.out.println("Student Name : " + Name);
	System.out.println("Average : " + avg);
	s.close();
}
}
