package com.restAssured;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class OpenWeatherMap {
	
	@Test
	public void getCityWeatherDetails() {
		Response response = RestAssured.given().when().get("http://api.openweathermap.org/data/2.5/weather?q=Saint Petersburg,RU&APPID=f0410f143a257ac1def4e12e92c3fc77");
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + statusCode);
		ResponseBody body = response.getBody();
		JsonPath jsonPath = response.jsonPath();
		System.out.println("Json Path : " + jsonPath);
		String coord = jsonPath.get("coord").toString();
		String base = jsonPath.get("base").toString();
		System.out.println("Coordinates : " + coord);
		System.out.println("Base : " + base);
		System.out.println("Response \n");
		body.prettyPrint();
	}

}
