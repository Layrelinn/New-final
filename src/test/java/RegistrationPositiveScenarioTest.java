import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationPositiveScenarioTest extends BaseTest {

    @Test
    public void registrationWithValidData() {

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();

        String actualUserName =
                mainPage.goToFrame()
                        .clickOnSignInButton()
                        .clickOnCreateAccountLink()
                        .clickOnSocialTitleRadioButton()
                        .enterFirstName()
                        .enterLastName()
                        .enterEmailAddress()
                        .enterPassword()
                        .enterBirthdayDate()
                        .selectAgreeWithPrivacyPolicyCheckbox()
                        .selectCustomerDataPrivacyCheckbox()
                        .clickOnSaveButton()
                        .getUserName();

        Assertions.assertThat(actualUserName)
                .as("Name of the user is not displaying near card button")
                .isEqualTo("Lika Rovinska");

    }
}
