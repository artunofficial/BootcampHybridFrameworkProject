package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedPage {
    public WebDriver driver;

    @FindBy(xpath = "//div[@id= 'content']/h1")
    private WebElement orderPlacedSuccessMessage;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement continueButton;

    public OrderPlacedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean orderPlacedSuccessAlert() {
        boolean displayStatus = orderPlacedSuccessMessage.isDisplayed();
        return displayStatus;
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
