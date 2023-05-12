package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends Utility {

    public LoginPage(){

        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Welcome, Please Sign In!']")
    WebElement verifyWelcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;
    //By emailField = By.id("Email");

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    //By passwordField = By.name("Password");

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement verifyLogOut;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement clickOnLogOut;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement verifyLoginLink;


    public void verifyWelcomeText() {
        Reporter.log("Verify Text Welcome, Please Sign In!");
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = getTextFromElement(verifyWelcomeText);
        Assert.assertEquals(expectedMessage, actualMessage);
        CustomListeners.test.log(Status.PASS, "Verify Text Welcome, Please Sign In!");
    }

    public void userDetail(String email,String password)
    {
        Reporter.log("User Details");
        sendTextToElement(emailField, email);
        sendTextToElement(passwordField, password);
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"User Details");
    }

    public void clickOnLoginButton(){
        Reporter.log("Click on LoginButton");
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

    public void getErrorMessage()
    {
        Reporter.log("Get errorMessage");
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = getTextFromElement(errorMessage);
        Assert.assertEquals( expectedErrorMessage, actualErrorMessage,"Error message not displayed");
        CustomListeners.test.log(Status.PASS,"Get errorMessage");
    }
    public void verifyLogout(){
        Reporter.log("verify Logout");
        String expectedMessage = "Log out";
        String actualMessage = getTextFromElement(verifyLogOut);
        Assert.assertEquals(expectedMessage,actualMessage,"Verify Logout");
        CustomListeners.test.log(Status.PASS,"Verify Logout");
    }
    public void clickOnLogoutLink(){
        Reporter.log("Click On Logout");
        clickOnElement(clickOnLogOut);
        CustomListeners.test.log(Status.PASS,"Click on Logout");


    }public void verifyLoginLink(){
        Reporter.log("Verify Login Link");
        String expectedMessage = "Log in";
        String actualMessage = getTextFromElement(verifyLoginLink);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify LoginLink");
    }



    }


