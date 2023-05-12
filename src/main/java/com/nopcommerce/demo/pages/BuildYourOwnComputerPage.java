package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {

    public  BuildYourOwnComputerPage()
    {
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement clickOnBuildYourOwnComputer;

    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_1']")
    WebElement selectProcessor;

    @CacheLookup
    @FindBy(xpath = "//select[@id='product_attribute_2']")
    WebElement selectRam;

    @CacheLookup
    @FindBy(xpath = "//input[@id='product_attribute_3_7']")
    WebElement selectHdd;

    @CacheLookup
    @FindBy(css = "#product_attribute_4_9")
    WebElement selectOs;

    @CacheLookup
    @FindBy(css = "#product_attribute_5_10")
    WebElement selectSoftwareMicrosoftOffice;

    @CacheLookup
    @FindBy(css = "label[for='product_attribute_5_12']")
    WebElement selectTotalCommander;

    @CacheLookup
    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    WebElement addToCart;


    public void clickONProductBuildYourOwnComputer()
    {
        Reporter.log("Click on product name Build your own computer");
        clickOnElement(clickOnBuildYourOwnComputer);
        CustomListeners.test.log(Status.PASS,"Click on product name Build your own computer");
    }


    public void buildYourOwnComputerSelection(String processor,String ram)throws InterruptedException
    {   Thread.sleep(5000);
        Reporter.log("Select processor processor and ram");
        selectByVisibleTextFromDropDown(selectProcessor, processor);
        selectByVisibleTextFromDropDown(selectRam,ram);
        clickOnElement(selectHdd);
        clickOnElement(selectOs);
        clickOnElement(selectSoftwareMicrosoftOffice);
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS,"Select processor processor and ram");

    }
}
