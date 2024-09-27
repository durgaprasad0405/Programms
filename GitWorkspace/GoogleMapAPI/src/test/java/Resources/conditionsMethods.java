package Resources;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import Generic.APIServices;
import apiEngine.Route;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class conditionsMethods {

	
	public static String res;
	public static JsonPath js;
	public static String placeId;
	public static Response responce;
	
	public static void baseURLValidation(String module, String baseURL) {
		if (module.equalsIgnoreCase("post")) {
			if (baseURL.equalsIgnoreCase("https://rahulshettyacademy.com")) {
				responce = ReusableMethods.givenThen().given().when().post(baseURL+Route.post());
				System.out.println("Valied URL");
			}
			else {
				System.out.println("In-valied URL");
			}
		}
		else if (module.equalsIgnoreCase("get")) {
			if (baseURL.equalsIgnoreCase("https://rahulshettyacademy.com")) {
				responce = ReusableMethods.givenThen().when().get(baseURL+Route.get());
						System.out.println("Valied URL");
			}
			else {
				System.out.println("In-valied URL");
			}
		}
		else if (module.equalsIgnoreCase("put")) {
			if (baseURL.equalsIgnoreCase("https://rahulshettyacademy.com")) {
				responce = ReusableMethods.givenThen().when().put(baseURL+Route.put());
						System.out.println("Valied URL");
			}
			else {
				System.out.println("In-valied URL");
			}
		}
		else if (module.equalsIgnoreCase("delete")) {
			if (baseURL.equalsIgnoreCase("https://rahulshettyacademy.com")) {
				responce = ReusableMethods.givenThen().when().delete(baseURL+Route.delete());
						System.out.println("Valied URL");
			}
			else {
				System.out.println("In-valied URL");
			}
		}
	}
	
	public static void httpMethodsValidation(String module, String method, String place_id) {
	
		if (module.equalsIgnoreCase("post")) {
			if (method.equalsIgnoreCase("POST")) {
				responce = APIServices.postMethod(TextData.base_URL, TextData.qpValue, TextData.payload, Route.post());
			}
			else if (method.equalsIgnoreCase("GET")) {
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.payload)
						.when().get(TextData.base_URL+"/maps/api/place/add/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
		}
		else if (module.equalsIgnoreCase("get")) {
			if (method.equalsIgnoreCase("GET")) {
				responce = APIServices.getMethod(TextData.base_URL, TextData.qpValue, place_id, Route.get());
			}
			else if (method.equalsIgnoreCase("PUT")) {
				responce = given().spec(ReusableMethods.reqSpec).queryParam("place_id", place_id)
						.when().put(TextData.base_URL+"/maps/api/place/get/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
		}
		else if (module.equalsIgnoreCase("put")) {
			if (method.equalsIgnoreCase("PUT")) {
				responce = APIServices.putMethod(TextData.base_URL, TextData.qpValue, TextData.putPayload(place_id, "41"), Route.put());
			}
			else if (method.equalsIgnoreCase("GET")) {
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.putPayload(place_id, "672"))
						.when().get(TextData.base_URL+"/maps/api/place/update/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
		}
		else if (module.equalsIgnoreCase("delete")) {
			if (method.equalsIgnoreCase("DELETE")) {
				responce = ReusableMethods.deletePost();
				placeId = ReusableMethods.getJsonPath(responce, "place_id");
				responce = APIServices.deleteMethod(TextData.base_URL, TextData.qpValue, TextData.deletePayload(placeId), Route.delete());
			}
			else if (method.equalsIgnoreCase("PUT")) {
				responce = ReusableMethods.deletePost();
				placeId = ReusableMethods.getJsonPath(responce, "place_id");
				responce = given().spec(ReusableMethods.reqSpec).body(TextData.deletePayload(placeId))
						.when().put(TextData.base_URL+"/maps/api/place/delete/json")
				.then().spec(ReusableMethods.resSpec).extract().response();
			}
		}
	}
	public static void keyValidation(String module, String key, String place_id) {
		if (module.equalsIgnoreCase("get")) {
			responce = APIServices.getMethod(TextData.base_URL, TextData.qpValue, place_id, Route.get());
			if (responce.asString().contains(key)) {
				System.out.println(key+" is present in the response");
			}
			else {
				System.out.println(key+" is not present in the response");
			}
		}
		else if (module.equalsIgnoreCase("put")) {
			responce = APIServices.putMethod(TextData.base_URL, TextData.qpValue, TextData.putPayload(place_id, "734"), Route.put());
			if (responce.asString().contains(key)) {
				System.out.println(key+" is present in the response");
			}
			else {
				System.out.println(key+" is not present in the response");
			}
		}
		else if (module.equalsIgnoreCase("delete")) {
			responce = ReusableMethods.deletePost();
			placeId = ReusableMethods.getJsonPath(responce, "place_id");
			responce = APIServices.deleteMethod(TextData.base_URL, TextData.qpValue, TextData.deletePayload(placeId), Route.delete());
			if (responce.asString().contains(key)) {
				System.out.println(key+" is present in the response");
			}
			else {
				System.out.println(key+" is not present in the response");
			}
		}	
	}
	public static void valueValidation(String module, String value, String place_id) {
	
		if (module.equalsIgnoreCase("post")) {
			responce = APIServices.postMethod(TextData.base_URL, TextData.qpValue, TextData.payload, Route.post());
			String status = ReusableMethods.getJsonPath(responce, "status");
			Assert.assertEquals(status, value);
		}
		else if (module.equalsIgnoreCase("get")) {
			responce = APIServices.getMethod(TextData.base_URL, TextData.qpValue, place_id, Route.get());
			String acc = ReusableMethods.getJsonPath(responce, "accuracy");
			Assert.assertEquals(acc, value);
		}
		else if (module.equalsIgnoreCase("delete")) {
			responce = ReusableMethods.deletePost();
			placeId = ReusableMethods.getJsonPath(responce, "place_id");
			responce = APIServices.deleteMethod(TextData.base_URL, TextData.qpValue, TextData.deletePayload(placeId), Route.delete());
			String status = ReusableMethods.getJsonPath(responce, "status");
			Assert.assertEquals(status, value);
		}
	}
	public static void qpValidation(String module, String qpValue, String place_id) {
		
		if (module.equalsIgnoreCase("get")) {
			if (qpValue.equalsIgnoreCase("qaclick123")) {
				responce = APIServices.getMethod(TextData.base_URL, qpValue, place_id, Route.get());
			}
			else if (qpValue.equalsIgnoreCase("qaclick444")) {

//				responce = APIServices.getMethod(TextData.base_URL, qpValue, placeId, Route.get());
				System.out.println(qpValue+" It is an invalied Quary Parameter");
			}
		}
		else if (module.equalsIgnoreCase("put")) {
			if (qpValue.equalsIgnoreCase("qaclick123")) {
				responce = APIServices.putMethod(TextData.base_URL, qpValue, TextData.putPayload(place_id, "78"), Route.put());
			}
			else if (qpValue.equalsIgnoreCase("qaclick444")) {
				responce = APIServices.putMethod(TextData.base_URL, qpValue, TextData.putPayload(place_id, "44"), Route.put());
				System.out.println(qpValue+" It is an invalied Quary Parameter");
			}
		}
		else if (module.equalsIgnoreCase("delete")) {
			if (qpValue.equalsIgnoreCase("qaclick123")) {
				responce = ReusableMethods.deletePost();
				placeId = ReusableMethods.getJsonPath(responce, "place_id");
				responce = APIServices.deleteMethod(TextData.base_URL, qpValue, TextData.deletePayload(placeId), Route.delete());
			}
			else if (qpValue.equalsIgnoreCase("qaclick444")) {
				responce = ReusableMethods.deletePost();
				placeId = ReusableMethods.getJsonPath(responce, "place_id");
				responce = APIServices.deleteMethod(TextData.base_URL, qpValue, TextData.deletePayload(placeId), Route.delete());
				System.out.println(qpValue+" It is an invalied Quary Parameter");
			}
		}
		
	}
	public static void payloadValidation(String module, String baseURL) {
		if (module.equalsIgnoreCase("post")) {
			responce = APIServices.postMethod(TextData.base_URL, TextData.qpValue, TextData.payload, Route.post());
		}
		else if (module.equalsIgnoreCase("delete")) {
			responce = ReusableMethods.deletePost();
			placeId = ReusableMethods.getJsonPath(responce, "place_id");
			responce = APIServices.deleteMethod(TextData.base_URL, TextData.qpValue, TextData.deletePayload(placeId), Route.delete());
		}
	}
	
	
}
