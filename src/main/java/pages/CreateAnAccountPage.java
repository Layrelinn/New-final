package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage extends BasePage {

    @FindBy(xpath = "//span[@class='custom-radio']//input[@value='2']")
    private WebElement socialTitleRadioButton;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='email']")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdayDateInput;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerDataPrivacyCheckbox;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement agreeWithPrivacyPolicyCheckbox;

    @FindBy(xpath = "//button[contains(@class,'form-control-submit')]")
    private WebElement saveButton;

    @FindBy(xpath = "//li[contains(@class,'alert-danger')]")
    private WebElement validationErrorMessage;


    public CreateAnAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public CreateAnAccountPage clickOnSocialTitleRadioButton() {
        socialTitleRadioButton.click();
        return this;
    }

    public CreateAnAccountPage enterFirstName(String name) {
        firstNameInput.click();
        firstNameInput.sendKeys(name);
        return this;
    }

    public CreateAnAccountPage enterInvalidFirstName(String invalidFirstName) {
        firstNameInput.click();
        firstNameInput.sendKeys(invalidFirstName);
        return this;
    }

    public CreateAnAccountPage enterLastName(String lastName) {
        lastNameInput.click();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public CreateAnAccountPage enterEmailAddress(String emailAddress) {
        emailAddressInput.click();
        emailAddressInput.sendKeys(emailAddress);
        return this;
    }

    public CreateAnAccountPage enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
        return this;
    }

    public CreateAnAccountPage enterBirthdayDate(String birthdayDate) {
        birthdayDateInput.click();
        birthdayDateInput.sendKeys(birthdayDate);
        return this;
    }

    public CreateAnAccountPage selectAgreeWithPrivacyPolicyCheckbox() {
        agreeWithPrivacyPolicyCheckbox.click();
        return this;
    }

    public CreateAnAccountPage selectCustomerDataPrivacyCheckbox() {
        customerDataPrivacyCheckbox.click();
        return this;
    }

    public MainPage clickOnSaveButton() {
        saveButton.click();
        return new MainPage();
    }

    public CreateAnAccountPage clickOnSaveButtonWithInvalidData() {
        saveButton.click();
        return this;
    }
    
    public String firstNameFieldBorderColor() {
        return firstNameInput.getCssValue("outline-color");
    }

    public String getValidationMessageText() {
        return validationErrorMessage.getText();
    }
    
}
