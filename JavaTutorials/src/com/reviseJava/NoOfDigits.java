package com.reviseJava;

public class NoOfDigits {

	public static void main(String[] args) {
		int num = 01;
		int count = 0;
		while (num != 0) {
			num = num / 10;
			++count;
		}
    System.out.println("No Of Digits : " + count);
	}

}
