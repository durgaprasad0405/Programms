package stepDefinitions;

import apiEngine.EndPoints;
import apiEngine.IRestResponse;
import apiEngine.model.*;
import apiEngine.model.requests.*;
import apiEngine.model.responses.*;
import org.junit.Assert;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

public class Steps {

    private final String USER_ID = "a3531a65-12f1-4f7a-8de0-ffba29dce321";    
    private Response response;
    private IRestResponse<UserAccount> userAccountResponse;
    private Book book;
    private final String BaseUrl = "https://bookstore.toolsqa.com";
    private EndPoints endPoints;
    
    @Given("^I am an authorized user$")
    public void iAmAnAuthorizedUser() {
    	endPoints = new EndPoints(BaseUrl);
    	AuthorizationRequest authRequest = new AuthorizationRequest("kakaa", "Kakaa@12");
    	endPoints.authenticateUser(authRequest);
    }

    @Given("^A list of books are available$")
    public void listOfBooksAreAvailable() {   	    	
    	IRestResponse<Books> booksResponse = endPoints.getBooks();
    	book = booksResponse.getBody().books.get(0);
    }

    @When("^I add a book to my reading list$")
    public void addBookInList() {
    	
        ISBN isbn = new ISBN(book.isbn);
        AddBooksRequest addBooksRequest = new AddBooksRequest(USER_ID, isbn);
        userAccountResponse = endPoints.addBook(addBooksRequest);
    }

    @Then("^The book is added$")
    public void bookIsAdded() {
        
    	Assert.assertTrue(userAccountResponse.isSuccessful());
        Assert.assertEquals(201, userAccountResponse.getStatusCode());

//        Assert.assertEquals(USER_ID, userAccountResponse.getBody().userId);
        Assert.assertEquals(book.isbn, userAccountResponse.getBody().books.get(0).isbn);
    }

    @When("^I remove a book from my reading list$")
    public void removeBookFromList() {

        RemoveBookRequest removeBookRequest = new RemoveBookRequest(USER_ID, book.isbn);
        response = endPoints.removeBook(removeBookRequest);
    }

    @Then("^The book is removed$")
    public void bookIsRemoved() {
    	
        Assert.assertEquals(204, response.getStatusCode());

        userAccountResponse = endPoints.getUserAccount(USER_ID);
        Assert.assertEquals(200, userAccountResponse.getStatusCode());
        
        Assert.assertEquals(0, userAccountResponse.getBody().books.size());
    }

}