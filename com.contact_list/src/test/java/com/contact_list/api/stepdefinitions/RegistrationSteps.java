package com.contact_list.api.stepdefinitions;

import com.contact_list.api.manager.RequestSpecificationManager;
import com.contact_list.api.model.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static com.contact_list.constants.ConstantsProvider.API_REGISTER_ENDPOINT;
import static io.restassured.RestAssured.given;

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
}
