package listOperations;

public class ReturnValueInException {
	public static void main(String[] args) {
		// invoking static method
		System.out.println(returnValueFromMethod());
	}

	public static int returnValueFromMethod() {
		int result = 0;
		try {
			result = 18 / 0;
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("Finally block is executed");
		}
		return result;
		
	}
}
