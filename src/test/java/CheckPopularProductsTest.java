import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class CheckPopularProductsTest extends BaseTest {

    @Test
    public void checkPopularProducts() {

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();

        //TODO use priimitives instead of objects
        int actualPopularProductsSize =
                mainPage.goToFrame()
                        .getPopularProductsSize();


        sa.assertThat(actualPopularProductsSize)
                .as("Popular products size is not 8!")
                .isEqualTo(8);


        Boolean actualPopularProductsName =
                mainPage.havePopularProductsNameFields();



        sa.assertThat(actualPopularProductsName)
                .as("Not all popular products has names!")
                .isTrue();


        Boolean actualPopularProductsPrice =
                mainPage.havePopularProductsPriceFields();

        sa.assertThat(actualPopularProductsPrice)
                .as("Not all popular products has prices!")
                .isTrue();


        List<String> actualPopularProductPriceBiggerThanZero =
                mainPage.arePopularProductsPriceBiggerThanZero();

        sa.assertThat(actualPopularProductPriceBiggerThanZero)
                .as("Some popular product prices are >= 0.00")
                .isNotNull();

        sa.assertAll();
    }
}
