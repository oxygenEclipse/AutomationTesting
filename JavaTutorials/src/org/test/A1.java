package org.test;

public class A1 extends B{
	public A1() {
        super(12);
		System.out.println("Default const...");
	}

	public static void main(String[] args) {
		A1 a = new A1();
	}

}
