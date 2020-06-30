package com.reviseJava;

public class PowerOfNumber {

	public static void main(String[] args) {
   // 3 *4 = 3* 3*3*3 = 81
		int baseNum = 2;
		int exponent = 40, exponent1 = 40;
		long result = 1;
		while(exponent !=0) {
			result = result * baseNum; // result *= base;
		    --exponent;
		}
		System.out.println(result);
		System.out.println(Math.pow(baseNum, exponent1));
	}
 
}
