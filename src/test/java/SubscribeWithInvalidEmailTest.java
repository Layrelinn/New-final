import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SubscribeWithInvalidEmailTest extends BaseTest {

    //TODO remove InterruptedException
    // TODO move goToFrame to Base Test

    @Test
    public void subscribeWithInvalidEmail() throws InterruptedException {

        MainPage mainPage = new MainPage();

        String popUpActualText =
                mainPage.goToFrame()
                        .scrollToElement()
                        .clickOnEmailAddressInput()
                        .setEmail("ttt@ttt")
                        .clickOnSubscribeButton()
                        .getTextFromPopUpErrorMessage();

        assertThat(popUpActualText)
                .as("Pop-up error message doesn't match with expected")
                .isEqualTo("Invalid email address.");

    }
}