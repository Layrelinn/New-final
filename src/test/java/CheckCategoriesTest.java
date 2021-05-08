import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class CheckCategoriesTest extends BaseTest {

    @Test
    public void checkCategories() {

        //TODO add switch case and remove duplicate methods and locators

        MainPage mainPage = new MainPage();
        SoftAssertions sa = new SoftAssertions();

        boolean actualMenCategoryIsDisplaying = //TODO is at start
                mainPage.goToFrame()
                        .hoverOverLink("MAN")
                        .isMenCategoryAppears(); //TODO rename to isCategoryAppear("MAN")

        boolean actualWomenCategoryIsDisplaying =
                mainPage.hoverOverLink("WONAM")
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
