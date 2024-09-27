package stepdef;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import Generic.APIServices;
import Resources.ReusableMethods;
import Resources.TextData;
import Resources.conditionsMethods;
import apiEngine.Route;
public class Steps {
	
	Response responce;
	Response responce1;
	Response responce2;
	String res;
	JsonPath js;
	public static String placeId;
	
	@Given("Verify {string} user should able to access the {string}")
	public void verify_user_should_able_to_access_the(String module, String baseURL) {
		
		conditionsMethods.baseURLValidation(module, baseURL);	
	}
	@Given("Verify {string} user should able to accept the Payload")
	public void verify_user_should_able_to_accept_the_payload(String module) {
		
		conditionsMethods.payloadValidation(module, module);	
	}
	@Given("Verify {string} user should able to text the {string}")
	public void verify_user_should_able_to_text_the(String module, String phoneNumber) {
		
		responce = APIServices.postMethod(TextData.base_URL, TextData.qpValue, TextData.payload(phoneNumber), Route.post());		
	}
	@Given("Verify {string} whether its accepting location key and value")
	public void verify_whether_its_accepting_location_key_and_value(String module) {
		
		responce  = APIServices.postMethod(TextData.base_URL, TextData.qpValue, TextData.payload, Route.post());		
	}
	@When("Verify {string} user should able to access the post {string}")
	public void verify_user_should_able_to_access_the_post(String module, String method) {
		
		conditionsMethods.httpMethodsValidation(module, method, placeId);
	}
	@Then("Verify {string} place_id is generated")
	public void verify_place_id_is_generated(String module) {
		
		responce = APIServices.postMethod(TextData.base_URL, TextData.qpValue, TextData.payload, Route.post());
		placeId = ReusableMethods.getJsonPath(responce, "place_id");
		System.out.println(placeId);	
	}
	@Then("Verify {string} status is {string}")
	public void verify_status_is(String module, String value) {
		
		conditionsMethods.valueValidation(module, value, placeId);
	}
	@Given("Verify {string} user should able to access the Query Parameters {string}")
	public void verify_user_should_able_to_access_the_query_parameters(String module, String qpValue) {
		
		conditionsMethods.qpValidation(module, qpValue, placeId);	
	}
	@Then("veriefy {string} user can get the details of location using placeId.")
	public void veriefy_user_can_get_the_details_of_location_using_place_id(String module) {
		
		responce = APIServices.getMethod(TextData.base_URL, TextData.qpValue, placeId, Route.get());	
	}
	@Then("Verify {string} whether {string} is present in the response body")
	public void verify_whether_is_present_in_the_response_body(String module, String key) {
		
		conditionsMethods.keyValidation(module, key, placeId);
	}
	@Given("Verify whether it accepts place ID in the parameter")
	public void verify_whether_it_accepts_place_id_in_the_parameter() {
		
		responce = APIServices.putMethod(TextData.base_URL, TextData.qpValue, TextData.putPayload(placeId, "538"), Route.put());	
	}
	@Then("Verify whether the updated payload is same as response body")
	public void verify_whether_the_updated_payload_is_same_as_response_body() {
		
		responce = APIServices.putMethod(TextData.base_URL, TextData.qpValue, TextData.putPayload(placeId, "7234"), Route.put());	
	}
}