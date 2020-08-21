package com.selenium.testscripts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdactinMainTest.class, AdactinTestCasesSet_1.class, AdactinTestCasesSet_2.class,
		AdactinTestCasesSet_3.class, AdactinTestCasesSet_4.class })
public class AllTests {

}
