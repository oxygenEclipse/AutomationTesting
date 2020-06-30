package com.reviseJava;

public class NaturalNumbersSumRecursion {

	public static int addNumbers(int num) {
		if (num != 0)
			return num + addNumbers(num - 1);
		else
			return num;
	}

	public static void main(String[] args) {
		int num = 10;
		int sum = addNumbers(num);
		System.out.println("Sum is : " + sum);

	}

}
