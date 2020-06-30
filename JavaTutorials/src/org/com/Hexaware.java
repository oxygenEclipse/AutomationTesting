package org.com;

public class Hexaware extends Techm{
	public void companyName() {
System.out.println("Company Name");
	}
	public void companyAddress() {
System.out.println("Company Address");
	}
	public static void main(String[] args) {
		Hexaware h = new Hexaware();
		h.companyName();
		h.companyAddress();
		h.companyDetail();
		System.getProperty("user.dir");
	}

}
