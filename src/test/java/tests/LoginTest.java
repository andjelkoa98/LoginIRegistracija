package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    LoginPage loginPage;

    @Test(description = "Verifying login with expected color", groups = "smoke")
    public void loginFirstTest() {

        loginPage = new LoginPage(driver);
        loginPage.runLoginTest();
        Assert.assertTrue(loginPage.checkColor());
    }

    @Test(description = "Verifying login with expected text")
    public void loginSecondTest(){

        loginPage = new LoginPage(driver);
        loginPage.runLoginTest();
        Assert.assertTrue(loginPage.checkText());

    }









}
