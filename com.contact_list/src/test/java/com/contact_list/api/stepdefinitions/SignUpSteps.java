package com.contact_list.api.stepdefinitions;

import com.contact_list.api.manager.RequestSpecificationManager;
import com.contact_list.api.model.SignUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static com.contact_list.constants.ConstantsProvider.API_REGISTER_ENDPOINT;
import static com.contact_list.constants.ConstantsProvider.SIGN_UP_SCHEMA;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class SignUpSteps {
    private Response response;
    private RequestSpecification requestSpecification;
    @Given("User has request specifications for Sign Up")
    public void userHasEndpointForSignUp() {
        // Write code here that turns the phrase above into concrete actions
        requestSpecification=RequestSpecificationManager.getRequestSpecification();
    }
    @When("User sends a post request with First Name {string}, Last Name {string}, Email {string} and Password {string}")
    public void userSendsARequestWithFirstNameLastNameEmailAndPassword(String firstName, String lastName, String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        SignUp signUp =new SignUp.RegisterBuilder().withFirstName(firstName).withLastName(lastName).withEmail(email).withPassword(password).build();
        response=given().spec(requestSpecification).body(signUp).when().post(API_REGISTER_ENDPOINT);
    }

    @Then("User receives Success Response")
    public void userReceivesSuccessResponse() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @And("User Validates response for Correct Json Schema")
    public void userValidatesResponseForCorrectJsonSchema() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SIGN_UP_SCHEMA));
    }

    @Then("User receives Error Response")
    public void userReceivesErrorResponse() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @And("User receives {string} in response")
    public void userReceivesInResponse(String message) {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().body("message", containsString(message));
    }
}
