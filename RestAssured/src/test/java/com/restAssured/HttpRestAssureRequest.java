package com.restAssured;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class HttpRestAssureRequest {

	@Test
	public void getListUser() {
		System.out.println("Get List User \n");
		Response response = RestAssured.given().get("https://reqres.in/api/users?page=2");
		int statusCode = response.getStatusCode();
		ResponseBody body = response.getBody();
		String responseStr = body.prettyPrint();
		// System.out.println("Response Code : " + statusCode + "\nResponse \n" +
		// responseStr);
	}

	@Test
	public void getSingleUser() {
		System.out.println("\nGet Single User \n");
		RestAssured.given().get("https://reqres.in/api/users/2").getBody().prettyPrint();
		// int statusCode = response.getStatusCode();
	}

	@Test
	public void getSingleUserNotFound() {
		System.out.println("\nGet Single User Not Found \n");
		RestAssured.given().get("https://reqres.in/api/users/23").getBody().prettyPrint();
	}

	@Test
	public void getListResource() {
		System.out.println("\nGet List Resource \n");
		RestAssured.given().get("https://reqres.in/api/unknown").getBody().prettyPrint();
	}
	@Test
	public void getSingleResource() {
		System.out.println("\nGet Single Resource \n");
		RestAssured.given().get("https://reqres.in/api/unknown/2").getBody().prettyPrint();
	}
	@Test
	public void getSingleResourceNotFound() {
		System.out.println("\nGet Single Resource Not Found \n");
		RestAssured.given().get("https://reqres.in/api/unknown/23").getBody().prettyPrint();
	}

}
