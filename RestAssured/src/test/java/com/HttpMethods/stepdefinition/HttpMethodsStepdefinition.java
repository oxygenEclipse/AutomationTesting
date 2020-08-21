package com.HttpMethods.stepdefinition;

import java.io.File;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpMethodsStepdefinition {

	public static RequestSpecification resSpec = RestAssured.given();
	public static String endpoint;
	public static Response response;
	public static JsonPath result;
	public static String id = "";

	@Given("^User mentions the endpoint \"([^\"]*)\"$")
	public void user_mentions_the_endpoint(String url) throws Throwable {
		endpoint = url;
	}

	@When("^User sends the GET Request$")
	public void user_sends_the_GET_Request() throws Throwable {
		response = resSpec.get(endpoint + id);
	}

	@Then("^User prints the response$")
	public void user_prints_the_response() throws Throwable {
		response.prettyPrint();
	}

	@Then("^User verifies whether the response status code is \"([^\"]*)\"$")
	public void user_verifies_whether_the_response_status_code_is(String statusCode) throws Throwable {
		Assert.assertEquals(statusCode, String.valueOf(response.getStatusCode()));
	}

	@Then("^User verifies whether the response key \"([^\"]*)\" in response body is equal to \"([^\"]*)\"$")
	public void user_verifies_whether_the_response_key_in_response_body_is_equal_to(String key, String actualValue)
			throws Throwable {
		result = response.jsonPath();
		String expectedValue = String.valueOf(result.get(key));
		Assert.assertEquals(expectedValue, actualValue);
	}

	@Then("^User verifies whether the response key \"([^\"]*)\" in response body contains \"([^\"]*)\"$")
	public void user_verifies_whether_the_response_key_in_response_body_contains(String key, String actualValue)
			throws Throwable {
		result = response.jsonPath();
		String expectedValue = String.valueOf(result.get(key));
		Assert.assertTrue(expectedValue.contains(actualValue));
	}

	@When("^User mentions the request body$")
	public void user_mentions_the_request_body(String requestInput) throws Throwable {
		resSpec = resSpec.body(requestInput).when().contentType(ContentType.JSON);

	}

	@When("^User sends the POST Request$")
	public void user_sends_the_POST_Request() throws Throwable {
		response = resSpec.post(endpoint);
	}

	@Then("^User verifies whether the response key \"([^\"]*)\" in response body is present$")
	public void user_verifies_whether_the_response_key_in_response_body_is_present(String key) throws Throwable {
		result = response.jsonPath();
		id = String.valueOf(result.get(key));
		Assert.assertNotNull(id);
	}

	@When("^User sends the PUT Request$")
	public void user_sends_the_PUT_Request() throws Throwable {
		response = resSpec.put(endpoint);
	}

	@When("^User sends the DELETE Request$")
	public void user_sends_the_DELETE_Request() throws Throwable {
		response = resSpec.delete(endpoint);
	}

	@When("^User specify the header key as \"([^\"]*)\" and value as \"([^\"]*)\"$")
	public void user_specify_the_header_key_as_and_value_as(String key, String value) throws Throwable {
		resSpec = resSpec.header(key, value);
	}

	@When("^User pass the authentication credentials$")
	public void user_pass_the_authentication_credentials() throws Throwable {
		resSpec = resSpec.auth().preemptive().basic("itsbanumathig@gmail.com", "JbZuylbQomk1uqy7BTjpFE29");
	}

	@When("^User specify the input body from the file \"([^\"]*)\"$")
	public void user_specify_the_input_body_from_the_file(String jsonFile) throws Throwable {
		File f = new File(System.getProperty("user.dir") + "\\" + jsonFile);
		resSpec = resSpec.when().body(f);
	}
}
