package listOperations;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapOperations2 {

	public static void main(String[] args) {
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(10, "java");
		hmap.put(20, "sql");
		hmap.put(30, "oops");
		hmap.put(40, "Sql");
		hmap.put(50, "oracle");
		hmap.put(60, "DB");
		hmap.put(10, "selenium");
		hmap.put(50, "psql");
		hmap.put(40, "Hadoop");
		System.out.println("Hash Map : " + hmap);
		System.out.println("Hash Map Key Set : " + hmap.keySet());
		System.out.println("Hash Map Value Set : " + hmap.values());
		System.out.println("Hash Map using Enhanced For loop");
		for (Map.Entry<Integer, String> m : hmap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		Map<Integer, Integer> lhmap = new LinkedHashMap<Integer, Integer>();
		lhmap.put(10, 10);
		lhmap.put(20, 20);
		lhmap.put(30, 30);
		lhmap.put(40, 40);
		lhmap.put(50, 50);
		lhmap.put(60, 60);
		lhmap.put(10, 10);
		lhmap.put(50, 50);
		lhmap.put(40, 40);
		lhmap.put(10, 10);
		System.out.println("Linked Hash Map : " + lhmap);
		System.out.println("Linked Hash Map Key Set : " + lhmap.keySet());
		System.out.println("Linked Hash Map Value Set : " + lhmap.values());
		System.out.println("Linked Hash Map using Enhanced For Loop");
		for (Map.Entry<Integer, Integer> lm : lhmap.entrySet()) {
			System.out.println(lm.getKey() + " " + lm.getValue());
		}
		Map<String, Integer> tmap = new TreeMap<String, Integer>();
		tmap.put("!", 10);
		tmap.put("@", 20);
		tmap.put("#", 30);
		tmap.put("$", 40);
		tmap.put("%", 50);
		tmap.put("^", 60);
		tmap.put("&", 10);
		tmap.put("*", 50);
		tmap.put("(", 40);
		System.out.println("Tree Map : " + tmap);
		System.out.println("Tree Map Key Set : " + tmap.keySet());
		System.out.println("Tree Map Value Set : " + tmap.values());
		System.out.println("Tree Map using Enhanced For Loop");
		for (Map.Entry<String, Integer> tm : tmap.entrySet()) {
			System.out.println(tm.getKey() + " " + tm.getValue());
		}
		Map<String, String> htable = new Hashtable<String, String>();
		htable.put("vel", "Selenium");
		htable.put("Ganesh", "framework");
		htable.put("Dinesh", "oracle");
		htable.put("Vengat", "corejava");
		htable.put("subash", "jira");
		System.out.println("Hash Table : " + htable);
		System.out.println("Hash Table Key Set : " + htable.keySet());
		System.out.println("Hash Table Value Set : " + htable.values());
		System.out.println("Hash Table using Enhanced For Loop");
		for (Map.Entry<String, String> ht : htable.entrySet()) {
			System.out.println(ht.getKey() + " " + ht.getValue());
		}
	}

}
