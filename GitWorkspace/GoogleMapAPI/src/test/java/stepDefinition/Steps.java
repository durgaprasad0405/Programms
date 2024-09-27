package stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.hamcrest.core.StringContains;
import org.junit.Assert;

import Resources.ReusableMethods;
import Resources.TextData;

public class Steps {


	Response responce;
	Response responce1;
	Response responce2;
	String res;
	JsonPath js;
	public static String placeId;
	@Given("Verify {string} user should able to access the {string}")
	public void verify_user_should_able_to_access_the(String module, String baseURL) {

		if (module.equalsIgnoreCase("post")) {
			if (baseURL.equalsIgnoreCase("https://rahulshettyacademy.com")) {
				responce = given().relaxedHTTPSValidation().log().all().
				when().post(baseURL+"/maps/api/place/add/json").then().log().all().extract().response();
				System.out.println("Valied URL");
			}
			else {
				System.out.println("In-valied URL");
			}
		}
		else if (module.equalsIgnoreCase("get")) {
			if (baseURL.equalsIgnoreCase("https://rahulshettyacademy.com")) {
				responce = given().relaxedHTTPSValidation().log().all().
						when().get(baseURL+"/maps/api/place/get/json").then().log().all().extract().response();
						System.out.println("Valied URL");
			}
			else {
				System.out.println("In-valied URL");
			}
		}
		else if (module.equalsIgnoreCase("put")) {
			if (baseURL.equalsIgnoreCase("https://rahulshettyacademy.com")) {
				responce = given().relaxedHTTPSValidation().log().all().
						when().put(baseURL+"/maps/api/place/update/json").then().log().all().extract().response();
						System.out.println("Valied URL");
			}
			else {
				System.out.println("In-valied URL");
			}
		}
		else if (module.equalsIgnoreCase("delete")) {
			if (baseURL.equalsIgnoreCase("https://rahulshettyacademy.com")) {
				responce = given().relaxedHTTPSValidation().log().all().
						when().delete(baseURL+"/maps/api/place/delete/json").then().log().all().extract().response();
						System.out.println("Valied URL");
			}
			else {
				System.out.println("In-valied URL");
			}
		}
	}
	@Given("Verify {string} user should able to accept the Payload")
	public void verify_user_should_able_to_accept_the_payload(String module) {
		if (module.equalsIgnoreCase("post")) {
			responce = given().spec(ReusableMethods.reqSpec).body(TextData.payload)
					.when().post(TextData.base_URL+"/maps/api/place/add/json")
			.then().spec(ReusableMethods.resSpec).extract().response();
		}
		else if (module.equalsIgnoreCase("delete")) {
			responce = given().relaxedHTTPSValidation().body(TextData.payload)
					.queryParam("key", "qaclick123").when()
					.post(TextData.base_URL+"/maps/api/place/add/json")
					.then().extract().response();
			res = responce.asString();
			js = new JsonPath(res);
			placeId = js.getString("place_id");
			responce = given().spec(ReusableMethods.reqSpec).body(TextData.deletePayload(placeId))
					.when().delete(TextData.base_URL+"/maps/api/place/delete/json")
			.then().spec(ReusableMethods.resSpec).extract().response();
		}
		
	}
	@Given("Verify {string} user should able to text the {string}")
	public void verify_user_should_able_to_text_the(String module, String phoneNumber) {
		
		given().relaxedHTTPSValidation().log().all().body(TextData.payload(phoneNumber)).
		when().post(TextData.base_URL+"/maps/api/place/add/json").then().log().all();
		
	}
	@Given("Verify {string} whether its accepting location key and value")
	public void verify_whether_its_accepting_location_key_and_value(String module) {
		responce = given().spec(ReusableMethods.reqSpec).body(TextData.payload)
				.when().post(TextData.base_URL+"/maps/api/place/add/json")
		.then().spec(ReusableMethods.resSpec).extract().response();
		
	}
	@When("Verify {string} user should able to access the post {string}")
	public void verify_user_should_able_to_access_the_post(String module, String method) {
		if (module.equalsIgnoreCase("post")) {
			if (method.equalsIgnoreCase("POST")) {
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.payload)
						.when().post(TextData.base_URL+"/maps/api/place/add/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
			else if (method.equalsIgnoreCase("GET")) {
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.payload)
						.when().get(TextData.base_URL+"/maps/api/place/add/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
		}
		else if (module.equalsIgnoreCase("get")) {
			if (method.equalsIgnoreCase("GET")) {
				responce = given().spec(ReusableMethods.reqSpec).queryParam("place_id", placeId)
						.when().get(TextData.base_URL+"/maps/api/place/get/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
			else if (method.equalsIgnoreCase("PUT")) {
				responce = given().spec(ReusableMethods.reqSpec).queryParam("place_id", placeId)
						.when().put(TextData.base_URL+"/maps/api/place/get/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
		}
		else if (module.equalsIgnoreCase("put")) {
			if (method.equalsIgnoreCase("PUT")) {
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.putPayload(placeId, "41"))
						.when().put(TextData.base_URL+"/maps/api/place/update/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
			else if (method.equalsIgnoreCase("GET")) {
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.putPayload(placeId, "672"))
						.when().get(TextData.base_URL+"/maps/api/place/update/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
		}
		else if (module.equalsIgnoreCase("delete")) {
			if (method.equalsIgnoreCase("DELETE")) {
				responce = given().relaxedHTTPSValidation().body(TextData.payload)
						.queryParam("key", "qaclick123").when()
						.post(TextData.base_URL+"/maps/api/place/add/json")
						.then().extract().response();
				res = responce.asString();
				js = new JsonPath(res);
				placeId = js.getString("place_id");
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.deletePayload(placeId))
						.when().delete(TextData.base_URL+"/maps/api/place/delete/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
			else if (method.equalsIgnoreCase("PUT")) {
				responce = given().relaxedHTTPSValidation().body(TextData.payload)
						.queryParam("key", "qaclick123").when()
						.post(TextData.base_URL+"/maps/api/place/add/json")
						.then().extract().response();
				res = responce.asString();
				js = new JsonPath(res);
				placeId = js.getString("place_id");
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.deletePayload(placeId))
						.when().put(TextData.base_URL+"/maps/api/place/delete/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
		}
		
	}
	@Then("Verify {string} place_id is generated")
	public void verify_place_id_is_generated(String module) {
		responce = given().spec(ReusableMethods.reqSpec).body(TextData.payload)
				.when().post(TextData.base_URL+"/maps/api/place/add/json")
		.then().spec(ReusableMethods.resSpec).extract().response();
		res = responce.asString();
		js = new JsonPath(res);
		placeId = js.getString("place_id");
		System.out.println(placeId);
		
	}
	@Then("Verify {string} status is {string}")
	public void verify_status_is(String module, String value) {
		if (module.equalsIgnoreCase("post")) {
			responce = given().spec(ReusableMethods.reqSpec).body(TextData.payload)
					.when().post(TextData.base_URL+"/maps/api/place/add/json")
			.then().spec(ReusableMethods.resSpec).extract().response();
			String status = js.getString("status");
			System.out.println(status);
			Assert.assertEquals(js.getString("status"), value);
		}
		else if (module.equalsIgnoreCase("get")) {
			responce1 = given().spec(ReusableMethods.reqSpec).queryParam("place_id", placeId)
					.when().get(TextData.base_URL+"/maps/api/place/get/json")
			.then().spec(ReusableMethods.resSpec).extract().response();
			JsonPath js1=new JsonPath(responce1.asString());
			String acc = js1.getString("accuracy");
			System.out.println(acc);
			Assert.assertEquals(js1.getString("accuracy"), value);
		}
		if (module.equalsIgnoreCase("delete")) {
			responce = given().relaxedHTTPSValidation().body(TextData.payload)
					.queryParam("key", "qaclick123").when()
					.post(TextData.base_URL+"/maps/api/place/add/json")
					.then().extract().response();
			res = responce.asString();
			js = new JsonPath(res);
			placeId = js.getString("place_id");
			responce2 = given().spec(ReusableMethods.reqSpec).body(TextData.deletePayload(placeId))
					.when().delete(TextData.base_URL+"/maps/api/place/delete/json")
			.then().spec(ReusableMethods.resSpec).extract().response();
			JsonPath js2=new JsonPath(responce2.asString());
			String status1 = js2.getString("status");
			System.out.println(status1);
			Assert.assertEquals(js2.getString("status"), value);
		}
		
	}

	@Given("Verify {string} user should able to access the Query Parameters {string}")
	public void verify_user_should_able_to_access_the_query_parameters(String module, String qpValue) {
		if (module.equalsIgnoreCase("get")) {
			if (qpValue.equalsIgnoreCase("qaclick123")) {
				responce = given().log().all().relaxedHTTPSValidation().queryParam("key", qpValue)
						.queryParam("place_id", placeId).when()
						.get(TextData.base_URL+"/maps/api/place/get/json")
						.then().log().all().extract().response();
			}
			else if (qpValue.equalsIgnoreCase("qaclick444")) {
				responce = given().log().all().relaxedHTTPSValidation().queryParam("key", qpValue)
						.queryParam("place_id", placeId).when()
						.get(TextData.base_URL+"/maps/api/place/get/json")
						.then().log().all().extract().response();
			}
		}
		else if (module.equalsIgnoreCase("put")) {
			if (qpValue.equalsIgnoreCase("qaclick123")) {
				responce = given().log().all().relaxedHTTPSValidation().queryParam("key", qpValue)
						.body(TextData.putPayload(placeId, "78")).when()
						.put(TextData.base_URL+"/maps/api/place/update/json")
						.then().log().all().extract().response();
			}
			else if (qpValue.equalsIgnoreCase("qaclick444")) {
				responce = given().log().all().relaxedHTTPSValidation().queryParam("key", qpValue)
						.body(TextData.putPayload(placeId, "44")).when()
						.put(TextData.base_URL+"/maps/api/place/update/json")
						.then().log().all().extract().response();
			}
		}
		else if (module.equalsIgnoreCase("delete")) {
			if (qpValue.equalsIgnoreCase("qaclick123")) {
				responce = given().relaxedHTTPSValidation().body(TextData.payload)
						.queryParam("key", "qaclick123").when()
						.post(TextData.base_URL+"/maps/api/place/add/json")
						.then().extract().response();
				res = responce.asString();
				js = new JsonPath(res);
				placeId = js.getString("place_id");
				responce = given().log().all().relaxedHTTPSValidation().queryParam("key", qpValue)
						.body(TextData.deletePayload(placeId)).when()
						.delete(TextData.base_URL+"/maps/api/place/delete/json")
						.then().log().all().extract().response();
			}
			else if (qpValue.equalsIgnoreCase("qaclick444")) {
				responce = given().relaxedHTTPSValidation().body(TextData.payload)
						.queryParam("key", "qaclick123").when()
						.post(TextData.base_URL+"/maps/api/place/add/json")
						.then().extract().response();
				res = responce.asString();
				js = new JsonPath(res);
				placeId = js.getString("place_id");
				responce = given().log().all().relaxedHTTPSValidation().queryParam("key", qpValue)
						.body(TextData.deletePayload(placeId)).when()
						.delete(TextData.base_URL+"/maps/api/place/delete/json")
						.then().log().all().extract().response();
			}
		}
		
	}
	@Then("veriefy {string} user can get the details of location using placeId.")
	public void veriefy_user_can_get_the_details_of_location_using_place_id(String module) {
		responce = given().spec(ReusableMethods.reqSpec).queryParam("place_id", placeId)
				.when().get(TextData.base_URL+"/maps/api/place/get/json")
		.then().spec(ReusableMethods.resSpec).extract().response();
		
	}@Then("Verify {string} whether {string} is present in the response body")
	public void verify_whether_is_present_in_the_response_body(String module, String string) {
		if (module.equalsIgnoreCase("get")) {
			responce = given().spec(ReusableMethods.reqSpec).queryParam("place_id", placeId)
					.when().get(TextData.base_URL+"/maps/api/place/get/json")
			.then().spec(ReusableMethods.resSpec).extract().response();
			res = responce.asString();
			js = new JsonPath(res);
			js.getString("location");
			
		}
		else if (module.equalsIgnoreCase("put")) {
			responce = given().spec(ReusableMethods.reqSpec).body(TextData.putPayload(placeId, "734"))
					.when().put(TextData.base_URL+"/maps/api/place/update/json")
			.then().spec(ReusableMethods.resSpec).extract().response();
			res = responce.asString();
			js = new JsonPath(res);
			js.getString("msg");
			
		}
		else if (module.equalsIgnoreCase("delete")) {
			responce = given().relaxedHTTPSValidation().body(TextData.payload)
					.queryParam("key", "qaclick123").when()
					.post(TextData.base_URL+"/maps/api/place/add/json")
					.then().extract().response();
			res = responce.asString();
			js = new JsonPath(res);
			placeId = js.getString("place_id");
			responce = given().spec(ReusableMethods.reqSpec).body(TextData.deletePayload(placeId))
					.when().delete(TextData.base_URL+"/maps/api/place/delete/json")
			.then().spec(ReusableMethods.resSpec).extract().response();
			StringContains.containsString("status");
		}
		
	}

	@Given("Verify whether it accepts place ID in the parameter")
	public void verify_whether_it_accepts_place_id_in_the_parameter() {
		responce = given().spec(ReusableMethods.reqSpec).body(TextData.putPayload(placeId, "538"))
				.when().put(TextData.base_URL+"/maps/api/place/update/json")
		.then().spec(ReusableMethods.resSpec).extract().response();
	}
	@Then("Verify whether the updated payload is same as response body")
	public void verify_whether_the_updated_payload_is_same_as_response_body() {
		responce = given().spec(ReusableMethods.reqSpec).body(TextData.putPayload(placeId, "7234"))
				.when().put(TextData.base_URL+"/maps/api/place/update/json")
		.then().spec(ReusableMethods.resSpec).extract().response();
	}


}