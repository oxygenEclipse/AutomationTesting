package com.opencart.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\com\\opencart\\features", 
                 glue = "com.opencart.stepdefinition", dryRun = true,monochrome=true,strict=true)

public class TestRunner {

}
