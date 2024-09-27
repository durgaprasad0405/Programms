package codeBeforeUsed;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.lang.reflect.Array;

import org.junit.Assert;

import Resources.Endpoints;
import Resources.TestDataBuilder;
import Resources.Utils;
import groovyjarjarantlr4.runtime.misc.IntArray;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepD1 {
	
	ResponseSpecification resSpec;
	RequestSpecification reqSpec, req;
	Response response;
	TestDataBuilder data = new TestDataBuilder();
	
	// Registration and Login

	@Given("{string} with {string} and {string}")
	public void register_with(String module, String email_name, String password_job) throws IOException {
		reqSpec= new RequestSpecBuilder().setBaseUri(Endpoints.base_url)
				.setContentType(ContentType.JSON).build();
//		req=given().spec(Utils.requestSpecification()).log().all()
//				.body(data.regAndLoginPayload(email_name, password_job));
		if (module.equalsIgnoreCase("Register")) {
			req=given().spec(reqSpec).log().all()
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

		if (method.equalsIgnoreCase("POST")) {
			if(module.equalsIgnoreCase("Register")) {
				response=req.when().post(Endpoints.post_reg);
			}
			else if(module.equalsIgnoreCase("Login")) {
				response=req.when().post(Endpoints.post_login);
			}
			else if(module.equalsIgnoreCase("Create_User")) {
				response=req.when().post(Endpoints.post_user);
			}
		}
		else if (method.equalsIgnoreCase("GET")) {
			if(module.equalsIgnoreCase("Get_User")) {
				response=req.when().get(Endpoints.get_user_by_id);
			}
			else if(module.equalsIgnoreCase("Get_User_page")) {
				response=req.when().get(Endpoints.get_user_by_page);
			}
//			else if(module.equalsIgnoreCase("Create_User")) {
//				response=req.when().get(Endpoints.post_user);
//			}
		}
		else if (method.equalsIgnoreCase("PUT")) {
			if(module.equalsIgnoreCase("Update_User")) {
				response=req.when().put(Endpoints.put_user);
			}
		}
		else if (method.equalsIgnoreCase("PATCH")) {
			if(module.equalsIgnoreCase("Update_User_Patch")) {
				response=req.when().patch(Endpoints.patch_user);
			}
		}
		else if (method.equalsIgnoreCase("DELETE")) {
			if(module.equalsIgnoreCase("delete_user")) {
				response=req.when().delete(Endpoints.delete_user);
			}
		}
	}
	
	@Then("The API calls get success with status code {int}")
	public void the_api_calls_get_success_with_status_code(Integer status) throws IOException {
		

		
		if (status.equals(200)) {
			response.then().spec(Utils.responceSpecification()).log().all()
			.assertThat().statusCode(200).extract().response().asString();
		}
		else if(status.equals(400)) {
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