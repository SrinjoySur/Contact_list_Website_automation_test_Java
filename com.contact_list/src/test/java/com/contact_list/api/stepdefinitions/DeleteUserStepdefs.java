package com.contact_list.api.stepdefinitions;

import static com.contact_list.api.util.CommonUtils.generateAuthToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static com.contact_list.api.manager.RequestSpecificationManager.getAuthenticatedRequestSpecification;
import static com.contact_list.constants.ConstantsProvider.DELETE_USER_ENDPOINT;
import static io.restassured.RestAssured.given;

public class DeleteUserStepdefs {
    private Response response;
    private RequestSpecification requestSpecification;
    @Given("User has token for Authentication of user with credentials {string} and {string}")
    public void userHasTokenForAuthenticationOfUserWithCredentialsAnd(String email,String password) {
        // Write code here that turns the phrase above into concrete actions
        String token=generateAuthToken(email,password);
        requestSpecification=getAuthenticatedRequestSpecification(token);
    }

    @When("User sends a delete request")
    public void userSendsADeleteRequest() {
        // Write code here that turns the phrase above into concrete actions
        response=given().spec(requestSpecification).when().delete(DELETE_USER_ENDPOINT);
    }

    @Then("User should receive OK response")
    public void userShouldReceiveOKResponse() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }
}
