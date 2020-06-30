package controlStatements;

import java.util.Scanner;

public class AgeCheck {
public static void main(String[] args) {
	Scanner inputAge = new Scanner(System.in);
	System.out.println("Enter the Age of Person to Vote : ");
	int age = inputAge.nextInt();
	if (age >= 18) {
		System.out.println("Eligible to Vote");
	}
	else
	{
		System.out.println("Not Eligible to Vote");
	}
	inputAge.close();
}
}
