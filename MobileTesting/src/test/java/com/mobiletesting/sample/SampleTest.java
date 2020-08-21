package com.mobiletesting.sample;

import com.mobiletesting.baseclass.BaseClass;

public class SampleTest extends BaseClass {

	public static void main(String[] args) throws Exception {
		driver = browserLaunch("browserstack_mobile_web");
		driver.get("http://automationpractice.com/index.php");
		driver.quit();
		
	}

}
