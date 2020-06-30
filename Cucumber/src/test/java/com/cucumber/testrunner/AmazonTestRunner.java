package com.cucumber.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resource\\com\\cucumber\\features\\AmazonTestCases.feature",
		glue="com.cucumber.stepdefinition",
		dryRun=false,
		monochrome=true,
		strict=true
		)
public class AmazonTestRunner {

}
