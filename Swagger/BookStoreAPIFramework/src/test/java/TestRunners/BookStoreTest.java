package TestRunners;

import org.junit.Assert;
import org.junit.Test;

import EndPoints.BookStoreEndpoint;
import Payloads.BookStorePayload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BookStoreTest {
	
	
	public static String userID;
	@Test
	public void testAPost() {
		
		System.out.println("*****************************************   *Create BookStore Account*   *****************************************");
		
		Response response = BookStoreEndpoint.postBookstoreAccount(BookStorePayload.createBookStoreAccountPayload());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		userID = js.get("userID");
		System.out.println(userID);
	}
	@Test
	public void testBPost() {
		
		System.out.println("*****************************************   *Create Book*   *****************************************");
		
		Response response = BookStoreEndpoint.postCreateBook(BookStorePayload.createBookStorePayload());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}	
	@Test
	public void testCGet() {
		
		System.out.println("*****************************************   *Get Book*   *****************************************");
		
		Response response = BookStoreEndpoint.getBook();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

	@Test
	public void testEDelete() {
		
		System.out.println("*****************************************   *Delete Book By UserID*   *****************************************");
		
		Response response = BookStoreEndpoint.deleteBookUserID();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
	}

}
