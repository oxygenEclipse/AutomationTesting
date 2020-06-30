package students;

public class sample {

	public static void main(String[] args) {

		int[] data = {2,4,1,8,15,100,63,51,23,9};
		for(int index=0;index<5;index = index+2)
			System.out.print(data[index] + " ");
		
		String JavaStr = "Welcome to java world.";
	//	System.out.println(JavaStr.substring(JavaStr.indexOf("j"),1).toUpperCase());
	//	char charAt = JavaStr.charAt(JavaStr.indexOf("j"));
		
		System.out.println(JavaStr.indexOf("j"));
		System.out.println(JavaStr.substring(11,12).toUpperCase());
		
		final String str1 = "hello";
		final String str2 = "world";
		String str3 = "helloWorld";
		String s = "Hello"+1+2+"World"+""+(3+4);
		System.out.println(s);
		String s1 = "Hello World ";
		//		System.out.println(s1.charAt(s1.toUpperCase().length()));
		
	}

}
