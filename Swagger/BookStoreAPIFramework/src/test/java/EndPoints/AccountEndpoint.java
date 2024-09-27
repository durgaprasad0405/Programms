package EndPoints;

import static io.restassured.RestAssured.*;

import Payloads.AccountPayload;
import Pojos.AccountPojo;
import TestRunners.AccountTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AccountEndpoint {
	
//	public static AccountPojo accountPojo = new AccountPojo();
	
	public static Response postAccount(AccountPojo createAccountPayload) {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.body(createAccountPayload)
				.when().post(Endpoint.post_account);
		return response;	
	}
	public static Response postGenerateToken(AccountPojo createAccountPayload) {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.body(createAccountPayload)
				.when().post(Endpoint.post_generate_token);
		return response;
		
	}
	public static Response postAuthorized(AccountPojo createAccountPayload) {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + AccountTest.token)
				.body(createAccountPayload)
				.when().post(Endpoint.post_authorized);
		return response;
		
	}
	public static Response getAccount() {
		Response response = given().log().all().relaxedHTTPSValidation()
//				.pathParam("userID", AccountTest.userID)
//				.auth().basic(accountPojo.getUserName(), accountPojo.getPassword())
				.header("Authorization", "Bearer " + AccountTest.token)
				.when().get(Endpoint.get_account+AccountTest.userID);
		return response;
		
	}
	public static Response deleteAccount() {
		Response response = given().log().all().relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
//				.pathParam("userID", AccountTest.userID)
				.header("Authorization", "Bearer " + AccountTest.token)
				.when().delete(Endpoint.delete_account+AccountTest.userID);
		return response;
		
	}

}
