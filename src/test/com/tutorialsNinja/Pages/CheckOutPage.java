package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
    public WebDriver driver;
    public Select select;


    @FindBy(xpath = "//input[@value = 'register']")
    private WebElement registerAccountSelection;

    @FindBy(xpath = "//input[@id = 'button-account']")
    private WebElement continueButton;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameTextBox;

    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameTextBox;

    @FindBy(id = "input-payment-email")
    private WebElement emailTextBox;

    @FindBy(id = "input-payment-telephone")
    private WebElement telephoneTextBox;

    @FindBy(id = "input-payment-password")
    private WebElement passwordTextBox;

    @FindBy(id = "input-payment-confirm")
    private WebElement confirmPasswordTextBox;

    @FindBy(id = "input-payment-address-1")
    private WebElement address1TextBox;

    @FindBy(id = "input-payment-city")
    private WebElement cityTextBox;

    @FindBy(id = "input-payment-country")
    private WebElement countryDropdown;

    @FindBy(id = "input-shipping-country")
    private WebElement shippingCountryDropdown;
    @FindBy(id = "input-payment-zone")
    private WebElement stateDropdown;

    @FindBy(id = "input-shipping-zone")
    private WebElement shippingStateDropdown;

    @FindBy(name = "newsletter")
    private WebElement newsletterSelection;

    @FindBy(name = "shipping_address")
    private WebElement shippingAndBillingSelection;

    @FindBy(xpath = "(//input[@name = 'agree'])[1]")
    private WebElement privacyPolicy;

    @FindBy(id = "button-register")
    private WebElement continueButtonFromRegister;

    @FindBy(id = "button-payment-address")
    private WebElement continueButtonFromBillingDetails;

    @FindBy(id = "button-shipping-address")
    private WebElement continueButtonFromDeliveryDetails;

    @FindBy(id = "button-shipping-method")
    private WebElement continueButtonFromDeliveryMethods;

    @FindBy(xpath = "(//input[@name = 'agree'])[1]")
    private WebElement termsAndConditionsAccept;

    @FindBy(id = "button-payment-method")
    private WebElement continueButtonFromPaymentMethod;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "(//input[@name = 'shipping_address'])[2]")
    private WebElement useNewAddressButtonOnDeliveryDetails;

    @FindBy(xpath = "(//input[@name = 'payment_address'])[2]")
    private WebElement newAddressSelection;

    @FindBy(id = "input-payment-firstname")
    private WebElement newBillingAddressFirstName;

    @FindBy(id = "input-payment-lastname")
    private WebElement newBillingAddressLastName;

    @FindBy(id = "input-payment-email")
    private WebElement newBillingEmailAddress;

    @FindBy(id = "input-payment-telephone")
    private WebElement newBillingPhoneNumber;

    @FindBy(id = "input-payment-postcode")
    private WebElement newBillingZipcode;

    @FindBy(id = "input-payment-address-1")
    private WebElement newBillingAddressAddress1;

    @FindBy(id = "input-payment-city")
    private WebElement newBillingAddressCity;

    @FindBy(id = "button-guest")
    private WebElement continueButtonFromBillingGuestCheckout;

    @FindBy(id = "button-guest-shipping")
    private WebElement continueButtonFromDeliveryDetailsGuestCheckout;

    @FindBy(id = "input-shipping-firstname")
    private WebElement newShippingAddressFirstName;

    @FindBy(id = "input-shipping-lastname")
    private WebElement newShippingAddressLastName;

    @FindBy(id = "input-shipping-address-1")
    private WebElement newShippingAddressAddress1;

    @FindBy(id = "input-shipping-city")
    private WebElement newShippingAddressCity;

    @FindBy(xpath = "//input[@value = 'guest']")
    private WebElement guestCheckoutSelection;

    @FindBy(id = "input-email")
    private WebElement existingCustomerEmail;

    @FindBy(id = "input-password")
    private WebElement existingCustomerPassword;

    @FindBy(id = "button-login")
    private WebElement loginButton;

    @FindBy(css = "div.alert.alert-danger.alert-dismissible")
    private WebElement loginWarningMessage;


    @FindBy(css = "input#input-payment-firstname+div")
    private WebElement firstNameWarningMessage;

    @FindBy(css = "input#input-payment-lastname+div")
    private WebElement lastNameWarningMessage;

    @FindBy(css = "input#input-payment-email+div")
    private WebElement emailWarningMessage;

    @FindBy(css = "input#input-payment-telephone+div")
    private WebElement telephoneWarningMessage;

    @FindBy(css = "input#input-payment-password+div")
    private WebElement passwordWarningMessage;

    @FindBy(css = "input#input-payment-address-1+div")
    private WebElement address1WarningMessage;

    @FindBy(css = "input#input-payment-city+div")
    private WebElement cityWarningMessage;

    @FindBy(css = "input#input-payment-postcode+div")
    private WebElement postCodeWarningMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement privacyPolicyWarningMessage;

    @FindBy(xpath = "//div[text() = 'Please select a region / state!']")
    private WebElement stateWarningMessage;

    @FindBy(css = "input#input-shipping-firstname+div")
    private WebElement firstNameDeliveryDetailsWarningMessage;

    @FindBy(css = "input#input-shipping-lastname+div")
    private WebElement lastNameDeliveryDetailsWarningMessage;

    @FindBy(css = "input#input-shipping-address-1+div")
    private WebElement address1DeliveryDetailsWarningMessage;

    @FindBy(css = "input#input-shipping-city+div")
    private WebElement cityDeliveryDetailsWarningMessage;

    @FindBy(css = "input#input-shipping-postcode+div")
    private WebElement postCodeDeliveryDetailsWarningMessage;

    @FindBy(xpath = "//p[text() = 'Please select the preferred payment method to use on this order.']")
    private WebElement termsAndConditionsPaymentMethodWarningMessage;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnRegisterAccountAndContinueOption() {

        registerAccountSelection.click();
        continueButton.click();
    }

    public void combiningMandatoryDetailsToNavigateToPaymentMethod(
            String firstNameText, String lastNameText, String emailText,
            String telephoneText, String passwordText, String confirmPasswordText,
            String address1Text, String cityText) {
        firstNameTextBox.sendKeys(firstNameText);
        lastNameTextBox.sendKeys(lastNameText);
        emailTextBox.sendKeys(emailText);
        telephoneTextBox.sendKeys(telephoneText);
        passwordTextBox.sendKeys(passwordText);
        confirmPasswordTextBox.sendKeys(confirmPasswordText);
        address1TextBox.sendKeys(address1Text);
        cityTextBox.sendKeys(cityText);
        select = new Select(countryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(stateDropdown);
        select.selectByVisibleText("New Jersey");
        newsletterSelection.click();
        privacyPolicy.click();
        continueButtonFromRegister.click();
        continueButtonFromDeliveryDetails.click();
        continueButtonFromDeliveryMethods.click();
        termsAndConditionsAccept.click();
        continueButtonFromPaymentMethod.click();
        confirmOrderButton.click();
    }


    public void combiningMandatoryDetailsToNavigateToPaymentMethodWithDifferentDeliveryAddress(
            String firstNameText, String lastNameText, String emailText,
            String telephoneText, String passwordText, String confirmPasswordText,
            String address1Text, String cityText, String newShippingFirstNameText,
            String newShippingLastNameText, String newShippingAddress1Text, String newShippingCityText) throws Exception {
        firstNameTextBox.sendKeys(firstNameText);
        lastNameTextBox.sendKeys(lastNameText);
        emailTextBox.sendKeys(emailText);
        telephoneTextBox.sendKeys(telephoneText);
        passwordTextBox.sendKeys(passwordText);
        confirmPasswordTextBox.sendKeys(confirmPasswordText);
        address1TextBox.sendKeys(address1Text);
        cityTextBox.sendKeys(cityText);
        select = new Select(countryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(stateDropdown);
        select.selectByVisibleText("New Jersey");
        Thread.sleep(2000);
        newsletterSelection.click();
        Thread.sleep(2000);
        shippingAndBillingSelection.click();
        Thread.sleep(2000);
        privacyPolicy.click();
        Thread.sleep(2000);
        continueButtonFromRegister.click();
        Thread.sleep(3000);
        useNewAddressButtonOnDeliveryDetails.click();
        newShippingAddressFirstName.sendKeys(newShippingFirstNameText);
        newShippingAddressLastName.sendKeys(newShippingLastNameText);
        newShippingAddressAddress1.sendKeys(newShippingAddress1Text);
        newShippingAddressCity.sendKeys(newShippingCityText);
        select = new Select(shippingCountryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(shippingStateDropdown);
        select.selectByVisibleText("Florida");
        continueButtonFromDeliveryDetails.click();
        continueButtonFromDeliveryMethods.click();
        termsAndConditionsAccept.click();
        continueButtonFromPaymentMethod.click();
        confirmOrderButton.click();
    }


    public void combiningGuestCheckOutOption(
            String newShippingFirstNameText, String newShippingLastNameText,
            String newBillingEmailAddressText, String newBillingPhoneNumberText,
            String newShippingAddress1Text, String newShippingCityText,
            String newBillingZipcodeText) {
        guestCheckoutSelection.click();
        continueButton.click();
        newBillingAddressFirstName.sendKeys(newShippingFirstNameText);
        newBillingAddressLastName.sendKeys(newShippingLastNameText);
        newBillingEmailAddress.sendKeys(newBillingEmailAddressText);
        newBillingPhoneNumber.sendKeys(newBillingPhoneNumberText);
        newBillingAddressAddress1.sendKeys(newShippingAddress1Text);
        newBillingAddressCity.sendKeys(newShippingCityText);
        newBillingZipcode.sendKeys(newBillingZipcodeText);
        select = new Select(countryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(stateDropdown);
        select.selectByVisibleText("Florida");
        continueButtonFromBillingGuestCheckout.click();
        continueButtonFromDeliveryMethods.click();
        termsAndConditionsAccept.click();
        continueButtonFromPaymentMethod.click();
        confirmOrderButton.click();
    }

    public void combiningGuestCheckOutOptionWithDifferentAddress(
            String firstNameTextBox, String lastNameTextBox,
            String emailTextBox, String telephoneTextBox,
            String address1TextBox, String cityTextBox,
            String newBillingZipcodeText,
            String newShippingFirstNameText, String newShippingLastNameText,
            String newShippingAddress1Text, String newShippingCityText) {
        guestCheckoutSelection.click();
        continueButton.click();
        newBillingAddressFirstName.sendKeys(firstNameTextBox);
        newBillingAddressLastName.sendKeys(lastNameTextBox);
        newBillingEmailAddress.sendKeys(emailTextBox);
        newBillingPhoneNumber.sendKeys(telephoneTextBox);
        newBillingAddressAddress1.sendKeys(address1TextBox);
        newBillingAddressCity.sendKeys(cityTextBox);
        newBillingZipcode.sendKeys(newBillingZipcodeText);
        select = new Select(countryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(stateDropdown);
        select.selectByVisibleText("Florida");
        shippingAndBillingSelection.click();
        continueButtonFromBillingGuestCheckout.click();
        newShippingAddressFirstName.sendKeys(newShippingFirstNameText);
        newShippingAddressLastName.sendKeys(newShippingLastNameText);
        newShippingAddressAddress1.sendKeys(newShippingAddress1Text);
        newShippingAddressCity.sendKeys(newShippingCityText);
        select = new Select(shippingCountryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(shippingStateDropdown);
        select.selectByVisibleText("Florida");
        continueButtonFromDeliveryDetailsGuestCheckout.click();
        continueButtonFromDeliveryMethods.click();
        termsAndConditionsAccept.click();
        continueButtonFromPaymentMethod.click();
        confirmOrderButton.click();
    }

    public void combiningReturningCustomerCheckout(String emailTextBox, String passwordTextBox) {
        existingCustomerEmail.sendKeys(emailTextBox);
        existingCustomerPassword.sendKeys(passwordTextBox);
        loginButton.click();
        continueButtonFromBillingDetails.click();
        continueButtonFromDeliveryDetails.click();
        continueButtonFromDeliveryMethods.click();
        termsAndConditionsAccept.click();
        continueButtonFromPaymentMethod.click();
        confirmOrderButton.click();
    }

    public String combiningLoginErrorMessageWithNoDetails() {
        loginButton.click();
        String text = loginWarningMessage.getText();
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

    public String retrievePasswordWarningMessage() {
        String text = passwordWarningMessage.getText();
        return text;
    }

    public String retrieveAddress1WarningMessage() {
        String text = address1WarningMessage.getText();
        return text;
    }

    public String retrieveCityWarningMessage() {
        String text = cityWarningMessage.getText();
        return text;
    }

    public String retrievePostCodeWarningMessage() {
        String text = postCodeWarningMessage.getText();
        return text;
    }

    public String retrieveStateWarningMessage() {
        String text = stateWarningMessage.getText();
        return text;
    }

    public String retrieveFirstNameDeliveryDetailsWarningMessage() {
        String text = firstNameDeliveryDetailsWarningMessage.getText();
        return text;
    }

    public String retrieveLastNameDeliveryDetailsWarningMessage() {
        String text = lastNameDeliveryDetailsWarningMessage.getText();
        return text;
    }

    public String retrieveAddress1DeliveryDetailsWarningMessage() {
        String text = address1DeliveryDetailsWarningMessage.getText();
        return text;
    }

    public String retrieveCityDeliveryDetailsWarningMessage() {
        String text = cityDeliveryDetailsWarningMessage.getText();
        return text;
    }

    public boolean retrievingAllWarningMessagesOnAccountBillingDetails(
             String expectedPrivacyPolicyWarning, String expectedFirstNameWarning,
             String expectedLastNameWarning, String expectedEmailWarning,
             String expectedTelephoneWarning, String expectedPasswordWarning,
             String expectedAddressWarning, String expectedCityWarning,
             String expectedPostalCodeWarning, String expectedStateWarning) throws Exception {

        continueButtonFromRegister.click();
        Thread.sleep(2000);
        boolean privacyPolicyWarningStatus = privacyPolicyWarningMessage.getText().equals(expectedPrivacyPolicyWarning);
        boolean firstNameWarningStatus = firstNameWarningMessage.getText().contains(expectedFirstNameWarning);
        boolean lastNameWarningStatus = lastNameWarningMessage.getText().contains(expectedLastNameWarning);
        boolean emailWarningStatus = emailWarningMessage.getText().contains(expectedEmailWarning);
        boolean telephoneWarningStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarning);
        boolean passwordWarningStatus = passwordWarningMessage.getText().contains(expectedPasswordWarning);
        boolean addressWarningStatus = address1WarningMessage.getText().contains(expectedAddressWarning);
        boolean cityWarningStatus = cityWarningMessage.getText().contains(expectedCityWarning);
        boolean postalCodeWarningStatus = postCodeWarningMessage.getText().contains(expectedPostalCodeWarning);
        boolean stateWarningStatus = stateWarningMessage.getText().contains(expectedStateWarning);
        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus &&
                emailWarningStatus && telephoneWarningStatus &&
                passwordWarningStatus && addressWarningStatus &&
                cityWarningStatus && postalCodeWarningStatus && stateWarningStatus;

    }

    public void setContinueButtonFromRegister() throws Exception{
        continueButtonFromRegister.click();
        Thread.sleep(2000);
    }


    public void retrievingWarningMessagesOnDeliveryDetailsCombine(
            String firstNameText, String lastNameText, String emailText,
            String telephoneText, String passwordText, String confirmPasswordText,
            String address1Text, String cityText) throws Exception {
        firstNameTextBox.sendKeys(firstNameText);
        lastNameTextBox.sendKeys(lastNameText);
        emailTextBox.sendKeys(emailText);
        telephoneTextBox.sendKeys(telephoneText);
        passwordTextBox.sendKeys(passwordText);
        confirmPasswordTextBox.sendKeys(confirmPasswordText);
        address1TextBox.sendKeys(address1Text);
        cityTextBox.sendKeys(cityText);
        select = new Select(countryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(stateDropdown);
        select.selectByVisibleText("New Jersey");
        Thread.sleep(2000);
        newsletterSelection.click();
        Thread.sleep(2000);
        shippingAndBillingSelection.click();
        Thread.sleep(2000);
        privacyPolicy.click();
        Thread.sleep(2000);
        continueButtonFromRegister.click();
        Thread.sleep(3000);
        useNewAddressButtonOnDeliveryDetails.click();
        continueButtonFromDeliveryDetails.click();

    }

    public boolean retrievingWarningMessagesOnDeliveryDetails(
            String expectedFirstNameWarning, String expectedLastNameWarning,
            String expectedAddressWarning, String expectedCityWarning,
            String expectedPostalCodeWarning, String expectedStateWarning) {
        boolean firstNameDeliveryDetailsWarningStatus = firstNameDeliveryDetailsWarningMessage.getText().contains(expectedFirstNameWarning);
        boolean lastNameDeliveryDetailsWarningStatus = lastNameDeliveryDetailsWarningMessage.getText().contains(expectedLastNameWarning);
        boolean addressWarningStatus = address1DeliveryDetailsWarningMessage.getText().contains(expectedAddressWarning);
        boolean cityWarningStatus = cityDeliveryDetailsWarningMessage.getText().contains(expectedCityWarning);
        boolean postalCodeWarningStatus = postCodeDeliveryDetailsWarningMessage.getText().contains(expectedPostalCodeWarning);
        boolean stateWarningStatus = stateWarningMessage.getText().contains(expectedStateWarning);
        return firstNameDeliveryDetailsWarningStatus && lastNameDeliveryDetailsWarningStatus && addressWarningStatus
                && cityWarningStatus && postalCodeWarningStatus && stateWarningStatus;
    }

    public void retrievingWarningMessageOnPaymentMethod(
            String firstNameText, String lastNameText, String emailText,
            String telephoneText, String passwordText, String confirmPasswordText,
            String address1Text, String cityText, String newShippingFirstNameText,
            String newShippingLastNameText, String newShippingAddress1Text, String newShippingCityText) throws Exception {
        firstNameTextBox.sendKeys(firstNameText);
        lastNameTextBox.sendKeys(lastNameText);
        emailTextBox.sendKeys(emailText);
        telephoneTextBox.sendKeys(telephoneText);
        passwordTextBox.sendKeys(passwordText);
        confirmPasswordTextBox.sendKeys(confirmPasswordText);
        address1TextBox.sendKeys(address1Text);
        cityTextBox.sendKeys(cityText);
        select = new Select(countryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(stateDropdown);
        select.selectByVisibleText("New Jersey");
        Thread.sleep(2000);
        newsletterSelection.click();
        Thread.sleep(2000);
        shippingAndBillingSelection.click();
        Thread.sleep(2000);
        privacyPolicy.click();
        Thread.sleep(2000);
        continueButtonFromRegister.click();
        Thread.sleep(3000);
        useNewAddressButtonOnDeliveryDetails.click();
        newShippingAddressFirstName.sendKeys(newShippingFirstNameText);
        newShippingAddressLastName.sendKeys(newShippingLastNameText);
        newShippingAddressAddress1.sendKeys(newShippingAddress1Text);
        newShippingAddressCity.sendKeys(newShippingCityText);
        select = new Select(shippingCountryDropdown);
        select.selectByVisibleText("United States");
        select = new Select(shippingStateDropdown);
        select.selectByVisibleText("Florida");
        continueButtonFromDeliveryDetails.click();
        continueButtonFromDeliveryMethods.click();
        continueButtonFromPaymentMethod.click();
    }

    public String errorMessageTermsAndConditionsOnPaymentMethod() {
        String text = termsAndConditionsPaymentMethodWarningMessage.getText();
        return text;

    }

}
