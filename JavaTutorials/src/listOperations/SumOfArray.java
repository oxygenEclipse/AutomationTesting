package listOperations;

import java.util.Scanner;

public class SumOfArray {

	public static void main(String[] args) {
		
		int sum = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the count of Numbers: ");
		int count = input.nextInt();
		int numbers[] = new int[count];
		System.out.println("Entert the Numbers to be Added :");
		for (int i = 0; i < count; i++) {
			numbers[i] = input.nextInt();
			sum = sum + numbers[i];
		}
		float avg = sum/count;
		System.out.println("Sum of the Numbers : " + sum);
		System.out.println("Average of the Numbers : " + avg);
		input.close();
	}

}
