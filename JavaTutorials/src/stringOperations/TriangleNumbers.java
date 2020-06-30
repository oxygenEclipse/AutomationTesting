package stringOperations;

public class TriangleNumbers {

	public static void main(String[] args) {
		int r = 5;
		for (int i = r; i >= 1; i--) {
			for (int j = 1; j < i * 2; j++)
				System.out.print(" ");
			for (int j = i; j <= r; j++)
				System.out.print(j + " ");
			for (int j = r - 1; j >= i; j--)
				System.out.print(j + " ");
			System.out.println();
		}

	}

}
