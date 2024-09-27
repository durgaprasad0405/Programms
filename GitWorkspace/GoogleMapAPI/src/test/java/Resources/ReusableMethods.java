package Resources;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReusableMethods {

	static ResponseSpecification response;
	public static Response res;
	
	public static ResponseSpecification givenThen() {
		response = given().log().all().relaxedHTTPSValidation().then().log().all().expect().response();
		return response;
	}
	
	public static RequestSpecification reqSpec = given().relaxedHTTPSValidation().log().all()
			.header("Content-Type", "application/json")
			.queryParam("key", "qaclick123");
	
	public static ResponseSpecification resSpec = reqSpec.then().log().all()
			.contentType(ContentType.JSON).statusCode(200);
	
	public static String getJsonPath(Response responce , String key) {
		String resp = responce.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
	
	public static Response deletePost() {
		res = given().relaxedHTTPSValidation().body(TextData.payload)
		.queryParam("key", "qaclick123").when()
		.post(TextData.base_URL+"/maps/api/place/add/json")
		.then().extract().response();
		return res;
	}
	
	
}
