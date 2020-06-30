package stringOperations;

public class StringOperations {
	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcd";
	    String str = "";
		String s1 = new String("abcd");
		String s2 = new String("uvwx");
		char[] ch = s2.toCharArray();
		System.out.println(ch[0]);
		String s3="A";
		int i = s.compareTo(s1);
		System.out.println(i);
		System.out.println(System.identityHashCode(s));
		System.out.println(System.identityHashCode(t));
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(s==s1);
		System.out.println(s.equals(s1));
		System.out.println(str.isEmpty());
	}

}
