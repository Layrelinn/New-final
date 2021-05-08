import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckCategoriesTest extends BaseTest {

    @Test
    public void checkCategories() {

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();

        boolean isMenCategoryDisplaying =
                mainPage.hoverOverTopMenuLinks("CLOTHES")
                        .isCategoryDisplaying("MEN");

        boolean isWomenCategoryDisplaying =
                mainPage.hoverOverTopMenuLinks("CLOTHES")
                        .isCategoryDisplaying("WOMEN");

        sa.assertThat(isMenCategoryDisplaying)
                .as("The Men subcategory is not displaying!")
                .isTrue();
        sa.assertThat(isWomenCategoryDisplaying)
                .as("The Women subcategory is not displaying!")
                .isTrue();

        boolean isStationeryCategoryDisplaying =
                mainPage.hoverOverTopMenuLinks("ACCESSORIES")
                        .isCategoryDisplaying("STATIONERY");

        boolean isHomeAccessoriesCategoryDisplaying =
                mainPage.hoverOverTopMenuLinks("ACCESSORIES")
                        .isCategoryDisplaying("HOME_ACCESSORIES");

        sa.assertThat(isStationeryCategoryDisplaying)
                .as("The Stationery subcategory is not displaying!")
                .isTrue();
        sa.assertThat(isHomeAccessoriesCategoryDisplaying)
                .as("The Home Accessories subcategory is not displaying!")
                .isTrue();

        boolean isArtCategoriesDisplaying =
                mainPage.hoverOverTopMenuLinks("ART")
                        .isAnySubCategoriesAppears();

        sa.assertThat(isArtCategoriesDisplaying)
                .as("There are some subcategories under the Art menu!")
                .isFalse();

        sa.assertAll();

    }
}
