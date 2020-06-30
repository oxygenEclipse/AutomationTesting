package com.reviseJava;

public class ReverseNumber {

	public static void main(String[] args) {
		int num = 548, n = 0;
		String reverseNum = "";

		while (num != 0) {
			n = num % 10;
			reverseNum = reverseNum + n;
			num = num / 10;
		}
		System.out.println("Reverse Number : " + reverseNum);
		// without using string

		int revNum = 0, number = 548;
		while (number != 0) {
           int n1 = number % 10;
           revNum = revNum * 10 + n1;
           number = number /10;
		}
		System.out.println("Reverse : " + revNum);
	}

}
