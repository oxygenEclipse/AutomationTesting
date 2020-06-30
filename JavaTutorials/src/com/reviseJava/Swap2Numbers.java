package com.reviseJava;

public class Swap2Numbers {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int temp;
		// using temp
		System.out.println("Before swapping");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("After swapping");
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		// without temp
		System.out.println("Before swapping");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("After swapping");
		System.out.println("a = " + a);
		System.out.println("b = " + b);

	}

}
