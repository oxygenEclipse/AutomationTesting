package com.reviseJava;

public class SumOfTwoPrimeNumbers {

	public static boolean checkPrimeNumber(int num) {
		boolean isPrime = true;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static void main(String[] args) {
		// 34 - 3+31, 5+29, 11+23, 17+17
		// System.out.println(checkPrimeNumber(22));
		int num = 11;
		boolean flag = false;
		for (int i = 2; i <= num / 2; i++) {
			if (checkPrimeNumber(i)) {
				if (checkPrimeNumber(num - i)) {
					System.out.println(num + " = " + i + " + " + (num - i));
					flag = true;
				}
			}
		}

		if (!flag)
			System.out.println(num + " cannot be expressed as Sum of Two Prime Numbers");
	}

}
