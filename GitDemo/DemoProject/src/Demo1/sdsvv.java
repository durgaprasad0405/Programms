package Demo1;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class sdsvv {

	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123")
		.body("{\r\n"
			+ "    \"location\": {\r\n"
			+ "        \"lat\": -38.383494,\r\n"
			+ "        \"lng\": 33.427362\r\n"
			+ "    },\r\n"
			+ "    \"accuracy\": 40,\r\n"
			+ "    \"name\": \"Kanna House\",\r\n"
			+ "    \"phone_number\": \"+91) 983 893 3937\",\r\n"
			+ "    \"address\": \"Kanna Colony, Kanna Street\",\r\n"
			+ "    \"types\": [\r\n"
			+ "        \"Kanna park\",\r\n"
			+ "        \"Kanna shop\"\r\n"
			+ "    ],\r\n"
			+ "    \"website\": \"http://Kanna.com\",\r\n"
			+ "    \"language\": \"Telugu-IN\"\r\n"
			+ "}").when().post("/maps/api/place/add/json").then().log().all();
	}
	
}
