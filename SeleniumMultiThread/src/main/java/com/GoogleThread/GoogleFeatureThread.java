package com.GoogleThread;

public class GoogleFeatureThread extends Thread {
	
	public String browserName;
	GoogleHomePageLoad googlePage;
	
	public GoogleFeatureThread(String threadName,String browserName) {
		super(threadName);
		this.browserName = browserName;
		googlePage = new GoogleHomePageLoad();
	}
	@Override
	public void run() {
		System.out.println("thread started "  + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		try {
			Thread.sleep(2000);
			googlePage.setUp(this.browserName);
			googlePage.googleSearch();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    
		finally {
			googlePage.tearDown();
		}
		System.out.println("thread ended "  + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
		
	}

}
