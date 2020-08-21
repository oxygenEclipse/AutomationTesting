package com.restAssured;

import org.junit.Assert;
import org.junit.Test;


public class RestAssuredHttpMethods extends RestAssuredBaseClass {

	@Test
	public void getHttp() {
		int listUserCode = getResponse("https://reqres.in/api/","page","2","/users");
		Assert.assertEquals(listUserCode, 200);
		int singleUserCode = getResponse("https://reqres.in/api/","/users/2");
		Assert.assertEquals(singleUserCode, 200);
		int singleUserNotFound = getResponse("https://reqres.in/api/","/users/23");
		Assert.assertEquals(singleUserNotFound, 404);
		int listResource = getResponse("https://reqres.in/api/","/unknown");
		Assert.assertEquals(listResource, 200);
		int singleResource = getResponse("https://reqres.in/api/","/unknown/2");
		Assert.assertEquals(singleResource, 200);
		int singleResourceNotFound = getResponse("https://reqres.in/api/","/unknown/23");
		Assert.assertEquals(singleResourceNotFound, 404);
	}
	@Test
	public void postHttp() {
		int postCreateCode = postResponse("https://reqres.in/api/","{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}","/users");
		Assert.assertEquals(postCreateCode, 201);
		int postSuccessRegisterCode = postResponse("https://reqres.in/api/","{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"pistol\"\r\n" + 
				"}","/register");
		Assert.assertEquals(postSuccessRegisterCode, 200);
		int postUnsuccessRegisterCode = postResponse("https://reqres.in/api/","{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"pistol\"\r\n" + 
				"}","/register");
		Assert.assertEquals(postUnsuccessRegisterCode, 400);
		int postSuccessLoginCode = postResponse("https://reqres.in/api/","{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"cityslicka\"\r\n" + 
				"}","/login");
		Assert.assertEquals(postSuccessLoginCode, 200);	
		int postUnsuccessLoginCode = postResponse("https://reqres.in/api/","{\r\n" + 
				"    \"email\": \"peter@klaven\"\r\n" + 
				"}","/login");
		Assert.assertEquals(postUnsuccessLoginCode, 400);
	}
	@Test
	public void putHttp() {
		int putUpdateCode = putResponse("https://reqres.in/api/","{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}","users/2");
		Assert.assertEquals(putUpdateCode, 200);	
	}
}
