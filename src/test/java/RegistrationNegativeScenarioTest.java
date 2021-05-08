import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import pages.LogInPage;
import pages.MainPage;

public class RegistrationNegativeScenarioTest extends BaseTest {

    @Test
    public void registrationNegativeScenario() {

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();

        String invalidFirstName = "James8";
        String lastName = "Rovinska";
        String emailAddress = "test2@gmail.com";
        String password = "test123";
        String birthdayDate = "08/7/1997";

        CreateAnAccountPage createAnAccountPage =
                mainPage.clickOnSignInButton()
                        .clickOnCreateAccountLink()
                        .clickOnSocialTitleRadioButton()
                        .enterInvalidFirstName(invalidFirstName)
                        .enterLastName(lastName)
                        .enterEmailAddress(emailAddress)
                        .enterPassword(password)
                        .enterBirthdayDate(birthdayDate)
                        .selectAgreeWithPrivacyPolicyCheckbox()
                        .selectCustomerDataPrivacyCheckbox()
                        .clickOnSaveButtonWithInvalidData();

        String validationFieldColor = createAnAccountPage.firstNameFieldBorderColor();
        String validationMessageText = createAnAccountPage.getValidationMessageText();

        sa.assertThat(validationFieldColor)
                .as("The highlighted color of the frame is not red")
                .isEqualTo("rgba(255, 76, 76, 1)");
        sa.assertThat(validationMessageText)
                .as("The pop-up error message doesn't match with expected")
                .isEqualTo("Invalid format.");

        sa.assertAll();

    }
}
