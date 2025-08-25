package com.contact_list.api.stepdefinitions;

import com.contact_list.api.model.SignIn;
import com.contact_list.api.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static com.contact_list.api.manager.RequestSpecificationManager.getRequestSpecification;
import static com.contact_list.constants.ConstantsProvider.SIGN_IN_ENDPOINT;
import static com.contact_list.constants.ConstantsProvider.SIGN_IN_SCHEMA;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SignInSteps {
    RequestSpecification requestSpecification;
    Response response;
    ObjectMapper objectMapper=new ObjectMapper();
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

    @And("User validates that the response received is of valid json format")
    public void userValidatesThatTheResponseReceivedIsOfValidJsonFormat() {
        // Write code here that turns the phrase above into concrete actions
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SIGN_IN_SCHEMA));
    }

    @And("User receives details of account in response {string}, {string} and {string}")
    public void userReceivesDetailsOfAccountInResponseAnd(String firstName, String lastName, String email) throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        User expectedUser = new User.UserBuilder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEmail(email)
                .build();
        String id = response.jsonPath().getString("user._id");
        String __v = response.jsonPath().getString("user.__v");
        expectedUser.set_id(id);
        expectedUser.set__v(__v);

        // Deserialize the actual User object from the response
        User[] users = objectMapper.readValue(response.jsonPath().getString("user"), User[].class);
        User actualUser = users[0];
        // Compare the actual and expected User objects
        MatcherAssert.assertThat(actualUser, equalToObject(expectedUser));
    }
}
