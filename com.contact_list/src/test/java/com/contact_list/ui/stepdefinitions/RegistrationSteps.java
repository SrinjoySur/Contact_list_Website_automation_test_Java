package com.contact_list.ui.stepdefinitions;

import com.contact_list.ui.pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


import static com.contact_list.constants.ConstantsProvider.CONTACT_LIST_ENDPOINT;
import static com.contact_list.constants.ConstantsProvider.SIGN_UP_ENDPOINT;

import static com.contact_list.ui.factories.WebDriverFactory.getThreadLocalDriver;
import static org.testng.Assert.assertEquals;

public class RegistrationSteps {
    private WebDriver driver=getThreadLocalDriver();
    private RegistrationPage registrationPage;
    @Given("User is at Registration Page")
    public void userIsAtRegistrationPage() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage =new RegistrationPage(driver);
        registrationPage.goToUrl(SIGN_UP_ENDPOINT);
        System.out.println(driver.getCurrentUrl());
    }

    @When("User enters First Name {string} and Last Name {string}")
    public void userEntersFirstNameAndLastName(String firstName, String lastName) {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        
    }

    @And("User enters Email {string} and Password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        
    }

    @And("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.clickSubmit();
        
    }

    @Then("User is redirected to Contact List page")
    public void userIsRedirectedToContactListPage() {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.waitUntilUrlToBe(CONTACT_LIST_ENDPOINT);
        assertEquals(driver.getCurrentUrl(),CONTACT_LIST_ENDPOINT);
        
    }
}
