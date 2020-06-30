package controlStatements;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int x,flag=1;
		x=s.nextInt();
		for(int i=2;i<=x/2;i++) {
			if(x%i==0) {
				flag=0;
				break;
			}
		}
			if(flag==1) {
				System.out.println(x+" is a Prime Number");
			}
			else {
				System.out.println(x+" is Not a Prime Number");
			}
s.close();			
	}
}
