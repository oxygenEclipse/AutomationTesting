package com.reviseJava;

public class PrimeNumber {

	public static void main(String[] args) {
		// prime number - number divisible by 1 and itself is called prime number
		int num = 97;
		boolean flag = false;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = true;
				break;
			}
		}
		if (!flag)
			System.out.println(num + " is a prime number");
		else
			System.out.println(num + " is not a prime number");

	}

}
