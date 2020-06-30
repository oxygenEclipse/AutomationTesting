package com.automationtesting.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\com\\automationtesting\\features\\automationtesting.feature", 
                 glue = "com.automationtesting.stepdefinition", 
                 tags = {"@HomePageSliders"}, 
                 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target\\cucumber-reports\\report.html" },
                 dryRun = false, monochrome = true, strict = true)

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("configs/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	}

}
