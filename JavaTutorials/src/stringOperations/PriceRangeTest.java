package stringOperations;

public class PriceRangeTest {

	public static void main(String[] args) {
		String priceRange = "$26.00 - $28.00";
		String productPr = "$25.00";
		String[] priceRangeList = priceRange.split("-");
		float lowerPrice = Float.parseFloat(priceRangeList[0].trim().replace("$", ""));
		float higherPrice = Float.parseFloat(priceRangeList[1].trim().replace("$", ""));
		float productPrice = Float.parseFloat(productPr.trim().replace("$", ""));
		System.out.println("Lower Price : " + lowerPrice);
		System.out.println("Higher Price : " + higherPrice);
		System.out.println("Product Price : " + productPrice);
		int compareLowerPrice = Float.compare(productPrice, lowerPrice);
		int compareHigherPrice = Float.compare(productPrice, higherPrice);
		if ((compareLowerPrice > 0 || compareLowerPrice == 0) && (compareHigherPrice < 0 || compareHigherPrice == 0)) {
			System.out.println("In Range");
		} else
			System.out.println("Not In Range");
	}

}
