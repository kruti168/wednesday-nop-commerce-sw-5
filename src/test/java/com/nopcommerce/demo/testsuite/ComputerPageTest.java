package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.*;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {


    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage = new HomePage();
        loginPage = new LoginPage();
        computerPage = new ComputerPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }@Test
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){

        homePage.clickOnComputer();
        computerPage.verifyComputerText();
    }@Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

        homePage.clickOnComputer();
        computerPage.setClickOnDeskTopLink();
        computerPage.verifyDesktopText();

    }
    @Test(dataProvider = "Build your own Computer",dataProviderClass = TestData.class)
    public  void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully (String processor, String ram, String hdd, String os, String software)throws InterruptedException
    {
        homePage.clickOnComputer();
        computerPage.setClickOnDeskTopLink();
        buildYourOwnComputerPage.clickONProductBuildYourOwnComputer();
        buildYourOwnComputerPage.buildYourOwnComputerSelection(processor,ram);
    }
}