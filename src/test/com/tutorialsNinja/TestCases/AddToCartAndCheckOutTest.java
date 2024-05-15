package com.tutorialsNinja.TestCases;

import com.TutorialsNinja.Utilities.Util;
import com.tutorialsNinja.Pages.*;
import com.tutorialsNinja.TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartAndCheckOutTest extends TestBase {

    public AddToCartAndCheckOutTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public HomePage homePage;
    public ProductPage productPage;
    public AddToCartPage addToCartPage;
    public CheckOutPage checkOutPage;
    public OrderPlacedPage orderPlacedPage;


    @BeforeMethod
    public void addToCartSetup() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
    }

    @Test
    public void verifyAddValidProductToCartAndCheckOutWithRegisterAccount() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickOnRegisterAccountAndContinueOption();
        checkOutPage.combiningMandatoryDetailsToNavigateToPaymentMethod(
                dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
                Util.emailWithDateTimeStamp(), dataProp.getProperty("telephone"),
                prop.getProperty("validPassword"), prop.getProperty("validPassword"),
                dataProp.getProperty("address1"), dataProp.getProperty("city"));
        orderPlacedPage = new OrderPlacedPage(driver);
        Assert.assertTrue(orderPlacedPage.orderPlacedSuccessAlert().contains(dataProp.getProperty("orderPlacedMessage")));
        Thread.sleep(3000);
    }

    @Test
    public void verifyAddValidProductToCartAndCheckOutWithRegisterAccountToDifferentDeliveryAddress() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickOnRegisterAccountAndContinueOption();
        checkOutPage.combiningMandatoryDetailsToNavigateToPaymentMethodWithDifferentDeliveryAddress(
                dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(),
                dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"),
                dataProp.getProperty("address1"), dataProp.getProperty("city"), dataProp.getProperty("newShippingFirstName"),
                dataProp.getProperty("newShippingLastName"), dataProp.getProperty("newShippingAddress1"),
                dataProp.getProperty("newShippingCity"));
        orderPlacedPage = new OrderPlacedPage(driver);
        Assert.assertTrue(orderPlacedPage.orderPlacedSuccessAlert().contains(dataProp.getProperty("orderPlacedMessage")));
        Thread.sleep(3000);
    }

    @Test
    public void verifyValidGuestCheckOut() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.combiningGuestCheckOutOption(
                dataProp.getProperty("newBillingFirstName"), dataProp.getProperty("newBillingLastName"),
                Util.emailWithDateTimeStamp(), dataProp.getProperty("newBillingPhoneNumber"), dataProp.getProperty("newBillingAddress1"),
                dataProp.getProperty("newBillingCity"), dataProp.getProperty("newBillingZipcode"));
        orderPlacedPage = new OrderPlacedPage(driver);
        Assert.assertTrue(orderPlacedPage.orderPlacedSuccessAlert().contains(dataProp.getProperty("orderPlacedMessage")));

    }

    @Test
    public void verifyValidGuestCheckOutWithDifferentDeliveryAddress() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.combiningGuestCheckOutOptionWithDifferentAddress(
                dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
                Util.emailWithDateTimeStamp(), dataProp.getProperty("newBillingPhoneNumber"),
                dataProp.getProperty("address1"), dataProp.getProperty("city"),
                dataProp.getProperty("newBillingZipcode"), dataProp.getProperty("newBillingFirstName"),
                dataProp.getProperty("newBillingLastName"), dataProp.getProperty("newBillingAddress1"),
                dataProp.getProperty("newBillingCity"));
        orderPlacedPage = new OrderPlacedPage(driver);
        Assert.assertTrue(orderPlacedPage.orderPlacedSuccessAlert().contains(dataProp.getProperty("orderPlacedMessage")));
    }

    @Test
    public void verifyValidCheckoutAsReturningCustomer() throws Exception{
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.combiningReturningCustomerCheckout(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
        orderPlacedPage = new OrderPlacedPage(driver);
        Assert.assertTrue(orderPlacedPage.orderPlacedSuccessAlert().contains(dataProp.getProperty("orderPlacedMessage")));
    }

    @Test
    public void verifyTryCheckoutWithNoLoginDetailsOnCheckoutOptions() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.combiningLoginErrorMessageWithNoDetails();
        Assert.assertTrue(checkOutPage.combiningLoginErrorMessageWithNoDetails().contains(dataProp.getProperty("loginWarningMessage")));
    }

    @Test
    public void verifyTryCheckoutWithNoDetailsOnAccountDetails() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickOnRegisterAccountAndContinueOption();
        checkOutPage.setContinueButtonFromRegister();
        Assert.assertTrue(checkOutPage.retrievePrivacyPolicyWarningMessage().contains(dataProp.getProperty("privacyPolicyWarning")));
        Assert.assertTrue(checkOutPage.retrieveFirstNameWarningMessage().contains(dataProp.getProperty("firstNameWarning")));
        Assert.assertTrue(checkOutPage.retrieveLastNameWarningMessage().contains(dataProp.getProperty("lastNameWarning")));
        Assert.assertFalse(checkOutPage.retrieveEmailWarningMessage().contains(dataProp.getProperty("invalidEmailWarning")));
        Assert.assertTrue(checkOutPage.retrieveTelephoneWarningMessage().contains(dataProp.getProperty("telephoneWarning")));
        Assert.assertTrue(checkOutPage.retrievePasswordWarningMessage().contains(dataProp.getProperty("passwordWarning")));
        Assert.assertTrue(checkOutPage.retrieveAddress1WarningMessage().contains(dataProp.getProperty("addressWarning")));
        Assert.assertTrue(checkOutPage.retrieveCityWarningMessage().contains(dataProp.getProperty("cityWarning")));
        Assert.assertTrue(checkOutPage.retrievePostCodeWarningMessage().contains(dataProp.getProperty("postCodeWarning")));
        Assert.assertTrue(checkOutPage.retrieveStateWarningMessage().contains(dataProp.getProperty("stateWarning")));
    }

    @Test
    public void verifyTryCheckoutWithNoDetailsOnDeliveryDetails() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickOnRegisterAccountAndContinueOption();
        checkOutPage.retrievingWarningMessagesOnDeliveryDetailsCombine(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(),
                dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"),
                dataProp.getProperty("address1"), dataProp.getProperty("city"));
        checkOutPage.retrievingWarningMessagesOnDeliveryDetails(dataProp.getProperty("firstNameWarning"),
                dataProp.getProperty("lastNameWarning"),
                dataProp.getProperty("addressWarning"),
                dataProp.getProperty("cityWarning"), dataProp.getProperty("postCodeWarning"),
                dataProp.getProperty("stateWarning"));
   }

    @Test
    public void retrieveErrorMessageOnPaymentMethodAtTermsAndConditions() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        productPage.setAddValidProductToCart();
        Thread.sleep(2000);
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.ClickOnAddToCartOption();
        Thread.sleep(2000);
        Assert.assertTrue(addToCartPage.verifyAddedProductWarningMessage());
        addToCartPage.clickOnCheckout();
        Thread.sleep(2000);
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickOnRegisterAccountAndContinueOption();
        checkOutPage.retrievingWarningMessageOnPaymentMethod(
                dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(),
                dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"),
                dataProp.getProperty("address1"), dataProp.getProperty("city"), dataProp.getProperty("newShippingFirstName"),
                dataProp.getProperty("newShippingLastName"), dataProp.getProperty("newShippingAddress1"),
                dataProp.getProperty("newShippingCity"));
        Assert.assertTrue(checkOutPage.errorMessageTermsAndConditionsOnPaymentMethod().contains(dataProp.getProperty("termsAndConditionsWarning")));

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

}
