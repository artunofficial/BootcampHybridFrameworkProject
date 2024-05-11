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
        //        homePage.enterProductName(dataProp.getProperty("validProduct"));
        //        homePage.clickOnSearchButton();
//    driver.findElement(By.cssSelector("div#search>input")).sendKeys(dataProp.getProperty("validProduct"));
        Thread.sleep(3000);
//    driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg>i")).click();

        Assert.assertTrue(productPage.verifyValidProductPresence());
//        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
    }

    @Test(priority = 2)
    public void verifySearchInvalidProduct() throws Exception {
        homePage = new HomePage(driver);
        productPage = homePage.navigateToProductPage(dataProp.getProperty("invalidProduct"));
        //        homePage.enterProductName(dataProp.getProperty("invalidProduct"));
        //        homePage.clickOnSearchButton();
//        driver.findElement(By.cssSelector("div#search>input")).sendKeys(dataProp.getProperty("invalidProduct"));
        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg>i")).click();
        Assert.assertFalse(productPage.verifyInvalidProductWarningMessageDisplay());
//        Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());

    }

    @Test(priority = 3)
    public void verifySearchNoProduct() {
        homePage = new HomePage(driver);
        productPage = homePage.clickOnSearchButton();
//        HomePage homePage = new HomePage(driver);
//        homePage.clickOnSearchButton();
//        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.verifyInvalidProductWarningMessageDisplay());
//        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg>i")).click();
//        Assert.assertTrue(driver.findElement(By.xpath("//p[text() = 'There is no product that matches the search criteria.']")).isDisplayed());

    }



    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
