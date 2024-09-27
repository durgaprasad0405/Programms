package StepDefination;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.junit.Assert;

import Resources.APIResource;
import Resources.Endpoints;
import Resources.TestDataBuilder;
import Resources.Utils;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination2 {
	
	ResponseSpecification resSpec;
	RequestSpecification reqSpec, req;
	Response response;
	TestDataBuilder data = new TestDataBuilder();
	
	// Registration and Login

	@Given("{string} with {string} and {string}")
	public void register_with(String module, String email_name, String password_job) throws IOException {
//		reqSpec= new RequestSpecBuilder().setBaseUri(Endpoints.base_url)
//				.setContentType(ContentType.JSON).build();
//		req=given().spec(Utils.requestSpecification()).log().all()
//				.body(data.regAndLoginPayload(email_name, password_job));
		if (module.equalsIgnoreCase("Register")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.body(data.regAndLoginPayload(email_name, password_job));
		}
		else if (module.equalsIgnoreCase("Login")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.body(data.regAndLoginPayload(email_name, password_job));
		}
		else if (module.equalsIgnoreCase("Create_User")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.body(data.createUserPayload(email_name, password_job));
		}
	}
	
	@Given("{string} details by using {int}")
	public void details_by_using_id(String module, Integer id_page) throws IOException {
		if (module.equalsIgnoreCase("Get_User")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.pathParam("id", id_page);
		}
		else if (module.equalsIgnoreCase("Get_User_page")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.queryParam("page", id_page);
		}
		else if (module.equalsIgnoreCase("delete_user")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.pathParam("id", id_page);
		}
	}
	
	@Given("{string} the {string} and {string} using {int}")
	public void the_and_using(String module, String name, String job, Integer id) throws IOException {
		if (module.equalsIgnoreCase("Update_User")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.pathParam("id", id)
					.body(data.regAndLoginPayload(name, job));
		}
		else if (module.equalsIgnoreCase("Update_User_Patch")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.pathParam("id", id)
					.body(data.regAndLoginPayload(name, job));
		}
	}
	
	@When("User calls {string} With {string} method")
	public void user_calls_with_method(String module, String method) {
//		resSpec= new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
//		response=req.when().post(Endpoints.post_reg);
		
		APIResource resource = APIResource.valueOf(method);
		if (method.equalsIgnoreCase("POST")) {
			response = req.when().post(resource.getResource());
		}
		else if (method.equalsIgnoreCase("GET")) {
			response = req.when().get(resource.getResource());
		}
		else if (method.equalsIgnoreCase("PUT")) {
			response = req.when().put(resource.getResource());
		}
		else if (method.equalsIgnoreCase("PATCH")) {
			response = req.when().patch(resource.getResource());
		}
		else if (method.equalsIgnoreCase("DELETE")) {
			response = req.when().delete(resource.getResource());
		}

	}
	
	@Then("The API calls get success with status code {string}")
	public void the_api_calls_get_success_with_status_code(String status) throws IOException {
		if (status.equalsIgnoreCase("200")) {
			response.then().spec(Utils.responceSpecification()).log().all()
			.assertThat().statusCode(200).extract().response().asString();
		}
		else if(status.equalsIgnoreCase("400")) {
			Assert.assertEquals(response.getStatusCode(), 400);
		}
		else if(status.equalsIgnoreCase("201")) {
			Assert.assertEquals(response.getStatusCode(), 201);
		}
		else if(status.equalsIgnoreCase("204")) {
			Assert.assertEquals(response.getStatusCode(), 204);
		}
	}
}