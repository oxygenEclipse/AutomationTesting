package controlStatements;

import java.util.Scanner;

public class OddEven {
	public static void main(String[] args) {
		Scanner inputNumber = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int num = inputNumber.nextInt();
		if(num%2==0) {
			System.out.println("Even");
		}
		else
		{
			System.out.println("Odd");
		}
		inputNumber.close();
	}
}
