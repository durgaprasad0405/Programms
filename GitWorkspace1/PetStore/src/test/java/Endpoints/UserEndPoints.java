package Endpoints;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Creation of CRUD operations
//Created for perform Create, Read, Update and Delete requests to the API
public class UserEndPoints {
	public static Response createUser(User payload) {
		Response response = given().log().all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when().post(EndPoints.post_url);
		
		return response;
	}

}
