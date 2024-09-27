package TestRunners;

import org.junit.Assert;
import org.junit.Test;

import EndPoints.AccountEndpoint;
import Payloads.AccountPayload;
import Pojos.AccountPojo;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AccountTest {
	
	public static String token;
	public static String userID;
	
	@Test
	public void testAPost() {
		
		System.out.println("*****************************************   *Create Account*   *****************************************");
		
		Response response = AccountEndpoint.postAccount(AccountPayload.createAccountPayload());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		userID = js.get("userID");
		System.out.println(userID);
		System.out.println(AccountPayload.createAccountPayload().getUserName());
		String name = js.get("username");
		System.out.println(name);
		Assert.assertEquals(AccountPayload.createAccountPayload().getUserName(), js.get("username"));
	}
	@Test
	public void testBPost() {
		
		System.out.println("*****************************************   *Generating Token*   *****************************************");
		
		Response response = AccountEndpoint.postGenerateToken(AccountPayload.createAccountPayload());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		token = js.get("token");
		System.out.println(token);
	}
	@Test
	public void testCPost() {
		
		System.out.println("*****************************************   *Authorization*   *****************************************");
		
		Response response = AccountEndpoint.postAuthorized(AccountPayload.createAccountPayload());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String res = response.asString();
		System.out.println(res);
	}
	@Test
	public void testDGet() {
		
		System.out.println("*****************************************   *Get Account BY UserID*   *****************************************");
		
		Response response = AccountEndpoint.getAccount();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		System.out.println(js);
	}
	@Test
	public void testEDelete() {
		
		System.out.println("*****************************************   *Delete Account BY UserID*   *****************************************");
		
		Response response = AccountEndpoint.deleteAccount();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
		
		String res = response.asString();
		System.out.println(res);
	}

}
