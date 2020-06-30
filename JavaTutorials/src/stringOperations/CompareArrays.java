package stringOperations;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays;

public class CompareArrays {
	public static void main(String[] args) {
		/*
		 * int intArray1[] = { 1, 2, 3, 4, 5 }; int intArray2[] = { 1, 2, 6, 4, 5 };
		 * int[] intArray3 = { 6, 2, 8, 1, 9 }; // Boolean equalsCheck =
		 * intArray1.equals(intArray2); Arrays.sort(intArray3); Boolean equalsCheck =
		 * Arrays.equals(intArray1, intArray2); for (int i = 0; i < intArray3.length;
		 * i++) System.out.println(intArray3[i]); System.out.println(equalsCheck);
		 */
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(90);
		l.add(10);
		l.add(10);
		l.add(40);
		l.add(50);
		System.out.println(l);
		System.out.println("Adding 50 in the 2nd Index");
		l.set(2, 50);
		System.out.println(l);
		System.out.println(l.get(0));
		l.add(2, 100);
		System.out.println(l);
		Boolean b = l.contains(100);
		System.out.println(b);
		System.out.println(l.indexOf(50));
		l.add(70);
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		Collections.reverse(l);
		System.out.println(l);
		System.out.println(Collections.frequency(l, 10));
		
		
	}

}
