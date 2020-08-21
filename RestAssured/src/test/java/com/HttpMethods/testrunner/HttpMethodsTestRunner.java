package com.HttpMethods.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\resources\\com\\requestres\\features",
                 glue = "com.HttpMethods.stepdefinition",
                 tags = {"@CreateIssueAndRetrieve"},
                 dryRun = false,
                 monochrome = true,
                 strict = true	 
		)
public class HttpMethodsTestRunner {

}
