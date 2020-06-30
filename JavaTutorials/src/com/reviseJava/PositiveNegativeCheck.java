package com.reviseJava;

public class PositiveNegativeCheck {

	public static void main(String[] args) {
		double number = 0; // double can handle both integer and decimal
		if(number>0.0)
			System.out.println(number +" is Positive");
		else if(number<0.0)
			System.out.println(number + " is Negative");
		else if(number ==0.0)
			System.out.println(number + " is zero");
	}

}
