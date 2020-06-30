package listOperations;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			System.out.printf("1");
			int value = 10 / 0;
		}  catch (ArithmeticException e) {
			System.out.printf("3");
		} catch (NullPointerException e) {
			System.out.printf("4");
		}  catch (Exception e) {
			System.out.printf("6");
		}
	}
}
