import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckPopularProductsTest extends BaseTest {

    @Test
    public void checkPopularProducts() {

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();

        int actualPopularProductsSize =
                mainPage.getPopularProductsSize();

        sa.assertThat(actualPopularProductsSize)
                .as("Popular products size is not 8!")
                .isEqualTo(8);

        boolean isProductsHaveNames = mainPage.isEveryProductHasName();

        sa.assertThat(isProductsHaveNames)
                .as("Not all popular products has names!")
                .isTrue();

        boolean isProductsHavePrices =
                mainPage.isEveryProductHasPrice();

        sa.assertThat(isProductsHavePrices)
                .as("Not all popular products has prices!")
                .isTrue();

        boolean areProductPricesGreaterThatZero = mainPage.arePopularProductsPriceBiggerThanZero();

        sa.assertThat(areProductPricesGreaterThatZero)
                .as("Some popular product prices are >= 0.00")
                .isTrue();

        sa.assertAll();
    }
}
