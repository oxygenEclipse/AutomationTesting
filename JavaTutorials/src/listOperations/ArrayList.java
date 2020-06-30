package listOperations;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ArrayList {
	public static void main(String[] args) {
		List<Integer> list = new java.util.ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the numbers in Array List");
		list.add(input.nextInt());
		list.add(input.nextInt());
		list.add(input.nextInt());
		list.add(input.nextInt());
		list.add(input.nextInt());
		list.add(input.nextInt());
		System.out.println("Length of ArrayList : " + list.size());
		System.out.println("Elements in ArrayList : " + list);
		List<String> linkedList = new LinkedList<String>();
		System.out.println("Enter the Strings in Linked List");
		linkedList.add(input.next());
		linkedList.add(input.next());
		linkedList.add(input.next());
		linkedList.add(input.next());
		linkedList.add(input.next());
		System.out.println("Length of LinkedList : " + linkedList.size());
		System.out.println("Elements in LinkedList : " + linkedList);
		List<String> vectorList = new Vector<String>();
		System.out.println("Enter the Numbers in Vector List");
		vectorList.add(input.next());
		vectorList.add(input.next());
		vectorList.add(input.next());
		vectorList.add(input.next());
		System.out.println("Length of VectorList : " + vectorList.size());
		System.out.println("Elements in VectorList : " + vectorList);
		input.close();
	}

}
