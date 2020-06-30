package com.adactin.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\com\\adactincucumber\\features",glue = "com.adactin.stepdefinition", 
dryRun = true, strict = true,monochrome = true)
public class TestRunner {

}
