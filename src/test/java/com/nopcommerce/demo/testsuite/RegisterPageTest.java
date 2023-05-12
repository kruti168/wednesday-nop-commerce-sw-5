package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();

    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        homePage.clickOnRegisterLink();
        homePage.verifyRegisterLink();
    }

    @Test
    public void verifyThatFirstNameLastNameEmailOasswordAndConfirmPasswordFieldsAreMandetory() {


        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        registerPage.verifyFirstNameRequired();
        registerPage.verifyLastNameRequired();
        registerPage.verifyEmailRequired();
        registerPage.verifyPasswordRequired();
        registerPage.verifyConfirmedPasswordRequired();


    }

    @Test
    public void VerifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnFemaleBox();
        registerPage.fillingTheDetails("Prime", "Testing", "26", "August", "1984",
                "kruti12" +getAlphaNumericString(4)+"@gmail.com", "Mv12345", "Mv12345");
        registerPage.clickOnRegisterButton();
        registerPage.verifyYourRegistrationCompletedText();
    }
}