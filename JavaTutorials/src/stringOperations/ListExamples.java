package stringOperations;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListExamples {
	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		s.add(30);
		s.add(90);
		s.add(70);
		s.add(60);
		s.add(20);
		System.out.println(s);
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(30, "Hello");
		m.put(20, "Hi");
		System.out.println(m);
		Set<Integer>x=m.keySet();
		for(Integer x1:x) {
			System.out.println(x1);
		}
		Collection<String>s2=m.values();
		for(String s1:s2) {
			System.out.println(s1);
		}
	}

}
