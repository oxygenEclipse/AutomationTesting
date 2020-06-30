package controlStatements;

public class Patterns2 {
	public static void main(String[] args) {
		int i=1,j=1;
		for(i=1;i<=5;i++) {
			for(j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
