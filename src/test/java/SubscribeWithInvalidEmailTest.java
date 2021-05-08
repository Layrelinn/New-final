import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SubscribeWithInvalidEmailTest extends BaseTest {

    //TODO remove InterruptedException DONE
    // TODO move goToFrame to Base Test DONE

    @Test
    public void subscribeWithInvalidEmail()  {

        MainPage mainPage = new MainPage();
        String emailAddressForSubscribe = "ttt@ttt";

        String popUpActualText =
                mainPage.scrollToElement()
                        .clickOnEmailAddressInput()
                        .setEmail(emailAddressForSubscribe)
                        .clickOnSubscribeButton()
                        .getTextFromPopUpErrorMessage();

        assertThat(popUpActualText)
                .as("Pop-up error message doesn't match with expected")
                .isEqualTo("Invalid email address.");

    }
}