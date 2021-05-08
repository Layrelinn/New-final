import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

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

        List<Product> productCharacteristics = mainPage.getAllPopularProducts();

        for (Product product : productCharacteristics) {
            sa.assertThat(product.productNameWE.isDisplayed())
                    .as("Not all popular products has names!");
            sa.assertThat(product.regularPriceWE.isDisplayed())
                    .as("Not all popular products has prices!");
            double actualPrice = product.regularPrice;
            sa.assertThat(actualPrice).isGreaterThan(0.00)
                    .as("Some popular product prices are <= 0.00");
        }

        sa.assertAll();
    }
}
