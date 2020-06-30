package com.reviseJava;

import java.util.Scanner;

public class PrintAInteger {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please Enter an Integer :");
		int num = reader.nextInt();
		System.out.println("The Integer entered is " + num);
		reader.close();
	}

}
