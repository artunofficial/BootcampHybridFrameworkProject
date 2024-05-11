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


//        AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
//        registerPage.enterFirstName(firstname);
//        registerPage.enterLastName(lastname);
//        registerPage.enterEmail(Util.emailWithDateTimeStamp());
//        registerPage.enterTelephone(telephone);
//        registerPage.enterPassword(password);
//        registerPage.enterConfirmPassword(confirmpassword);
//        registerPage.clickOnPrivacyPolicyCheckBox();
//        registerPage.clickOnContinueButton();
        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(firstname, lastname, Util.emailWithDateTimeStamp(), telephone, password, confirmpassword);
        Assert.assertTrue(accountSuccessPage.accountSuccessAlert());
//        driver.findElement(By.id("input-firstname")).sendKeys(firstname);
//        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
//        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
//        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
//        driver.findElement(By.id("input-password")).sendKeys(password);
//        driver.findElement(By.id("input-confirm")).sendKeys(confirmpassword);
//        driver.findElement(By.cssSelector("a.agree+input")).click();
//        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
//        Assert.assertTrue(driver.findElement(By.cssSelector("div#content>p:nth-child(2)")).isDisplayed());
    }

    @Test(priority = 2)
    public void verifyRegisterWithAllDetails() {


//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmail(Util.emailWithDateTimeStamp());
//        registerPage.enterTelephone(dataProp.getProperty("telephone"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        registerPage.clickOnNewsletterRadioButton();
//        registerPage.clickOnPrivacyPolicyCheckBox();
//        registerPage.clickOnContinueButton();
        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
        Assert.assertTrue(accountSuccessPage.accountSuccessAlert());
//        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
//        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@name = 'newsletter' and @value = '1']")).click();
//        driver.findElement(By.cssSelector("a.agree+input")).click();
//        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
//        Assert.assertTrue(driver.findElement(By.cssSelector("div#content>p:nth-child(2)")).isDisplayed());
    }

    @Test(priority = 3)
    public void verifyRegisterWithExistingEmail() {


//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmail(prop.getProperty("validEmail"));
//        registerPage.enterTelephone(dataProp.getProperty("telephone"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        registerPage.clickOnNewsletterRadioButton();
//        registerPage.clickOnPrivacyPolicyCheckBox();
//        registerPage.clickOnContinueButton();
        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
//        String actualWarningMessage = registerPage.retrieveExistingEmailWarningMessage();
//        String expectedWarningMessage = dataProp.getProperty("existingEmailWarning");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
        Assert.assertTrue(registerPage.retrieveExistingEmailWarningMessage().contains(dataProp.getProperty("existingEmailWarning")));
//        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.cssSelector("a.agree+input")).click();
//        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
//        String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
//        String expectedWarningMessage = dataProp.getProperty("existingEmailWarning");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @Test(priority = 4)
    public void verifyRegisterWithWrongConfirmPassword() {

//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmail(Util.emailWithDateTimeStamp());
//        registerPage.enterTelephone(dataProp.getProperty("telephone"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(dataProp.getProperty("invalidPassword"));
//        registerPage.clickOnPrivacyPolicyCheckBox();
//        registerPage.clickOnContinueButton();
        accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"), prop.getProperty("validPassword"), dataProp.getProperty("invalidPassword"));
        Assert.assertTrue(registerPage.retrieveWrongConfirmPasswordWarningMessage().contains(dataProp.getProperty("wrongConfirmPasswordWarning")));
    //        String actualConfirmPasswordWarningMessage = registerPage.retrieveWrongConfirmPasswordWarningMessage();
    //        String expectedConfirmPasswordWarningMessage = dataProp.getProperty("wrongConfirmPasswordWarning");
    //        Assert.assertTrue(actualConfirmPasswordWarningMessage.contains(expectedConfirmPasswordWarningMessage));
//        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
//        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("invalidPassword"));
//        driver.findElement(By.cssSelector("a.agree+input")).click();
//        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
//        Assert.assertTrue(driver.findElement(By.cssSelector("div.text-danger")).isDisplayed());

    }

    @Test(priority = 5)
    public void verifyRegisterWithNoDetails() {
//        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickOnContinueButton();
        Assert.assertTrue(registerPage.retrieveAllWarningMessages(dataProp.getProperty("privacyPolicyWarning"),
                dataProp.getProperty("firstNameWarning"),dataProp.getProperty("lastNameWarning"),
                dataProp.getProperty("invalidEmailWarning"),dataProp.getProperty("telephoneWarning"),
                dataProp.getProperty("passwordWarning")));

//        String actualWarningMessage = registerPage.retrievePrivacyPolicyWarningMessage();
//        String expectedWarningMessage = dataProp.getProperty("privacyPolicyWarning");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    //        Assert.assertTrue(registerPage.retrievePrivacyPolicyWarningMessage().contains(dataProp.getProperty("privacyPolicyWarning")));

//        String actualFirstNameWarningMessage = registerPage.retrieveFirstNameWarningMessage();
//        String expectedFirstNameWarningMessage = dataProp.getProperty("firstNameWarning");
//        Assert.assertTrue(actualFirstNameWarningMessage.contains(expectedFirstNameWarningMessage));
    //        Assert.assertTrue(registerPage.retrieveFirstNameWarningMessage().contains(dataProp.getProperty("firstNameWarning")));


//        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
//        String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
//        String expectedWarningMessage = dataProp.getProperty("privacyPolicyWarning");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

//        String actualFirstNameWarningMessage = driver.findElement(By.cssSelector("input#input-firstname+div")).getText();
//        String expectedFirstNameWarningMessage = dataProp.getProperty("firstNameWarning");
//        Assert.assertTrue(actualFirstNameWarningMessage.contains(expectedFirstNameWarningMessage));

//        String actualLastNameWarningMessage = registerPage.retrieveLastNameWarningMessage();
//        String expectedLastNameWarningMessage = dataProp.getProperty("lastNameWarning");
//        Assert.assertTrue(actualLastNameWarningMessage.contains(expectedLastNameWarningMessage));
    //        Assert.assertTrue(registerPage.retrieveLastNameWarningMessage().contains(dataProp.getProperty("lastNameWarning")));

//        String actualEmailWarningMessage = registerPage.retrieveEmailWarningMessage();
//        String expectedEmailWarningMessage = dataProp.getProperty("invalidEmailWarning");
//        Assert.assertTrue(actualEmailWarningMessage.contains(expectedEmailWarningMessage));
    //        Assert.assertTrue(registerPage.retrieveEmailWarningMessage().contains(dataProp.getProperty("invalidEmailWarning")));

//        String actualLastNameWarningMessage = driver.findElement(By.cssSelector("input#input-lastname+div")).getText();
//        String expectedLastNameWarningMessage = dataProp.getProperty("lastNameWarning");
//        Assert.assertTrue(actualLastNameWarningMessage.contains(expectedLastNameWarningMessage));

//        String actualEmailWarningMessage = driver.findElement(By.cssSelector("input#input-email+div")).getText();
//        String expectedEmailWarningMessage = dataProp.getProperty("invalidEmailWarning");
//        Assert.assertTrue(actualEmailWarningMessage.contains(expectedEmailWarningMessage));

//        String actualTelephoneWarningMessage = registerPage.retrieveTelephoneWarningMessage();
//        String expectedTelephoneWarningMessage = dataProp.getProperty("telephoneWarning");
//        Assert.assertTrue(actualTelephoneWarningMessage.contains(expectedTelephoneWarningMessage));
    //        Assert.assertTrue(registerPage.retrieveTelephoneWarningMessage().contains(dataProp.getProperty("telephoneWarning")));

//        String actualPasswordWarningMessage = registerPage.PasswordWarningMessage();
//        String expectedPasswordWarningMessage = dataProp.getProperty("passwordWarning");
//        Assert.assertTrue(actualPasswordWarningMessage.contains(expectedPasswordWarningMessage));
    //        Assert.assertTrue(registerPage.PasswordWarningMessage().contains(dataProp.getProperty("passwordWarning")));

//        String actualTelephoneWarningMessage = driver.findElement(By.cssSelector("input#input-telephone+div")).getText();
//        String expectedTelephoneWarningMessage = dataProp.getProperty("telephoneWarning");
//        Assert.assertTrue(actualTelephoneWarningMessage.contains(expectedTelephoneWarningMessage));

//        String actualPasswordWarningMessage = driver.findElement(By.cssSelector("input#input-password+div")).getText();
//        String expectedPasswordWarningMessage = dataProp.getProperty("passwordWarning");
//        Assert.assertTrue(actualPasswordWarningMessage.contains(expectedPasswordWarningMessage));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
