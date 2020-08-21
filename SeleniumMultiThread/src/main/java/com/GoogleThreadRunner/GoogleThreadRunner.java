package com.GoogleThreadRunner;

import com.GoogleThread.GoogleFeatureThread;

public class GoogleThreadRunner {

	public static void main(String[] args) {

	/*	Thread t1 = new GoogleFeatureThread("chrome thread", "chrome");
		Thread t2 = new GoogleFeatureThread("firefox thread", "firefox");
		System.out.println("threads started..");
		t1.start();
		t2.start();*/
		int chromeCount = Integer.parseInt(System.getProperty("chrome"));
		int firefoxCount = Integer.parseInt(System.getProperty("firefox"));
		for (int i = 0, j = 0; i < chromeCount || j < firefoxCount; i++, j++) {
			new GoogleFeatureThread("chrome thread", "chrome").start();
			new GoogleFeatureThread("firefox thread", "firefox").start();
		}
	}

}
