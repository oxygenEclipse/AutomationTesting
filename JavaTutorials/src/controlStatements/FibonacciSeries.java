package controlStatements;

public class FibonacciSeries {
	public static void main(String[] args) {
		int temp1 = 0, temp2 = 1, temp3 = 1, prevNum = 0, sum = 0;
		System.out.println("Fibonacci Series: ");
		System.out.println(temp1);
		System.out.println(temp2);
		System.out.println(temp3);
		prevNum = temp3;
		for (int i = 1; i <= 10; i++) {
			sum = prevNum + temp3;
			temp3 = prevNum;
			prevNum = sum;
			System.out.println(sum);
		}
	}
}
