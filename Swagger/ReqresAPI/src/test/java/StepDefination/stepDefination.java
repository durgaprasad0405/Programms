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

public class stepDefination {
	
	ResponseSpecification resSpec;
	RequestSpecification reqSpec, req;
	Response response;
	TestDataBuilder data = new TestDataBuilder();
	
	// Registration and Login

	@Given("{string} with {string} and {string}")
	public void register_with(String module, String email_name, String password_job) throws IOException {
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
			req=given().spec(Utils.requestSpecification()).log().all().pathParam("id", id_page);
		}
		else if (module.equalsIgnoreCase("Get_User_page")) {
			req=given().spec(Utils.requestSpecification()).log().all().queryParam("page", id_page);
		}
		else if (module.equalsIgnoreCase("delete_user")) {
			req=given().spec(Utils.requestSpecification()).log().all().pathParam("id", id_page);
		}
	}
	
	@Given("{string} the {string} and {string} using {int}")
	public void the_and_using(String module, String name, String job, Integer id) throws IOException {
		if (module.equalsIgnoreCase("Update_User")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.pathParam("id", id).body(data.regAndLoginPayload(name, job));
		}
		else if (module.equalsIgnoreCase("Update_User_Patch")) {
			req=given().spec(Utils.requestSpecification()).log().all()
					.pathParam("id", id).body(data.regAndLoginPayload(name, job));
		}
	}
	
	@When("User calls {string} With {string} method")
	public void user_calls_with_method(String resource, String method) {
		
//		APIResource resourceAPI = APIResource.valueOf(resource);
//		System.out.println(resourceAPI.getResource());
//		if(method.equalsIgnoreCase("POST"))
//			response = req.when().post(resourceAPI.getResource());
//		else if (method.equalsIgnoreCase("GET"))
//			response = req.when().get(resourceAPI.getResource());
		
		String[] stringMethod = new String[] {"POST","GET","PUT","PATCH","DELETE"};
		for (int i=0;i<stringMethod.length;i++) {
			if (method.equalsIgnoreCase(stringMethod[i])) {
				if(resource.equalsIgnoreCase("Register")) {
					response=req.when().post(Endpoints.post_reg);
				}
				else if(resource.equalsIgnoreCase("Login")) {
					response=req.when().post(Endpoints.post_login);
				}
				else if(resource.equalsIgnoreCase("Create_User")) {
					response=req.when().post(Endpoints.post_user);
				}
				else if(resource.equalsIgnoreCase("Get_User")) {
					response=req.when().get(Endpoints.get_user_by_id);
				}
				else if(resource.equalsIgnoreCase("Get_User_page")) {
					response=req.when().get(Endpoints.get_user_by_page);
				}
				else if(resource.equalsIgnoreCase("Update_User")) {
					response=req.when().put(Endpoints.put_user);
				}
				else if(resource.equalsIgnoreCase("Update_User_Patch")) {
					response=req.when().patch(Endpoints.patch_user);
				}
				else if(resource.equalsIgnoreCase("delete_user")) {
					response=req.when().delete(Endpoints.delete_user);
				}
			}
		}
	}
	
	@Then("The API calls get success with status code {int}")
	public void the_api_calls_get_success_with_status_code(Integer status) throws IOException {
		int[] code = new int[] {200,201,400};
		for (int i=0; i<code.length; i++) {
			if (status.equals(code[i])) {
				response.then().spec(Utils.responceSpecification()).log().all().extract().response().asString();
				Assert.assertEquals(response.getStatusCode(), code[i]);			
			}
			else if (status.equals(204)) {
				Assert.assertEquals(response.getStatusCode(), 204);	
			}
		}
		
	}
}