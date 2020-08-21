package com.restAssured;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class HttpRestAssuredRequestMethods {
	
	@Test
	public void postCreate() {
		Response response = RestAssured.given().body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}").when().contentType(ContentType.JSON).post("https://reqres.in/api/users");
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is " + statusCode);
		ResponseBody body = response.getBody();
		System.out.println("Response \n");
		body.prettyPrint();
	}
	@Test
	public void putMethod() {
		Response response = RestAssured.given().body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}").when().contentType(ContentType.JSON).put("https://reqres.in/api/users/2");
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		ResponseBody body = response.getBody();
		System.out.println("Response \n");
		body.prettyPrint();
	}
	@Test
	public void postRegister() {
		Response response = RestAssured.given().body("{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"pistol\"\r\n" + 
				"}").when().contentType(ContentType.JSON).put("https://reqres.in/api/register");
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		ResponseBody body = response.getBody();
		System.out.println("Response \n");
		body.prettyPrint();
	}
	@Test
	public void postUnregister() {
		Response response = RestAssured.given().body("{\r\n" + 
				"    \"email\": \"sydney@fife\"\r\n" + 
				"}").when().contentType(ContentType.JSON).put("https://reqres.in/api/register");
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		ResponseBody body = response.getBody();
		System.out.println("Response \n");
		body.prettyPrint();
	}
	@Test
	public void postLoginSuccess() {
		Response response = RestAssured.given().body("{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"cityslicka\"\r\n" + 
				"}").when().contentType(ContentType.JSON).put("https://reqres.in/api/login");
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		ResponseBody body = response.getBody();
		System.out.println("Response \n");
		body.prettyPrint();
	}
	@Test
	public void postLoginUnsuccess() {
		Response response = RestAssured.given().body("{\r\n" + 
				"    \"email\": \"peter@klaven\"\r\n" + 
				"}").when().contentType(ContentType.JSON).put("https://reqres.in/api/login");
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		ResponseBody body = response.getBody();
		System.out.println("Response \n");
		body.prettyPrint();
	}
	@Test
	public void deleteUser() {
		Response delete = RestAssured.when().delete("https://reqres.in/api/users/2");
		int statusCode = delete.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		ResponseBody body = delete.getBody();
		System.out.println("Response \n");
		body.prettyPrint();
	}
	
}
