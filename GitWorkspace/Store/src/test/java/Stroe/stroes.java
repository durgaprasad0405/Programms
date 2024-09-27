package Stroe;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class stroes {
	
	public static void main(String[] args) {
		RestAssured.baseURI="https://petstore.swagger.io";
		
		given().log().all().header("accept", "application/json").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "  \"id\": 434,\r\n"
				+ "  \"petId\": 43,\r\n"
				+ "  \"quantity\": 6,\r\n"
				+ "  \"shipDate\": \"2024-05-06T05:08:54.934Z\",\r\n"
				+ "  \"status\": \"placed\",\r\n"
				+ "  \"complete\": true\r\n"
				+ "}")
		.when().post("/v2/store/orde").then().log().all();
	}

}
