package com.qa.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.location.FileLocation;
import com.qa.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCall extends TestBase {

	@DataProvider
	public String[][] getData() {

		return TestUtil.readDataExcel(FileLocation.CITY_FILE_LOCATION, "cityList");
	}

	@Test(dataProvider = "getData")
	public void getWeatherInfo(String cityName) {

		initialization();
		String baseUri = prop.getProperty("baseUrlDemoQa") + prop.getProperty("pathParameterDemoQa") + cityName;
		RestAssured.baseURI = baseUri;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		System.out.println(response.statusCode());
		System.out.println(response.getBody().asString());

	}

}
