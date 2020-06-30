package com.cucumber.stepdefinition;

import com.cucumber.enums.Context;
import com.cucumber.funtionallibrary.BaseClass;
import com.cucumber.manager.PageObjectManager;
import com.cucumber.manager.TestContext;
import com.cucumber.pom.ApRegistrationFormPage;

import cucumber.api.java.en.When;

public class ApRegistrationFormPageStepDefinition extends BaseClass {
	TestContext testContext;
	PageObjectManager pageObjectManager;
	ApRegistrationFormPage registerDetails;

	public ApRegistrationFormPageStepDefinition(TestContext tc) {
		this.testContext = tc;
		registerDetails = testContext.getPageObjectManager().getRegisterDetails();
	}
	@When("^User enters the user details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_user_details_as_and(String title, String firstName, String lastName, String eMail,
			String password, String dob) throws Throwable {
		clickIsSelected(registerDetails.getTitleRadioBtn());
		sendValues(registerDetails.getFirstName(), firstName);
		testContext.scenarioContext.setContext(Context.FIRST_NAME, firstName);
		sendValues(registerDetails.getLastName(), lastName);
		testContext.scenarioContext.setContext(Context.LAST_NAME, lastName);
		sendValues(registerDetails.getPassword(), password);
		// Selecting the Values for the Date of Birth
		String[] dateParts = dob.split("/");
		if (dateParts[1].startsWith("0"))
			dateParts[1] = dateParts[1].substring(1);

		selectBy(registerDetails.getDays(), "Index", dateParts[0]);
		selectBy(registerDetails.getMonths(), "Value", dateParts[1]);
		selectBy(registerDetails.getYears(), "Value", dateParts[2]);
		clickIsSelected(registerDetails.getSignUpNews());
		clickIsSelected(registerDetails.getOtherNews());
	}

	@When("^User enters the address details as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_address_details_as_and(String company, String address, String city, String state,
			String postalCode, String country) throws Throwable {
		sendValues(registerDetails.getCompanyName(), "clear", company);
		sendValues(registerDetails.getAddrLine1(), "clear", address);
		sendValues(registerDetails.getCity(), "clear", city);
		selectBy(registerDetails.getState(), "Visible Text", state);
		sendValues(registerDetails.getPostalCode(), "clear", postalCode);
		selectBy(registerDetails.getCountry(), "Visible Text", country);
	}

	@When("^User enters the contact details as \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_contact_details_as_and(String homePhone, String mobilePhone, String addrAlias)
			throws Throwable {
		sendValues(registerDetails.getPhone(), "clear", homePhone);
		sendValues(registerDetails.getMobilePhone(), "clear", mobilePhone);
		sendValues(registerDetails.getAlias(), "clear", addrAlias);
	}

	@When("^User clicks on register button$")
	public void user_clicks_on_register_button() throws Throwable {
		clickIsSelected(registerDetails.getRegisterBtn());
	}

}
