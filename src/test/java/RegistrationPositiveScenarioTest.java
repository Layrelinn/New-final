import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationPositiveScenarioTest extends BaseTest {

    @Test
    public void registrationWithValidData() {

        MainPage mainPage = new MainPage();

        String firstName = "Lika";
        String lastName = "Rovinska";
        String emailAddress = "test2@gmail.com";
        String password = "test123";
        String birthdayDate = "08/7/1997";

        String actualUserName =
                mainPage.clickOnSignInButton()
                        .clickOnCreateAccountLink()
                        .clickOnSocialTitleRadioButton()
                        .enterFirstName(firstName)
                        .enterLastName(lastName)
                        .enterEmailAddress(emailAddress)
                        .enterPassword(password)
                        .enterBirthdayDate(birthdayDate)
                        .selectAgreeWithPrivacyPolicyCheckbox()
                        .selectCustomerDataPrivacyCheckbox()
                        .clickOnSaveButton()
                        .getUserNameFromNavigationBar();

        Assertions.assertThat(actualUserName)
                .as("Name of the user is not displaying near card button")
                .isEqualTo(firstName + " " + lastName);

    }
}
