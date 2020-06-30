package listOperations;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListSort {

	public static void main(String[] args) {
		LinkedList<String> prod = new LinkedList<String>();
		prod.add("SONY XPERIA");
		prod.add("IPHONE");
		prod.add("SAMSUNG GALAXY");
		System.out.println("Actual Linked List : " + prod);
		boolean sortStatus = checkAlphabaticalOrder(prod);
		System.out.println("User Defined Sort Status : " + sortStatus + " " + prod);
		prod.sort(Comparator.reverseOrder());
		System.out.println("Sorting using the List.sort functionality : " + prod);
		Collections.sort(prod);
        System.out.println("Sorting using the Collections.sort functionality : " + prod);
        Collections.sort(prod, new Comparator<String>() {
        	@Override
        	public int compare(String s1, String s2) {
        		return s1.length() - s2.length();
        	}
		});
        System.out.println("Sorting based on the product length using Comparator override method : " + prod);
	}

	public static boolean checkAlphabaticalOrder(List<String> products) {

		String previousProdName = "";
		for (String currentProdName : products) {
			if (currentProdName.compareTo(previousProdName) < 0) {
				return true;
			}
			previousProdName = currentProdName;
		}
		return false;
	}

}
