package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedPage {
    public WebDriver driver;

    @FindBy(xpath = "//h1[text() = 'Your order has been placed!']")
    private WebElement orderPlacedSuccessMessage;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement continueButton;

    public OrderPlacedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String orderPlacedSuccessAlert() {
        String text = orderPlacedSuccessMessage.getText();
        return text;
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
