package stringOperations;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class CharacterTypeCount {

	public static void main(String[] args) {
		int lCaseCount = 0, uCaseCount = 0, numbersCount = 0,
				sCharCount = 0;
				String s = "Welcome To JAVA Class @ 12345";
				for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (Character.isLowerCase(ch)) {
				lCaseCount++;
				} else if (Character.isUpperCase(ch)) {
				uCaseCount++;
				} else if (Character.isDigit(ch)) {
				numbersCount++;
				} else {
				sCharCount++;
				}
				}
				System.out.println("Upper Case Count: " + uCaseCount);
				System.out.println("Lower Case Count: " + lCaseCount);
				System.out.println("Numbers Count: " + numbersCount);
				System.out.println("Special Characters Count: " + sCharCount);
				System.out.println("Capitalized String : " + s.toUpperCase());
				System.out.println("Lower Case String : " + s.toLowerCase());
				System.out.println("Capitalized String using String Utils : " + StringUtils.capitalize(s));
				System.out.println("Lower Case String using String Utils : " + StringUtils.uncapitalize(s));
				System.out.println("Swap Case using String Utils : " + StringUtils.swapCase(s));
	}

}
