package com.contact_list.api.stepdefinitions;

import com.contact_list.api.model.SignIn;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import static com.contact_list.api.manager.RequestSpecificationManager.getRequestSpecification;
import static com.contact_list.constants.ConstantsProvider.SIGN_IN_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class SignInSteps {
    RequestSpecification requestSpecification;
    Response response;
    @Given("User has request specifications ready for Sign")
    public void userHasRequestSpecificationsReadyForSign() {
        // Write code here that turns the phrase above into concrete actions
        requestSpecification=getRequestSpecification();
    }

    @When("User sends a post request to Sign In endpoint with credentials {string} and {string}")
    public void userSendsAPostRequestToSignInEndpointWithCredentialsAnd(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        SignIn signIn=new SignIn.SignInBuilder().withEmail(email).withPassword(password).build();
        response=given().spec(requestSpecification).body(signIn).when().post(SIGN_IN_ENDPOINT);
    }

    @Then("User receives OK response")
    public void userReceivesOKResponse() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @And("User receives a token in response body")
    public void userReceivesATokenInResponseBody() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().body("token", notNullValue());
    }
}
