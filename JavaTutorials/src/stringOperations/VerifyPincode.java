package stringOperations;

import java.util.Scanner;

public class VerifyPincode {
	public static void main(String[] args) {
		String address1;
		//int pincodeLen = 6;
		String[] addr;
		Scanner strAddr = new Scanner(System.in);
		System.out.println("Enter the Address");
		address1 = strAddr.nextLine();
		addr = address1.split(",");
		int size = addr.length;
		String pincode = addr[size-1];
		//System.out.println(addr[size - 1].length());
		for (int i = pincode.length(); i > 0; i--) {
			char ch = pincode.charAt(i);
			if(Character.isDigit(ch)) {
				
				
			}

		}
		strAddr.close();

	}
}
