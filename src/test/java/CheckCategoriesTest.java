import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckCategoriesTest extends BaseTest {

    @Test
    public void CheckCategories() {

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();

        boolean actualMenCategoryIsDisplaying =
                mainPage.goToFrame()
                        .hoverOverClothesLink()
                        .isMenCategoryAppears();

        boolean actualWomenCategoryIsDisplaying =
                mainPage.hoverOverClothesLink()
                        .isWomenCategoryAppears();

        sa.assertThat(actualMenCategoryIsDisplaying)
                .as("The Men subcategory is not displaying!")
                .isTrue();
        sa.assertThat(actualWomenCategoryIsDisplaying)
                .as("The Women subcategory is not displaying!")
                .isTrue();


        boolean actualStationeryCategoryIsDisplaying =
                mainPage.hoverOverAccessoriesMenu()
                        .isStationeryCategoryAppears();

        boolean actualHomeAccessoriesCategoryIsDisplaying =
                mainPage.hoverOverAccessoriesMenu()
                        .isHomeAccessoriesCategoryAppears();

        sa.assertThat(actualStationeryCategoryIsDisplaying)
                .as("The Stationery subcategory is not displaying!")
                .isTrue();
        sa.assertThat(actualHomeAccessoriesCategoryIsDisplaying)
                .as("The Home Accessories subcategory is not displaying!")
                .isTrue();


        boolean actualArtCategoriesIsDisplaying =
                mainPage.hoverOverArtMenu()
                        .isAnySubCategoriesAppears();

        sa.assertThat(actualArtCategoriesIsDisplaying)
                .as("There are some subcategories under the Art menu!")
                .isFalse();

        sa.assertAll();

    }

}
