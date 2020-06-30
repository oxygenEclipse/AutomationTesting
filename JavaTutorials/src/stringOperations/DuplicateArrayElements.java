package stringOperations;

public class DuplicateArrayElements {

	public static int[] removeDuplicateElements(int input[]) {
		if (input.length < 2)
			return input;
		int j = 0, i = 1;
		while (i < input.length) {
			if (input[i] == input[j]) {
				i++;
			} else {
				input[++j] = input[i++];
			}
		}
		int[] output = new int[j + 1];
		for (int k = 0; k < output.length; k++) 
			output[k] = input[k];
		return output;
	}

	public static void main(String[] args) {
		int input[] = { 10, 20, 50, 30, 10, 20 };
		int output[] = removeDuplicateElements(input);
		for (int j = 0; j < output.length; j++)
			System.out.println(output[j]);

	}

}
