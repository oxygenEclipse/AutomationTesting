package com.reviseJava;

import java.util.Scanner;

public class CalculatorSwitch {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter 2 numbers : ");
		double firstNum = reader.nextDouble();
		double secNum = reader.nextDouble();
		System.out.println("Enter the Operation (+,-,*,/) : ");
		char operator = reader.next().charAt(0);
		double result = 0;
		switch (operator) {
		case '+':
			result = firstNum + secNum;
			break;
		case '-':
			result = firstNum - secNum;
			break;
		case '*':
			result = firstNum * secNum;
			break;
		case '/':
			result = firstNum / secNum;
			break;

		default:
			System.out.println("Please enter the correct operator");
			break;
		}
		System.out.println("Result : " + result);
		reader.close();

	}

}
