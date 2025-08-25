package com.contact_list.ui.stepdefinitions;

import com.contact_list.ui.pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.contact_list.constants.ConstantsProvider.CONTACT_LIST_ENDPOINT;
import static com.contact_list.ui.factories.WebDriverFactory.getThreadLocalDriver;
import static com.contact_list.constants.ConstantsProvider.LOG_IN_ENDPOINT;
import static org.testng.Assert.assertEquals;

public class LoginSteps {
    private WebDriver driver=getThreadLocalDriver();
    private LoginPage loginPage;
    @Given("User is at Login Page")
    public void userIsAtLoginPage() {
        // Write code here that turns the phrase above into concrete actions
        loginPage=new LoginPage(driver);
        loginPage.goToUrl(LOG_IN_ENDPOINT);
    }

    @When("User enters credentials {string} and {string}")
    public void userEntersCredentialsAnd(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLogin();
    }

    @Then("User is redirected to Contact List Dashboard page")
    public void userIsRedirectedToContactListDashboardPage() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.waitForUrl(CONTACT_LIST_ENDPOINT);
        assertEquals(driver.getCurrentUrl(),CONTACT_LIST_ENDPOINT);
    }
}
