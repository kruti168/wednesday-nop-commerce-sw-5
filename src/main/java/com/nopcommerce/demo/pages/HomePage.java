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

public class HomePage extends Utility {

    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement verifyRegisterLink ;

//    @CacheLookup
//    @FindBy(xpath = "//a[normalize-space()='Register']")
//    WebElement clickOnRegisterLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement clickOnComputer;


    public void clickOnLoginLink(){
        Reporter.log("Click On Login Link" + loginLink.toString());
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS,"Click on Login Link");
    }
    public void clickOnRegisterLink(){

        Reporter.log("Click On Register Link" + registerLink.toString());
        clickOnElement(registerLink);
        CustomListeners.test.log(Status.PASS,"Click On Register Link");
    }


    public void verifyRegisterLink(){

        Reporter.log("Verify RegisterLink");
        String expectedMessage = "Register";
        String actualMessage = getTextFromElement(verifyRegisterLink);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify RegisterLink");
    }
    public void clickOnComputer(){

        clickOnElement(clickOnComputer);
    }



}
