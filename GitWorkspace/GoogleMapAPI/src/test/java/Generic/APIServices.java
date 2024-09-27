package Generic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIServices {

	public static Response postMethod(String baseURI, String value, String inputPayload, String resourcePath) {
		
		RequestSpecification httpRequest = RestAssured.given().log().all();
		httpRequest.queryParam("key", value);
		httpRequest.relaxedHTTPSValidation();
		httpRequest.body(inputPayload);
		Response response = httpRequest.post(baseURI+resourcePath)
				.then().log().all().extract().response();
		return response;
	}
	
	public static Response getMethod(String baseURI, String value,String placeId, String resourcePath) {
		
		RequestSpecification httpRequest = RestAssured.given().log().all();
		httpRequest.queryParam("key", value);
		httpRequest.queryParam("place_id", placeId);
		httpRequest.relaxedHTTPSValidation();
		Response response = httpRequest.get(baseURI+resourcePath)
				.then().log().all().extract().response();
		return response;
	}
	
	public static Response putMethod(String baseURI, String value, String inputPayload, String resourcePath) {
	
		RequestSpecification httpRequest = RestAssured.given().log().all();
		httpRequest.queryParam("key", value);
		httpRequest.relaxedHTTPSValidation();
		httpRequest.body(inputPayload);
		Response response = httpRequest.put(baseURI+resourcePath)
				.then().log().all().extract().response();
		return response;
	}
	
	public static Response deleteMethod(String baseURI, String value, String inputPayload, String resourcePath) {
		
		RequestSpecification httpRequest = RestAssured.given().log().all();
		httpRequest.queryParam("key", value);
		httpRequest.relaxedHTTPSValidation();
		httpRequest.body(inputPayload);
		Response response = httpRequest.delete(baseURI+resourcePath)
				.then().log().all().extract().response();
		return response;
	}
	
}
