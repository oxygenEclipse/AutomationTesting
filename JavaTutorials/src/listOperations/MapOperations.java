package listOperations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapOperations {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Lead");
		map.put(101, "Phosporus");
		map.put(102, "Aluminium");
		// Elements can traverse in any order
		for (Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		
		System.out.println("Key-Value Pairs : " + map.entrySet());
		System.out.println("Key Set : " + map.keySet());
		System.out.println("Value Set : " + map.values());
		System.out.println("Comparing By Key Ascending Order");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey())
		.forEach(System.out::println);
		System.out.println("Comparing By Key Descending Order");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
		.forEach(System.out::println);
		System.out.println("Comparing By Value Ascending Order");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
		.forEach(System.out::println);
		System.out.println("Comparing By Value Descending Order");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEach(System.out::println);
	}

}
