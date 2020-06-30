package controlStatements;

public class CountOfEvenNumbers {
	public static void main(String[] args) {
		int countEven = 0;
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				countEven = countEven + 1;
			}
		}
		System.out.println("Count Of Even Numbers (1-100) :" + countEven);
	}
}
