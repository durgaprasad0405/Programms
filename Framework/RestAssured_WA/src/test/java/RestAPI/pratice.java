package RestAPI;

import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.http.ContentType;

public class pratice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		given().body("{\r\n"
//				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
//				+ "   \"data\": {\r\n"
//				+ "      \"year\": 2019,\r\n"
//				+ "      \"price\": 1849.99,\r\n"
//				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
//				+ "      \"Hard disk size\": \"1 TB\"\r\n"
//				+ "   }\r\n"
//				+ "}").contentType(ContentType.JSON)
//		.when().post("https://api.restful-api.dev/objects")
//		.then().log().all().statusCode(200);
		
		
		given().contentType(ContentType.JSON)
		.contentType("multipart/form-data")	//"C:\\Users\\draghava\\Downloads\\dog.jpg"
		.multiPart("file", new File("C:\\Users\\draghava\\Downloads\\dogLikeFox.jpg"))//"C:\Users\draghava\Downloads\dogLikeFox.jpg"
		.multiPart("additionalMetadata", "nice pet to buy")
		.when().post("https://petstore.swagger.io/v2/pet/81/uploadImage")
		.then().log().all().statusCode(200);
		
		given().contentType(ContentType.JSON)
		.contentType("multipart/form-data")	//"C:\\Users\\draghava\\Downloads\\dog.jpg"
//		.multiPart("file", new File("C:\\Users\\draghava\\Downloads\\dogLikeFox.jpg"))//"C:\Users\draghava\Downloads\dogLikeFox.jpg"
		.multiPart("name", "Darbarman")
		.multiPart("status", "Pending")
		.when().post("https://petstore.swagger.io/v2/pet/81")
		.then().log().all().statusCode(200);
//		
//		given().contentType(ContentType.JSON)
//		.body("{\r\n"
//				+ "  \"id\": 81,\r\n"
//				+ "  \"name\": \"doggie\",\r\n"
//				+ "  \"status\": \"available3\"\r\n"
//				+ "}")
//		.when().put("https://petstore.swagger.io/v2/pet")
//		.then().log().all().statusCode(200);
//		
		given().contentType(ContentType.JSON)
		.when().get("https://api.restful-api.dev/objects/ff8081819071bec70190730c3b7b02d1")
		.then().log().all().statusCode(200);
//		
//		
//		given().contentType(ContentType.JSON)
//		.when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available2")
//		.then().log().all().statusCode(200);
	}

}
