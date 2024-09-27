package rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Restapi {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.restful-api.dev";
		
		String res = given().log().all().contentType(ContentType.JSON).body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "").when().post("/objects")
		.then().log().all().statusCode(200).extract().asString();
		
		JsonPath js = new JsonPath(res);
		String id = js.get("id");
		System.out.println(id);
		
		//Get method
		
//		given().log().all().contentType(ContentType.JSON).when().post("/objects/"+id)
//		.then().log().all().assertThat().statusCode(200);
	}

}
