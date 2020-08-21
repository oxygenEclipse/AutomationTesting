package com.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestAssuredBaseClass {
	
	public static int getResponse(String uri,String queryStr, String queryVal,String page) {
		RestAssured.baseURI = uri;
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam(queryStr, queryVal).get(page);
		ResponseBody body = response.getBody();
		System.out.println("Get Status Code : " + response.getStatusCode());
		System.out.println("Get Response \n");
		body.prettyPrint();
		return response.getStatusCode();
	}
	public static int getResponse(String uri,String page) {
		RestAssured.baseURI = uri;
		RequestSpecification request = RestAssured.given();
		Response response = request.get(page);
		ResponseBody body = response.getBody();
		System.out.println("Get Status Code : " + response.getStatusCode());
		System.out.println("Get Response \n");
		body.prettyPrint();
		return response.getStatusCode();
	}
	public static int postResponse(String uri,String body,String param) {
		RestAssured.baseURI = uri;
		Response post = RestAssured.given().body(body).contentType(ContentType.JSON).post(param);
		ResponseBody postResponse = post.getBody();
		System.out.println("Post Status Code : " + post.getStatusCode());
		System.out.println("Post Response \n");
		postResponse.prettyPrint();
		return post.getStatusCode();
	}
	public static int putResponse(String uri, String body,String param) {
		RestAssured.baseURI = uri;
		Response put = RestAssured.given().body(body).contentType(ContentType.JSON).put(param);
		ResponseBody putResponse = put.getBody();
		System.out.println("Put Status Code : " + put.getStatusCode());
		System.out.println("Put Response \n");
		putResponse.prettyPrint();
		return put.getStatusCode();
	}

}
