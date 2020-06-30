package controlStatements;

public class SumOfOddNumbers {
	public static void main(String[] args) {
		int sumOdd = 0,totalSum=0;
		for(int i=1;i<=100;i++) {
			if(i%2!=0) {
				totalSum=sumOdd+i;
				sumOdd = totalSum;
						
			}
		}
		System.out.println("Total Sum of Odd Numbers(1-100): " + totalSum);
	}

}
