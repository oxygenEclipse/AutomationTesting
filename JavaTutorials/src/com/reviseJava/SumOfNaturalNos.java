package com.reviseJava;

public class SumOfNaturalNos {

	public static void main(String[] args) {
		// Natural Numbers = from 1 to 100
		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("Sum of Natural Numbers is " + sum);
		int k = 1;
		sum = 0;
		while (k <= 100) {
			sum = sum + k;
			k++;
		}
		System.out.println("Sum of Natural Numbers is " + sum);

	}

}
