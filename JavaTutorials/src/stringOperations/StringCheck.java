package stringOperations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StringCheck {
	public static void main(String[] args) {
		/*
		 * String str1, str2; Scanner s = new Scanner(System.in);
		 * System.out.println("String 1 : "); str1 = s.nextLine();
		 * System.out.println("String 2 : "); str2 = s.nextLine(); Boolean strEqual =
		 * str1.equals(str2); System.out.println("String Equal Case"); if (strEqual ==
		 * true) System.out.println("String 1 is Equal to String 2 "); else
		 * System.out.println("String 1 is Not Equal to String 2 ");
		 * System.out.println("String Equal Ignore Case"); Boolean
		 * strEqual1=str1.equalsIgnoreCase(str2); if(strEqual1==true)
		 * System.out.println("String 1 is Equal to String 2 "); else
		 * System.out.println("String 1 is Not Equal to String 2 "); String str1 =
		 * "today + 5" ; String checkInDateStr = "";
		 * System.out.println(str1.substring(0, 8).equalsIgnoreCase("today + ")); if
		 * (str1.substring(0, 8).equalsIgnoreCase("today + ")) { int plusDays1 =
		 * Integer.parseInt(str1.substring(8, 9)); System.out.println("Plus : " +
		 * plusDays1); LocalDate checkInDate = LocalDate.now().plusDays(plusDays1);
		 * DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 * checkInDateStr = checkInDate.format(format1);
		 * System.out.println(checkInDateStr); }
		 */
		String cartAmt = "$2,40,000.00";
		String price1 = "$1,230.00";
		String price2 = "$10.00";
		String finalPrice = "$1,240.00";
		List<String> priceList = new ArrayList<String>();
		priceList.add(price1);
		priceList.add(price2);
		float price, totalPrice = 0;
		for (String string : priceList) {
			price = Float.parseFloat(string.replace("$", "").replace(",", ""));
			System.out.println(price);
			totalPrice = totalPrice + price;
			System.out.println(totalPrice);
		}
		System.out.println("Total Price : " + totalPrice);
		float totalFinalPrice = Float.parseFloat(finalPrice.replace("$", "").replace(",", ""));
		System.out.println("Final Total Price : " + totalFinalPrice);
		if(Float.parseFloat(cartAmt.substring(1).replace(",", ""))>=200000.00)
			System.out.println("More than");
		else
			System.out.println("Less than");
		/*
		 * int compareTo = totalPrice.compareTo(totalFinalPrice);
		 * System.out.println(compareTo); if (compareTo == 0) {
		 * System.out.println("Same"); } else { System.out.println("Different"); }
		 */

		// s.close();
	}
}
