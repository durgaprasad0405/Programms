package EndPoints;

import static io.restassured.RestAssured.*;

import Payloads.ObjectPayload;
import Pojos.ObjectPojo;
import TestRunners.ObjectTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ObjectEndpoint {
	
	
	public static Response postObject(ObjectPojo createObjectPayload) {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.body(createObjectPayload)
				.when().post(Endpoint.post_Object);
		return response;
		
	}
	public static Response getObject() {
		Response response = given().log().all().relaxedHTTPSValidation()
				.when().get(Endpoint.get_Object+ObjectTest.id);
		return response;
		
	}
	public static Response putObject(ObjectPojo updateObjectPayload) {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.body(updateObjectPayload)
				.when().put(Endpoint.put_Object+ ObjectTest.id);
		return response;
		
	}
	public static Response deleteobject() {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.when().delete(Endpoint.delete_Object+ ObjectTest.id);
		return response;
		
	}

}
