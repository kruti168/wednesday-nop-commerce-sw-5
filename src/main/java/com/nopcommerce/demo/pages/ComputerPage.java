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

public class ComputerPage extends Utility {

    public ComputerPage(){

        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement verifyComputerText;

    @CacheLookup
    @FindBy(xpath ="//img[@title='Show products in category Desktops']")
    WebElement clickOnDeskTopLink;

    @CacheLookup
    @FindBy (xpath = "//h1[normalize-space()='Desktops']")
    WebElement verifyDesktop;

    public void verifyComputerText(){

        Reporter.log("Verify computer text");
        String expectedMessage = "Computers";
        String actualMessage = getTextFromElement(verifyComputerText);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify Computer Text");


    }public void setClickOnDeskTopLink(){

        Reporter.log("Click on DesktopLink");
        clickOnElement(clickOnDeskTopLink);
        CustomListeners.test.log(Status.PASS,"Click on DesktopLink");
    }
    public void verifyDesktopText(){

        Reporter.log("Verify Desktop Text");
        String expectedMessage = "Desktops";
        String actualMessage = getTextFromElement(verifyDesktop);
        Assert.assertEquals(expectedMessage,actualMessage);
        CustomListeners.test.log(Status.PASS,"Verify Desktop text");
    }
}
