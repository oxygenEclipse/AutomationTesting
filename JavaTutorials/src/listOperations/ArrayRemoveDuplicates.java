package listOperations;

public class ArrayRemoveDuplicates {

	public static void main(String[] args) {
		int j = 0;
		int i = 1;
		int[] input = { 2, 3, 6, 6, 8, 9, 10, 10, 10, 12, 12 };
		while (i < input.length) {
			if (input[i] == input[j]) {
				i++;
			} else {
				input[++j] = input[i++];
			}
		}
		int[] output = new int[j + 1];
		System.out.println("Array After removing duplicate Elements");
		for (int k = 0; k < output.length; k++) {
			output[k] = input[k];
			System.out.println(output[k]);
		}
		
	}

}
