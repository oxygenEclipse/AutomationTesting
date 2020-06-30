package com.reviseJava;

public class PalindromeNumber {

	public static void main(String[] args) {
    int givenNum = 100;
    int revNum = 0;
   int num = givenNum;
     while(num != 0) {
    	 int temp = num % 10;
    	 revNum = revNum * 10 + temp;
    	 num = num / 10;
     }
     if (revNum == givenNum)
    	 System.out.println(givenNum + " is a Palindrome Number");
     else
    	 System.out.println(givenNum + " is not a Palindrome Number");
		
	}

}
