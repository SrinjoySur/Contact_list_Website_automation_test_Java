package com.contact_list.ui.pages;

import com.contact_list.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.contact_list.utils.WebDriverUtils.*;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver){
        super(driver);
    }
    private final By  firstNameTxtArea=By.id("firstName");
    private final By  lastNameTxtArea=By.id("lastName");
    private final By  emailTxtArea=By.id("email");
    private final By  passwordTxtArea=By.id("password");
    public final By submitBtn=By.id("submit");
    public final By error=By.id("error");
    public final By cancelBtn=By.id("cancel");
    public void enterFirstName(String firstName){
        WebElement element=driver.findElement(firstNameTxtArea);
        sendKeys(element,firstName);
    }
    public void enterLastName(String lastName){
        WebElement element=driver.findElement(lastNameTxtArea);
        sendKeys(element,lastName);
    }
    public void enterEmail(String email){
        WebElement element=driver.findElement(emailTxtArea);
        sendKeys(element,email);
    }
    public void enterPassword(String password){
        WebElement element=driver.findElement(passwordTxtArea);
        sendKeys(element,password);
    }
    public void clickSubmit(){
        WebElement element=driver.findElement(submitBtn);
        click(element);
    }
    public String getError(){
        WebElement element=driver.findElement(error);
        waitForVisibility(getWebDriverWait(100),element);
        return getText(element);
    }
}
