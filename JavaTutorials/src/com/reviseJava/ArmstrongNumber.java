package com.reviseJava;

public class ArmstrongNumber {

	public static void main(String[] args) {
      // 153 - 1*1*1 + 5*5*5 + 3*3*3 = 1 +125+ 27 = 153
		int num = 373;
		int actualNum = num;
		int result = 0;
        while (num!=0) {
        	int n = num % 10;
        	result = result + (n * n * n);
        	num = num / 10;
        }
        if(result==actualNum)
        	System.out.println(actualNum + " is a Armstrong Number");
        else
        	System.out.println(actualNum + " is not a Armstrong number");
		
	}

}
