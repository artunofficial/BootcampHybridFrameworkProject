package com.tutorialsNinja.TestCases;

import com.TutorialsNinja.Utilities.Util;
import com.tutorialsNinja.Pages.AccountSuccessPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.RegisterPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.ExcelCode;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {



    public RegisterTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public RegisterPage registerPage;
    public HomePage homePage;
    public AccountSuccessPage accountSuccessPage;

    @BeforeMethod
    public void registerSetup() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        homePage = new HomePage(driver);
        registerPage = homePage.combiningTwoActionsToNavigateToRegisterPage();
//        homePage.clickOnMyAccount();
//        homePage.selectRegisterOption();
    }


    @Test(priority = 1, dataProvider = "TNRegister", dataProviderClass = ExcelCode.class)
    public void verifyRegisterWithMandatoryDetails(String firstname, String lastname, String telephone, String password, String confirmpassword) {

        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(firstname, lastname, Util.emailWithDateTimeStamp(), telephone, password, confirmpassword);
        Assert.assertTrue(accountSuccessPage.accountSuccessAlert());
    }

    @Test(priority = 2)
    public void verifyRegisterWithAllDetails() {
        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
        Assert.assertTrue(accountSuccessPage.accountSuccessAlert());
    }

    @Test(priority = 3)
    public void verifyRegisterWithExistingEmail() {
        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
        Assert.assertTrue(registerPage.retrieveExistingEmailWarningMessage().contains(dataProp.getProperty("existingEmailWarning")));
    }

    @Test(priority = 4)
    public void verifyRegisterWithWrongConfirmPassword() {
        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), dataProp.getProperty("invalidPassword"));
        Assert.assertTrue(registerPage.retrieveWrongConfirmPasswordWarningMessage().contains(dataProp.getProperty("wrongConfirmPasswordWarning")));
    }

    @Test(priority = 5)
    public void verifyRegisterWithNoDetails() {
        registerPage.clickOnContinueButton();
        Assert.assertTrue(registerPage.retrieveAllWarningMessages(dataProp.getProperty("privacyPolicyWarning"),
                dataProp.getProperty("firstNameWarning"),dataProp.getProperty("lastNameWarning"),
                dataProp.getProperty("invalidEmailWarning"),dataProp.getProperty("telephoneWarning"),
                dataProp.getProperty("passwordWarning")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
