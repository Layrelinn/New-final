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

    public CreateAnAccountPage enterFirstName() {
        firstNameInput.click();
        firstNameInput.sendKeys("Lika");
        return this;
    }

    public CreateAnAccountPage enterInvalidFirstName() {
        firstNameInput.click();
        firstNameInput.sendKeys("James8");
        return this;
    }

    public CreateAnAccountPage enterLastName() {
        lastNameInput.click();
        lastNameInput.sendKeys("Rovinska");
        return this;
    }

    public CreateAnAccountPage enterEmailAddress() {
        emailAddressInput.click();
        emailAddressInput.sendKeys("test2@gmail.com");
        return this;
    }

    public CreateAnAccountPage enterPassword() {
        passwordInput.click();
        passwordInput.sendKeys("test123");
        return this;
    }

    public CreateAnAccountPage enterBirthdayDate() {
        birthdayDateInput.click();
        birthdayDateInput.sendKeys("08/7/1997");
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
    
    public String firstNameBorderHighlight() {
        return firstNameInput.getCssValue("outline-color");
    }

    public String getValidationMessageText() {
        return validationErrorMessage.getText();
    }
    
}
