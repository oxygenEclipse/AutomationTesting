package com.reviseJava;

public class FactorialRecursion {
	
	public static int factorial(int num) {
		if(num>=1)
			return num * factorial(num-1);
		else
			return 1;
	}

	public static void main(String[] args) {
		
		int num = 0;
		int factorial = factorial(num);
		System.out.println("Factorial : " + factorial);

	}

}
