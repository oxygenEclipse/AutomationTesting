package stringOperations;

import java.util.Scanner;

public class EmailCheck {
	public static void main(String[] args) {
		String email;
		int atFlag = 0, dotFlag = 0;
		Scanner userEmail = new Scanner(System.in);
		System.out.println("Enter the Email Address");
		email = userEmail.nextLine();
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@')
				atFlag = 1;
			if (email.charAt(i) == '.')
				dotFlag = 1;
		}
		if (atFlag == 1 && dotFlag == 1)
			System.out.println("Valid EmailAddress");
		else
			System.out.println("Invalid EmailAddress");
		userEmail.close();

	}
}
