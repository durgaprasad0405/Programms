package apiEngine;

import org.apache.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndPoints {

    private final RequestSpecification request;

    public EndPoints(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given().log().all();
        request.header("Content-Type", "application/json");
    }

//    public void authenticateUser(AuthorizationRequest authRequest) {
//        Response response = request.body(authRequest).post(Route.generateToken());
//        response.then().log().all();
//        if (response.statusCode() != HttpStatus.SC_OK)
//            throw new RuntimeException("Authentication Failed. Content of failed Response: " + response.toString() + " , Status Code : " + response.statusCode());
//
//        Token tokenResponse = response.body().jsonPath().getObject("$", Token.class);
//        request.header("Authorization", "Bearer " + tokenResponse.token);
//    }
//
//    public IRestResponse<Books> getBooks() {
//        Response response = request.get(Route.books());
//        response.then().log().all();
//        return new RestResponse<Books>(Books.class, response);
//    }
//
//    public IRestResponse<UserAccount> addBook(AddBooksRequest addBooksRequest) {
//        Response response = request.body(addBooksRequest).post(Route.books());
//        response.then().log().all();
//        return new RestResponse<UserAccount>(UserAccount.class, response);
//    }
//
//    public Response removeBook(RemoveBookRequest removeBookRequest) {
//    	request.then().log().all();
//        return request.body(removeBookRequest).delete(Route.book());
//    }
//
//    public IRestResponse<UserAccount> getUserAccount(String userId) {
//        Response response = request.get(Route.userAccount(userId));
//        response.then().log().all();
//        return new RestResponse<UserAccount>(UserAccount.class, response);
//    }

}