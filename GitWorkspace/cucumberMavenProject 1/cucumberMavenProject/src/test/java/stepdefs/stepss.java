package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class stepss {
	
	String Base_URL = "https://rahulshettyacademy.com";
	String Payload = "{\r\n"
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
			+ "}";

	RequestSpecification req ;
	Response response;
	@Given("User calls the {string}")
	public void user_calls_the(String Base_url) {
		RestAssured.baseURI =Base_url;
		req = given().log().all().headers("Content-Type", "application/json").queryParam("key", "qaclick123").body(Payload);	
	}
	@When("User calls With {string} method")
	public void user_calls_with_method(String method) {
		
		if (method=="POST") {
			response=req.when().post("/maps/api/place/add/json");
			response.then().log().all().extract().response().asString();
			response.asPrettyString();
		}
		else if (method=="GET"){
			response=req.when().get("/maps/api/place/add/json");
			response.then().log().all().extract().response().asString();
			response.asPrettyString();
		}
		System.out.println(response);
	}
	@Then("The API calls get success with status {string}")
	public void the_api_calls_get_success_with_status(String value) {
//		JsonPath js = new JsonPath(response.asString());
//		assertEquals(value, js.getString("status"));
	}
}