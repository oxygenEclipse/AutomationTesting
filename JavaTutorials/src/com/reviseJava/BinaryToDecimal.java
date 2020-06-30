package com.reviseJava;

public class BinaryToDecimal {

	public static int convertBinaryToDecimal(long num) {
		int decimalNumber = 0;
		int i = 0;
		while (num != 0) {
			long remainder = num % 10;
			num = num / 10;
			//decimalNumber = (long) (decimalNumber + (remainder * Math.pow(2, i)));
			decimalNumber += remainder * Math.pow(2, i);
			++i;
		}
		return decimalNumber;
	}
	public static long convertDecimalToBinary(int num) { 
		long binaryNum = 0;
		int i = 1;
		while(num!=0) {
			int remainder = num % 2;
			num = num / 2;
			binaryNum += remainder * i;
			i *= 10;
		}
		return binaryNum;
	}

	public static void main(String[] args) {
		long binaryNum = 10011101;
		int decimal = convertBinaryToDecimal(binaryNum);
		System.out.println(decimal);
		long binary = convertDecimalToBinary(decimal);
		System.out.println(binary);

	}

}
