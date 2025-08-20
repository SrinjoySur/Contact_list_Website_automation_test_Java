package com.contact_list.api.stepdefinitions;

import com.contact_list.api.manager.RequestSpecificationManager;
import com.contact_list.api.model.Register;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import static com.contact_list.constants.ConstantsProvider.API_REGISTER_ENDPOINT;
import static com.contact_list.constants.ConstantsProvider.REGISTER_SCHEMA;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class RegistrationSteps {
    private Response response;
    private RequestSpecification requestSpecification;
    @Given("User has request specifications for Registration")
    public void userHasEndpointForRegistration() {
        // Write code here that turns the phrase above into concrete actions
        requestSpecification=RequestSpecificationManager.getRequestSpecification();
    }
    @When("User sends a post request with First Name {string}, Last Name {string}, Email {string} and Password {string}")
    public void userSendsARequestWithFirstNameLastNameEmailAndPassword(String firstName, String lastName, String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        Register register=new Register.RegisterBuilder().withFirstName(firstName).withLastName(lastName).withEmail(email).withPassword(password).build();
        response=given().spec(requestSpecification).body(register).when().post(API_REGISTER_ENDPOINT);
    }

    @Then("User receives Success Response")
    public void userReceivesSuccessResponse() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    @And("User Validates response for Correct Json Schema")
    public void userValidatesResponseForCorrectJsonSchema() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(REGISTER_SCHEMA));
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
