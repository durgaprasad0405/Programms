package stepdef;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class step {

	String Base_URL = "https://rahulshettyacademy.com";
	String payload = "{\r\n"
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
	
	
	@Given("Verify user should able to access the Base-URL {string}")
	public void verify_user_should_able_to_access_the_base_url(String baseURL) {
		
		given().log().all().queryParam("key", "qaclick123").body(payload).when().post(baseURL+"/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
	}
	@Given("Verify user should not able to access the Base-URL {string}")
	public void verify_user_should_not_able_to_access_the_base_url(String baseURL) {
		
		
		
	}
	@When("Verify user should able to access Post {string} Method")
	public void verify_user_should_able_to_access_post_method(String string) {
		
		given().log().all().queryParam("key", "qaclick123").body(payload).when().post(Base_URL+"/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
	}
	@When("Verify user should not be able to access Add place request with invalid HTTP {string} Method")
	public void verify_user_should_not_be_able_to_access_add_place_request_with_invalid_http_method(String string) {
		
		given().log().all().queryParam("key", "qaclick123").body(payload).when().get(Base_URL+"/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
	}
	@Given("Verify user should able to accept the payload")
	public void verify_user_should_able_to_accept_the_payload() {
		
		given().log().all().queryParam("key", "qaclick123").body(payload).when().post(Base_URL+"/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
	}
	@Given("Verify user should able to text the phone number {string}")
	public void verify_user_should_able_to_text_the_phone_number(String phNo) {
		
		given().log().all().queryParam("key", "qaclick123").body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 40,\r\n"
				+ "    \"name\": \"Kanna House\",\r\n"
				+ "    \"phone_number\": \"+"+phNo+"\",\r\n"
				+ "    \"address\": \"Kanna Colony, Kanna Street\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"Kanna park\",\r\n"
				+ "        \"Kanna shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://Kanna.com\",\r\n"
				+ "    \"language\": \"Telugu-IN\"\r\n"
				+ "}").when().post(Base_URL+"/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
	}
	@Given("Verify user should not able to take invalid phone number {string}")
	public void verify_user_should_not_able_to_take_invalid_phone_number(String phNo) {
		
		given().log().all().queryParam("key", "qaclick123").body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 40,\r\n"
				+ "    \"name\": \"Kanna House\",\r\n"
				+ "    \"phone_number\": \"+"+phNo+"\",\r\n"
				+ "    \"address\": \"Kanna Colony, Kanna Street\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"Kanna park\",\r\n"
				+ "        \"Kanna shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://Kanna.com\",\r\n"
				+ "    \"language\": \"Telugu-IN\"\r\n"
				+ "}").when().post(Base_URL+"/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
	}
	@Then("Verify place_id is generated")
	public void verify_place_id_is_generated() {
		
		String responce= given().log().all().queryParam("key", "qaclick123").body(payload).when().post(Base_URL+"/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
		JsonPath js = new JsonPath(responce);
		System.out.println(js.getString("place_id"));
	}
	@Then("Verify status is {string}")
	public void verify_status_is(String status) {
		
		String responce= given().log().all().queryParam("key", "qaclick123").body(payload).when().post(Base_URL+"/maps/api/place/add/json")
				.then().log().all().extract().response().asString();
				
		JsonPath js = new JsonPath(responce);
		String statusVlaue = js.getString("status");
		assertEquals(statusVlaue, status);
		
	}
	@Given("Verify whether its accepting location key and value {double} and {double}")
	public void verify_whether_its_accepting_location_key_and_value_and(Double lat, Double lng) {
		
		given().log().all().queryParam("key", "qaclick123").body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": "+lat+",\r\n"
				+ "        \"lng\": "+lng+"\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 40,\r\n"
				+ "    \"name\": \"Kanna House\",\r\n"
				+ "    \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "    \"address\": \"Kanna Colony, Kanna Street\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"Kanna park\",\r\n"
				+ "        \"Kanna shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://Kanna.com\",\r\n"
				+ "    \"language\": \"Telugu-IN\"\r\n"
				+ "}").when().post(Base_URL+"/maps/api/place/add/json")
		.then().log().all().extract().response().asString();
		
	}

}