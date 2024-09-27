package stepsDefinitions;

import apiEngine.model.requests.*;
import cucumber.TestContext;
import io.cucumber.java.en.*;

public class AccountSteps extends BaseStep {

    public AccountSteps(TestContext testContext){
    	super(testContext);
    }

    @Given("^I am an authorized user$")
    public void iAmAnAuthorizedUser() {
        AuthorizationRequest authRequest = new AuthorizationRequest("kakaa", "Kakaa@12");
        getEndPoints().authenticateUser(authRequest);
    }

}