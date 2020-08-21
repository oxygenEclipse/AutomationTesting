package com.restAssured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONPractice {

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper cityTemp = new ObjectMapper();
		CityTemperatureJSON saint = new CityTemperatureJSON();
		saint.setId("12345");
		saint.setCity("Saint Petersburg");
		saint.setTemp_min("293.71");
		saint.setTemp_max("296.48");
		saint.setHumidity("49");
		saint.setPressure("1020");
		saint.setWind(new String[] { "3", "45" });
		String cityJson = cityTemp.writeValueAsString(saint);
		System.out.println(cityJson);
	}

}
