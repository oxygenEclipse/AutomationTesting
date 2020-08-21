package com.requestres;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestResResource {

	public static void main(String[] args) throws IOException {

		ObjectMapper obj = new ObjectMapper();
		RequestRestResourcePojo resource = new RequestRestResourcePojo();
		resource.setPage(1);
		resource.setPer_page(6);
		resource.setTotal(12);
		resource.setTotal_pages(2);
		
		RequestRestData data = new RequestRestData();
		data.setId(1);
		data.setName("cerulean");
		data.setYear(2001);
		data.setColor("#98B2D1");
		data.setPantone_value("15-4020");
		
		RequestRestData data1 = new RequestRestData();
		data1.setId(2);
		data1.setName("tigerlily");
		data1.setYear(2002);
		data1.setColor("#E2583E");
		data1.setPantone_value("17-1456");			
		
		List<RequestRestData> dlist = new ArrayList<RequestRestData>();
		dlist.add(data);
		dlist.add(data1);
		
		resource.setData(dlist);		
		RequestRestAd ad = new RequestRestAd();
		ad.setCompany("StatusCode Weekly");
		ad.setUrl("http://statuscode.org/");
		ad.setText("A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.");
		resource.setAd(ad);
		String writeValueAsString = obj.writeValueAsString(resource);
		obj.writeValue(new File("C:\\Users\\LENOVO\\eclipse-workspace\\RestAssured\\src\\test\\java\\com\\requestres\\resource.json"), resource);
		System.out.println(writeValueAsString);
	}

}
