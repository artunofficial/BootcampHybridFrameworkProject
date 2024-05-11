package com.tutorialsNinja.TestCases;

import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.ProductPage;
import com.tutorialsNinja.TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase {


    public SearchProductTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public HomePage homePage;
    public ProductPage productPage;


    @BeforeMethod
    public void searchProductSetup() {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));

    }

    @Test(priority = 1)
    public void verifySearchValidProduct() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("validProduct"));
        Thread.sleep(3000);
        Assert.assertTrue(productPage.verifyValidProductPresence());
    }

    @Test(priority = 2)
    public void verifySearchInvalidProduct() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("invalidProduct"));
       Thread.sleep(3000);
        Assert.assertFalse(productPage.verifyInvalidProductWarningMessageDisplay());
    }

    @Test(priority = 3)
    public void verifySearchNoProduct() {
        homePage = new HomePage(driver);
        productPage = homePage.clickOnSearchButton();
        Assert.assertTrue(productPage.verifyInvalidProductWarningMessageDisplay());
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
