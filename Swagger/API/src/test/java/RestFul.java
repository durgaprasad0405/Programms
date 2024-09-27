import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class RestFul {
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.restful-api.dev/";
		
		//post mathod
		
		String res = given().log().all().contentType(ContentType.JSON)
		.body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}")
		.when().post("/objects").then().log().all().extract().asString();
		JsonPath js = new JsonPath(res);
		String id = js.get("id");
		System.out.println(id);
		
				
				//get mathod
				
				given().log().all().contentType(ContentType.JSON)
				.when().get("/objects").then().log().all();
				
				//put mathod
				
				given().log().all().contentType(ContentType.JSON)
				.body("{\r\n"
						+ "   \"name\": \"Apple \",\r\n"
						+ "   \"data\": {\r\n"
						+ "      \"year\": 2020,\r\n"
						+ "      \"price\": 4546,\r\n"
						+ "      \"CPU model\": \"Intel Core i9\",\r\n"
						+ "      \"Hard disk size\": \"10 TB\"\r\n"
						+ "   }\r\n"
						+ "}")

//				.pathParam("id", id)
				.when().put("/objects/"+id).then().log().all();
				
				//delete mathod
				
				given().log().all().contentType(ContentType.JSON)
//				.pathParam("id", id)
				.when().delete("/objects/"+id).then().log().all();
	}

}
