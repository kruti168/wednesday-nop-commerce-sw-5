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

public class RegisterPage extends Utility {

    public RegisterPage(){

        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement clickOnRegisterButton;

    @CacheLookup
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement verifyMessageFirstName ;

    @CacheLookup
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement  verifyLastName;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement verifyEmail;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Password-error']")
     WebElement verifyPassword;

    @CacheLookup
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement verifyConfirmedPassword;
    @CacheLookup

    @FindBy(xpath = "//input[@id='gender-female']")
    WebElement genderFemale;

    @CacheLookup
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dayDropDown;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement monthDropDown;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement yearDropDown;


    @CacheLookup
    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy (xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement verifyRegisterText;

    public void clickOnRegisterButton(){
        Reporter.log("Click On Register Button");
        clickOnElement(clickOnRegisterButton);
        CustomListeners.test.log(Status.PASS,"Click On Register Button");
    }
    public void verifyFirstNameRequired(){
        Reporter.log("Verify First Name Required");
        String expectedMessage = "First name is required.";
        String actualMessage = getTextFromElement(verifyMessageFirstName);
        Assert.assertEquals(expectedMessage,actualMessage,"No First Name required");
        CustomListeners.test.log(Status.PASS,"Verify First Name Required");

    }public void verifyLastNameRequired(){
        Reporter.log("Verify Last Name Required");
        String expectedMessage = "Last name is required.";
        String actualMessage = getTextFromElement(verifyLastName);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify LastName");

    }public void verifyEmailRequired(){
        Reporter.log("Verify Email Required");
        String expectedMessage = "Email is required.";
        String actualMessage = getTextFromElement(verifyEmail);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify Email");

    }public void verifyPasswordRequired(){
        Reporter.log("Verify Password Required");
        String expectedMessage = "Password is required.";
        String actualMessage = getTextFromElement(verifyPassword);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify Password");

    }public void verifyConfirmedPasswordRequired(){
        Reporter.log("Verify Confirmed Password Required");
        String expectedMessage = "Password is required.";
        String actualMessage = getTextFromElement(verifyConfirmedPassword);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify Confirm Password");

    }public void fillingTheDetails(String firstName,String lastName, String day, String month, String year, String email,String password, String confirmPassword){
        sendTextToElement(firstNameField,firstName);
        sendTextToElement(lastNameField,lastName);
        selectByVisibleTextFromDropDown(dayDropDown,day);
        selectByVisibleTextFromDropDown(monthDropDown,month);
        selectByVisibleTextFromDropDown(yearDropDown,year);
        sendTextToElement(emailField,email);
        sendTextToElement(passwordField,password);
        sendTextToElement(confirmPasswordField,confirmPassword);
    }
    public void clickOnFemaleBox(){
        Reporter.log("Click Into Female Box");
        clickOnElement(genderFemale);
        CustomListeners.test.log(Status.PASS, "Click Into Female Box");
    }
    public void verifyYourRegistrationCompletedText(){

        Reporter.log("Verify Your registration completed ");
        String expectedMessage = "Your registration completed";
        String actualMessage = getTextFromElement(verifyRegisterText);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"verify Your Registration completed");
    }

}
