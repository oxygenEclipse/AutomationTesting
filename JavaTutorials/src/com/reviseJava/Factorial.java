package com.reviseJava;

public class Factorial {

	public static void main(String[] args) {
		int num = 10, factorial = 1;

		for (int i = 1; i <= num; i++) {
			factorial = factorial * i;
		}
		System.out.println("Factorial of " + num + " is " + factorial);

	}

}
