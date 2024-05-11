package com.tutorialsNinja.TestCases;

import com.TutorialsNinja.Utilities.Util;
import com.tutorialsNinja.Pages.AccountPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.LoginPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.ExcelCode;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {



    public LoginTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homepage;
    public AccountPage accountPage;

    @BeforeMethod
    public void loginSetup() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        homepage = new HomePage(driver);
        loginPage = homepage.combiningTwoActionsToNavigateToLoginPage();
//        homepage.clickOnMyAccount();
//        loginPage = homepage.selectLoginOption();


    }

    @Test(priority = 1, dataProvider = "TNLogin", dataProviderClass = ExcelCode.class)
    public void loginWithValidCredentials(String email, String password) {

//        loginPage.enterEmail(email);
//        loginPage.enterPassword(password);
//        loginPage.clickOnLoginButton();
        accountPage = loginPage.navigateToLoginPageByCombining3Actions(email, password);
        accountPage.validateDisplayStatusOfLogoutLink();
    }

    @Test(priority = 2)
    public void loginWithValidEmailInvalidPassword() {

//        loginPage.enterEmail(prop.getProperty("validEmail"));
//        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//        loginPage.clickOnLoginButton();
        loginPage.navigateToLoginPageByCombining3Actions(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
//        String actualWarningMessage = loginPage.retrieveLoginMessageWarningText();
//        String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
        Assert.assertTrue(loginPage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
    }

    @Test(priority = 3)
    public void loginWithInvalidEmailValidPassword() {

        loginPage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
        Assert.assertTrue(loginPage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
//        loginPage.enterEmail(Util.emailWithDateTimeStamp());
//        loginPage.enterPassword(prop.getProperty("validPassword"));
//        loginPage.clickOnLoginButton();
//        String actualWarningMessage = loginPage.retrieveLoginMessageWarningText();
//        String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @Test(priority = 4)
    public void loginWithInvalidCredentials() {

        loginPage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
//        loginPage.enterEmail(Util.emailWithDateTimeStamp());
//        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//        loginPage.clickOnLoginButton();
//        String actualWarningMessage = loginPage.retrieveLoginMessageWarningText();
//        String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @Test(priority = 5)
    public void loginWithNoCredentials() {

        loginPage.navigateToLoginPageByCombining3Actions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
//        loginPage.clickOnLoginButton();
//        String actualWarningMessage = loginPage.retrieveLoginMessageWarningText();
//        String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
