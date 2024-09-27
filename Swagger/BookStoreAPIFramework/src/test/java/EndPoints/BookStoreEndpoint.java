package EndPoints;

import static io.restassured.RestAssured.given;

import Payloads.BookStorePayload;
import Pojos.BookStoreAccountPojo;
import Pojos.BookStorePojo;
import Pojos.collectionOfIsbns;
import TestRunners.BookStoreTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookStoreEndpoint {
	
	public static Response postBookstoreAccount(BookStoreAccountPojo createBookStoreAccountPayload) {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.body(createBookStoreAccountPayload)
				.when().post(Endpoint.post_book_account);
		return response;	
	}
	
	public static Response postCreateBook(BookStorePojo createBookStorePayload) {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.auth().preemptive().basic(BookStorePayload.createBookStoreAccountPayload().getUserName(), BookStorePayload.createBookStoreAccountPayload().getPassword())
				.body(createBookStorePayload)
				.when().post(Endpoint.post_create_book);
		return response;	
	}
	
	public static Response getBook() {
		Response response = given().log().all().relaxedHTTPSValidation()
				.when().get(Endpoint.get_book);
		return response;	
	}
	
	public static Response deleteBookUserID() {
		Response response = given().log().all().relaxedHTTPSValidation()
				.queryParam("UserId", BookStoreTest.userID)
				.auth().preemptive().basic(BookStorePayload.createBookStoreAccountPayload().getUserName(), BookStorePayload.createBookStoreAccountPayload().getPassword())
				.when().delete(Endpoint.delete_book_userid);
		return response;	
	}


}
