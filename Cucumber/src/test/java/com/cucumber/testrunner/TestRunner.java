package com.cucumber.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src\\test\\resource\\com\\cucumber\\features\\AutomationPractice.feature", 
			glue = {"helpers","com.cucumber.stepdefinition"}, 
			dryRun = false, 
			strict = true, 
			monochrome = true
			//tags = {"@ProductRange","~@LoginRegister"},
		//	plugin= {"pretty","usage","junit:target/Ap.xml","json:target/Ap.json","html:target/Ap.html"}
			)
public class TestRunner {

}
