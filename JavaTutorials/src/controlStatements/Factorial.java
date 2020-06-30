package controlStatements;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		int factorial = 1, ipFactorial;
		Scanner inputFactorial = new Scanner(System.in);
		System.out.println("Enter the Number :");
		ipFactorial = inputFactorial.nextInt();
		for (int i = 1; i <= ipFactorial; i++) {
			factorial = factorial * i;
		}
		System.out.println("Factorial: " + factorial);
		inputFactorial.close();
	}
}
