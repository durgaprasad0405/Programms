package TestRunners;

import org.junit.Assert;
import org.junit.Test;

import EndPoints.ObjectEndpoint;
import Payloads.ObjectPayload;
import Pojos.ObjectPojo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ObjectTest {
	
		public static String id;
	
	@Test
	public void testAPost() {
		
		System.out.println("*****************************************   *Create Object*   *****************************************");
		
		Response response = ObjectEndpoint.postObject(ObjectPayload.createObjectPayload());
		response.then().log().all();
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		id = js.get("id");
		System.out.println(id);
	}
	@Test
	public void testBGet() {
		
		System.out.println("*****************************************   *Get Object BY id*   *****************************************");
		
		Response response = ObjectEndpoint.getObject();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
//		String res = response.asString();
//		System.out.println(res);
	}
//	@Test
//	public void testCPut() {
//		
//		System.out.println("*****************************************   *Update Object*   *****************************************");
//		
//		Response response = ObjectEndpoint.putObject(ObjectPayload.updateObjectPayload());
//		response.then().log().all();
//		Assert.assertEquals(response.getStatusCode(), 200);
//		
//		String res = response.asString();
//		System.out.println(res);
//	}
//	@Test
//	public void testEDelete() {
//		
//		System.out.println("*****************************************   *Delete Object BY UserID*   *****************************************");
//		
//		Response response = ObjectEndpoint.deleteobject();
//		response.then().log().all();
//		Assert.assertEquals(response.getStatusCode(), 200);
//		
//		String res = response.asString();
//		System.out.println(res);
//	}

}
