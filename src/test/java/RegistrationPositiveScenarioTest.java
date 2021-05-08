import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class RegistrationPositiveScenarioTest extends BaseTest {

    @Test
    public void registrationWithValidData() {

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();
        //TODO every method should get parameters
        String name = "Lika";
        String lastName = "123123";

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
                        .getUserName(); //TODO rename

        Assertions.assertThat(actualUserName)
                .as("Name of the user is not displaying near card button")
                .isEqualTo("Lika Rovinska"); //TODO get data from variables above

    }
}
