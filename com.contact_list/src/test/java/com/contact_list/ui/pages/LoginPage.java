package com.contact_list.ui.pages;

import com.contact_list.ui.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import static com.contact_list.utils.WebDriverUtils.click;
import static com.contact_list.utils.WebDriverUtils.sendKeys;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    private final By emailTxt=By.id("email");
    private final By passwordTxt=By.id("password");
    private final By loginBtn=By.id("submit");
    private final By error=By.id("error");
    private final By signUpBtn=By.id("signup");
    private final Wait<WebDriver> wait=getWebDriverWait(100);
    public void enterEmail(String email){
        WebElement element=driver.findElement(emailTxt);
        sendKeys(element,email);
    }
    public void enterPassword(String password){
        WebElement element=driver.findElement(passwordTxt);
        sendKeys(element,password);
    }
    public void clickLogin(){
        WebElement element= driver.findElement(loginBtn);
        click(element);
    }
    public String getError(){
        WebElement element=driver.findElement(error);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    public void clickSignUp(){
        WebElement element=driver.findElement(signUpBtn);
        click(element);
    }
    public void waitForUrl(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
