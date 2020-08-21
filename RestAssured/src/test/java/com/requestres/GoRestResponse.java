package com.requestres;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GoRestResponse {

	public static void main(String[] args) {
         Response response = RestAssured.given().get("https://gorest.co.in/public-api/users/11948?access-token=2hZ_ibB-rGiaS8bi949Xo-MzBnLWarjQK-_y");
		 ResponseBody body = response.getBody();
		 String resString = body.asString();
	     int statusCode = response.getStatusCode();	     
		 JSONObject resJson = new JSONObject(resString);
		 JSONObject result = resJson.getJSONObject("result");
		 System.out.println(statusCode);
		 System.out.println(result);
		 String id = (String) result.get("id");
		 System.out.println("Id : " + id);
	}

}
