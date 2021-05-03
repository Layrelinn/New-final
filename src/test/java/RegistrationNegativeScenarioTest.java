import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationNegativeScenarioTest extends BaseTest {

    @Test
    public void registrationNegativeScenario() {

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();

        String validationFieldHighlight =
                mainPage.goToFrame()
                        .clickOnSignInButton()
                        .clickOnCreateAccountLink()
                        .clickOnSocialTitleRadioButton()
                        .enterInvalidFirstName()
                        .enterLastName()
                        .enterEmailAddress()
                        .enterPassword()
                        .enterBirthdayDate()
                        .selectAgreeWithPrivacyPolicyCheckbox()
                        .selectCustomerDataPrivacyCheckbox()
                        .clickOnSaveButtonWithInvalidData()
                        .firstNameBorderHighlight();

        sa.assertThat(validationFieldHighlight)
                .as("The highlighted color of the frame is not red")
                .isEqualTo("rgba(255, 76, 76, 1)");


        String validationMessageText =
                mainPage.clickOnSignInButton()
                        .clickOnCreateAccountLink()
                        .clickOnSocialTitleRadioButton()
                        .enterInvalidFirstName()
                        .enterLastName()
                        .enterEmailAddress()
                        .enterPassword()
                        .enterBirthdayDate()
                        .selectAgreeWithPrivacyPolicyCheckbox()
                        .selectCustomerDataPrivacyCheckbox()
                        .clickOnSaveButtonWithInvalidData()
                        .getValidationMessageText();

        sa.assertThat(validationMessageText)
                .as("The pop-up error message doesn't match with expected")
                .isEqualTo("Invalid format.");

        sa.assertAll();

    }
}
