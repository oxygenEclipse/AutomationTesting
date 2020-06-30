package stringOperations;

import java.lang.String;

public class FindCharacter {
	public static void main(String[] args) {
		String s1 = "GreensTechnology";
		String s2 = "SeleniumAutomationtool";
		String s3 = "banumathi";
		String s4 = "j a v a p r o g r a m";
		String s5 = "9962059660";
		int i;
		char c;
		// int j[]= {1,2,3,4,5};

		// To find character 'h' in string s1

		for (i = 0; i < s1.length(); i++) {
			c = s1.charAt(i);
			if (c == 'h') {
				System.out.println(s1.charAt(i));
				break;
			}
		}
		// To find character 'o' in string s2
		for (i = 0; i < s2.length(); i++) {
			c = s2.charAt(i);
			if (c == 'o') {
				System.out.println(s2.charAt(i));
				break;
			}
		}
		// To find character 'u' in string s3
		for (i = 0; i < s3.length(); i++) {
			c = s3.charAt(i);
			if (c == 'u') {
				System.out.println(s3.charAt(i));
				break;
			}
		}
		// To find character 'p' in string s4
		for (i = 0; i < s4.length(); i++) {
			c = s4.charAt(i);
			if (c == 'p') {
				System.out.println(s4.charAt(i));
				break;
			}
		}
		// To find character 'p' in string s5
		for (i = 0; i < s5.length(); i++) {
			c = s5.charAt(i);
			if (c == '0') {
				System.out.println(s5.charAt(i));
				break;
			}
		}
	}
}
