package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage = new HomePage();
        loginPage = new LoginPage();

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessFully() {

        homePage.clickOnLoginLink();
        loginPage.verifyWelcomeText();

    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials() {
        homePage.clickOnLoginLink();
        loginPage.userDetail("prime123@gmail.com","prime123");
        loginPage.getErrorMessage();
    }
    @Test
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){

        homePage.clickOnLoginLink();
        loginPage.userDetail("kruti168@yahoo.com","Kanan@123");
        loginPage.verifyLogout();

    }@Test
    public void VerifyThatUserShouldLogOutSuccessFully(){
        homePage.clickOnLoginLink();
        loginPage.userDetail("kruti168@yahoo.com","Kanan@123");
        loginPage.clickOnLogoutLink();
        loginPage.verifyLoginLink();

    }

}