package listOperations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class SetOperations {

	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(10);
		hashSet.add(20);
		hashSet.add(30);
		hashSet.add(40);
		hashSet.add(50);
		hashSet.add(60);
		hashSet.add(70);
		hashSet.add(80);
		hashSet.add(90);
		hashSet.add(10);
		hashSet.add(20);
		System.out.println(hashSet);
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		linkedHashSet.add(10);
		linkedHashSet.add(20);
		linkedHashSet.add(30);
		linkedHashSet.add(40);
		linkedHashSet.add(50);
		linkedHashSet.add(60);
		linkedHashSet.add(70);
		linkedHashSet.add(80);
		linkedHashSet.add(90);
		linkedHashSet.add(10);
		linkedHashSet.add(20);
		System.out.println(linkedHashSet);
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(10);
		treeSet.add(90);
		treeSet.add(30);
		treeSet.add(20);
		treeSet.add(70);
		treeSet.add(60);
		treeSet.add(10);
		treeSet.add(20);
		treeSet.add(80);
		treeSet.add(50);
		treeSet.add(40);
		System.out.println(treeSet);
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(90);
		list.add(10);
		list.add(10);
		list.add(40);
		list.add(50);
		System.out.println("List : " + list);
		HashSet<Integer> hashSetList = new HashSet<Integer>();
		hashSetList.addAll(list);
		System.out.println("HashSet : " + hashSetList);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(105);
		list1.add(505);
		list1.add(205);
		list1.add(305);
		list1.add(805);
		list1.add(605);
		list1.add(405);
		list1.add(605);
		list1.add(705);
		list1.add(505);
		System.out.println("List : " + list1);
		LinkedHashSet<Integer> linkedHashSet1 = new LinkedHashSet<Integer>();
		linkedHashSet1.addAll(list1);
		System.out.println("Linked Hash Set : " + linkedHashSet1);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(100);
		list2.add(300);
		list2.add(900);
		list2.add(500);
		list2.add(800);
		list2.add(300);
		list2.add(200);
		list2.add(100);
		list2.add(400);
		list2.add(200);
		System.out.println("List : " + list2);
		TreeSet<Integer> treeSet1 = new TreeSet<Integer>();
		treeSet1.addAll(list2);
		System.out.println("Tree Set : " + treeSet1);
		System.out.println("Enhanced For Loop For Tree Set");
		for (Integer treeSetFor : treeSet1) {
			System.out.println(treeSetFor);
		}
		System.out.println("Using Iterator");
		Iterator<Integer> i = treeSet1.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());

		}
		System.out.println("Enhanced For Loop For Linked Hash Set");
		for (Integer linkedHashSetFor : linkedHashSet1) {
			System.out.println(linkedHashSetFor);
		}
		System.out.println("Enhanced For Loop For Hash Set");
		for (Integer hashSetListFor : hashSetList) {
			System.out.println(hashSetListFor);
		}
		HashSet<Integer> hashSet2 = new HashSet<Integer>();
		HashSet<Integer> hashSet3 = new HashSet<Integer>();
		hashSet2.add(10);
		hashSet2.add(20);
		hashSet2.add(30);
		hashSet2.add(90);
		hashSet2.add(10);
		hashSet2.add(10);
		hashSet2.add(40);
		hashSet2.add(50);
		hashSet3.add(30);
		hashSet3.add(40);
		hashSet3.add(50);
		hashSet3.add(60);
		hashSet3.add(80);
		System.out.println("Common Elements of Hast Set 2 and Hash Set 3");
		for (Integer integer1 : hashSet2) {
			for (Integer integer2 : hashSet3) {
				if (integer1 == integer2) {
					System.out.println(integer1);
				}
			}
		}
		LinkedHashSet<Integer> linkedHashSet2 = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> linkedHashSet3 = new LinkedHashSet<Integer>();
		linkedHashSet3.add(10);
		linkedHashSet3.add(20);
		linkedHashSet3.add(30);
		linkedHashSet3.add(90);
		linkedHashSet3.add(10);
		linkedHashSet3.add(10);
		linkedHashSet3.add(40);
		linkedHashSet3.add(50);
		linkedHashSet2.add(10);
		linkedHashSet2.add(20);
		linkedHashSet2.add(60);
		linkedHashSet2.add(50);
		linkedHashSet2.add(40);
		linkedHashSet2.add(70);
		linkedHashSet2.add(80);
		linkedHashSet2.add(90);
		System.out.println("Common Values of Linked Hash Set 3 and Set 2");
		for (Integer integer3 : linkedHashSet3) {
			for (Integer integer4 : linkedHashSet2) {
				if (integer3 == integer4) {
					System.out.println(integer3);
				}
			}
		}
		System.out.println("Linked Hash Set 2 before Removal " + linkedHashSet2);
		linkedHashSet2.removeAll(linkedHashSet3);
		System.out.println("Linked Hash Set 2 after Removal " + linkedHashSet2);
	}

}
