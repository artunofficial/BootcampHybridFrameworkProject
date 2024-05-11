package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement firstNameTextBox;

    @FindBy(id = "input-lastname")
    private WebElement lastNameTextBox;

    @FindBy(id = "input-email")
    private WebElement emailTextBox;

    @FindBy(id = "input-telephone")
    private WebElement telephoneTextBox;

    @FindBy(id = "input-password")
    private WebElement passwordTextBox;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
    private WebElement newsletterCheckBox;

    @FindBy(css = "a.agree+input")
    private WebElement privacyPolicyCheckBox;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueButton;

    @FindBy(css = "div.alert.alert-danger.alert-dismissible")
    private WebElement existingEmailWarningMessage;

    @FindBy(css = "div.text-danger")
    private WebElement wrongConfirmPasswordWarningMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement privacyPolicyWarningMessage;

    @FindBy(css = "input#input-firstname+div")
    private WebElement firstNameWarningMessage;

    @FindBy(css = "input#input-lastname+div")
    private WebElement lastNameWarningMessage;

    @FindBy(css = "input#input-email+div")
    private WebElement emailWarningMessage;

    @FindBy(css = "input#input-telephone+div")
    private WebElement telephoneWarningMessage;

    @FindBy(css = "input#input-password+div")
    private WebElement passwordWarningMessage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstNameText) {
        firstNameTextBox.sendKeys(firstNameText);
    }

    public void enterLastName(String lastNameText) {
        lastNameTextBox.sendKeys(lastNameText);
    }

    public void enterEmail(String emailText) {
        emailTextBox.sendKeys(emailText);
    }

    public void enterTelephone(String telephoneText) {
        telephoneTextBox.sendKeys(telephoneText);
    }

    public void enterPassword(String passwordText) {
        passwordTextBox.sendKeys(passwordText);
    }

    public void enterConfirmPassword(String confirmPasswordText) {
        confirmPasswordTextBox.sendKeys(confirmPasswordText);
    }

    public void clickOnNewsletterRadioButton() {
        newsletterCheckBox.click();
    }

    public void clickOnPrivacyPolicyCheckBox() {
        privacyPolicyCheckBox.click();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public String retrieveExistingEmailWarningMessage() {
        String text = existingEmailWarningMessage.getText();
        return text;
    }

    public String retrieveWrongConfirmPasswordWarningMessage() {
        String text = wrongConfirmPasswordWarningMessage.getText();
        return text;
    }

    public String retrievePrivacyPolicyWarningMessage() {
        String text = privacyPolicyWarningMessage.getText();
        return text;
    }

    public String retrieveFirstNameWarningMessage() {
        String text = firstNameWarningMessage.getText();
        return text;
    }

    public String retrieveLastNameWarningMessage() {
        String text = lastNameWarningMessage.getText();
        return text;
    }

    public String retrieveEmailWarningMessage() {
        String text = emailWarningMessage.getText();
        return text;
    }

    public String retrieveTelephoneWarningMessage() {
        String text = telephoneWarningMessage.getText();
        return text;
    }

    public String PasswordWarningMessage() {
        String text = passwordWarningMessage.getText();
        return text;
    }

    public AccountSuccessPage combiningMandatoryDetailsToNavigateToAccountSuccessPage(
            String firstNameText, String lastNameText, String emailText, String telephoneText,
            String passwordText, String confirmPasswordText) {

        firstNameTextBox.sendKeys(firstNameText);
        lastNameTextBox.sendKeys(lastNameText);
        emailTextBox.sendKeys(emailText);
        telephoneTextBox.sendKeys(telephoneText);
        passwordTextBox.sendKeys(passwordText);
        confirmPasswordTextBox.sendKeys(confirmPasswordText);
        privacyPolicyCheckBox.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public AccountSuccessPage combiningAllDetailsToNavigateToAccountSuccessPage(
            String firstNameText, String lastNameText, String emailText, String telephoneText,
            String passwordText, String confirmPasswordText) {

        firstNameTextBox.sendKeys(firstNameText);
        lastNameTextBox.sendKeys(lastNameText);
        emailTextBox.sendKeys(emailText);
        telephoneTextBox.sendKeys(telephoneText);
        passwordTextBox.sendKeys(passwordText);
        confirmPasswordTextBox.sendKeys(confirmPasswordText);
        newsletterCheckBox.click();
        privacyPolicyCheckBox.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public boolean retrieveAllWarningMessages(
            String expectedPrivacyPolicyWarning, String expectedFirstNameWarning,
            String expectedLastNameWarning, String expectedEmailWarning,
            String expectedTelephoneWarning, String expectedPasswordWarning) {

        boolean privacyPolicyWarningStatus = privacyPolicyWarningMessage.getText().contains(expectedPrivacyPolicyWarning);
        boolean firstNameWarningStatus = firstNameWarningMessage.getText().contains(expectedFirstNameWarning);
        boolean lastNameWarningStatus = lastNameWarningMessage.getText().contains(expectedLastNameWarning);
        boolean emailWarningStatus = emailWarningMessage.getText().contains(expectedEmailWarning);
        boolean telephoneWarningStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarning);
        boolean passwordWarningStatus = passwordWarningMessage.getText().contains(expectedPasswordWarning);
        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus &&
                emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
    }
}
