package listOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListIndex {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(90);
		System.out.println("List of Elements (list) : " + list);
		System.out.println("Get the first index value of 10 :" + list.indexOf(10));
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10);
		list1.add(10);
		list1.add(40);
		list1.add(50);
		System.out.println("List of Elements (list1) : " + list1);
		System.out.println("Get the first index value of 10 :" + list1.indexOf(10));
		System.out.println("Get the last index value of 10 : " + list1.lastIndexOf(10));
		System.out.println("Get the index value of 50 : " + list1.indexOf(50));
		list.addAll(list1);
		System.out.println("List of Elements (list) : " + list);
		System.out.println("Get the index value of 90 : " + list.indexOf(90));
		System.out.println("Frequency of value 10 : " + Collections.frequency(list, 10));
		System.out.println("Index values of 10 : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 10) {
				System.out.println(i);
			}
		}
		System.out.println("Element present at 2nd Index : " + list.get(2));
		System.out.println("Elements in List (list) using for loop : ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("Elements in List (list) using enhanced for loop : ");
		for (Integer li : list) {
			System.out.println(li);
		}
		System.out.println("Remove the values from List");
		list.remove(2);
		System.out.println("List after removal : " + list);
		list.add(2, 50);
		System.out.println("List after addition : " + list);
		list.add(list.size(), 70);
		System.out.println("List after addition : " + list);
		list.add(8, 80);
		System.out.println("List after addition : " + list);
		System.out.println("Replace values from List");
		list.set(0, 100);
		System.out.println("List after replace : " + list);
		list.set(7, 90);
		System.out.println("List after replace : " + list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 10) {
				list.set(i, 100);
			}
		}
		System.out.println("List after replace occurance : " + list);
		System.out.println("Common Values");
		System.out.print(list);
		System.out.println(list1);
		List<Integer> list3 = new ArrayList<Integer>(list1);
		list3.retainAll(list);
		System.out.println(list3);
		list3.removeAll(list3);
		System.out.println(list3);
	}
}
