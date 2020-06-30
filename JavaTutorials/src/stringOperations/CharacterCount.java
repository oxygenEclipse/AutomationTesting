package stringOperations;

import java.util.HashMap;

public class CharacterCount {
	public static void main(String args[]) {
		String str = "HelloWorld!";
		HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
		char[] s = str.toCharArray();
		for (char c : s) {
			if(charCount.containsKey(c)) {
				int x = charCount.get(c);
				charCount.put(c, x+1);
			}
			else
				charCount.put(c, 1);
		}
		System.out.println(charCount);
	}

}
