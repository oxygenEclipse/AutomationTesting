package com.reviseJava;

public class FibonacciSeries {

	public static void main(String[] args) {
		//0 1 1 2 3 5 8
		
		int num = 20;
		int temp = 0;
		int prevNum = 1;
		int sum = 0;
		System.out.println(temp);
		System.out.println(prevNum);
		for(int i = 1;i<=num;i++) {
			sum = temp + prevNum;
			System.out.println(sum);
			temp = prevNum;
			prevNum = sum;	
		}
		

	}

}
