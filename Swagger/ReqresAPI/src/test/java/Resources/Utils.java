package Resources;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification reqSpec;
	public static ResponseSpecification resSpec;
	public static RequestSpecification requestSpecification() throws IOException {
		reqSpec = new RequestSpecBuilder()
				.setBaseUri(Endpoints.base_url)
				.setContentType(ContentType.JSON).build();
		return reqSpec;
		}
	
	public static ResponseSpecification responceSpecification() throws IOException {
		resSpec= new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON).build();
		return resSpec;
	}
	
	public static String getJsonPath(Response responce , String key) {
		String resp = responce.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

}
