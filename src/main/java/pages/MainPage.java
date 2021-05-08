package pages;

import blocks.Product;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@Slf4j

public class MainPage extends BasePage {


    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//input[contains(@class,'hidden-xs-down')]")
    private WebElement subscribeButton;

    @FindBy(xpath = "//p[contains(@class,'block_newsletter_alert')]")
    private WebElement popUpErrorMessage;

    @FindBy(xpath = "//div[@id='_desktop_language_selector']//i")
    private WebElement expandLanguagesDropdownButton;

    @FindBy(xpath = "//ul[contains(@class,'hidden-sm-down')]//li")
    private List<WebElement> listOfLanguagesInDropdown;

    @FindBy(xpath = "//a[contains(@title,'Log in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='_desktop_user_info']//span[@class='hidden-sm-down']")
    private WebElement userName;

    @FindBy(xpath = "//li[@id='category-3']")
    private WebElement clothesMenu;

    @FindBy(xpath = "//li[@id='category-4']")
    private WebElement menCategory;

    @FindBy(xpath = "//li[@id='category-5']")
    private WebElement womenCategory;

    @FindBy(xpath = "//li[@id='category-6']")
    private WebElement accessoriesMenu;

    @FindBy(xpath = "//li[@id='category-7']")
    private WebElement stationeryCategory;

    @FindBy(xpath = "//li[@id='category-8']")
    private WebElement homeAccessoriesCategory;

    @FindBy(xpath = "//li[@id='category-9']")
    private WebElement artMenu;

    @FindBy(xpath = "//li[@id='category-9']//li")
    private List<WebElement> artSubCategories;

    @FindBy(xpath = "//div[@class='products row']//div[@class='product']")
    private List<WebElement> popularProductsList;

    @FindBy(xpath = "//div[@class='products row']//a[@itemprop='url']")
    private List<WebElement> popularProductsName;

    @FindBy(xpath = "//div[@class='products row']//span[@class='price']")
    private List<WebElement> popularProductsPrice;


    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage scrollToElement() {
        log.info("Scroll to email address input element on the main page");
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", emailAddressInput);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    public MainPage goToFrame() {
        log.info("Switching to the separate page frame");
        getDriver().switchTo().frame("framelive");
        return this;
    }

    public MainPage clickOnEmailAddressInput() {
        log.info("Clicking on the email address input element");
        emailAddressInput.click();
        return this;
    }

    public MainPage setEmail(String email) {
        log.info("Enter the {} into email address input field", email);
        emailAddressInput.sendKeys(email);
        return this;
    }

    public MainPage clickOnSubscribeButton() {
        log.info("Clicking on the Subscribe button");
        subscribeButton.click();
        return this;
    }

    public String getTextFromPopUpErrorMessage() {
        log.info("Getting text from the pop-up error message");
        return popUpErrorMessage.getText();

    }

    public MainPage clickOnLanguagesDropdown() {
        log.info("Clicking on the languages dropdown to open the list");
        expandLanguagesDropdownButton.click();
        return this;
    }

    public Integer getAllLanguagesCountFromDropdown() {
        log.info("Getting size of the list of languages from the dropdown");
        return listOfLanguagesInDropdown.size();

    }

    public List<String> findLanguages() {
        log.info("Checking the list on presence of the specific language");
        List<String> presenceLanguage = new ArrayList<>();
        for (WebElement language : listOfLanguagesInDropdown) {
            presenceLanguage.add(language.getText());
        }
        return presenceLanguage;
    }

    public LogInPage clickOnSignInButton() {
        log.info("Click on the sign-in button to confirm registration");
        signInButton.click();
        return new LogInPage();
    }

    public String getUserName() {
        return userName.getText();
    }


    Actions actions = new Actions(getDriver());

    public MainPage hoverOverClothesLink() {
        actions.moveToElement(clothesMenu).build().perform();
        return this;
    }

    public MainPage hoverOverLink(String linkName) {
        String categoryId = null;
        switch (linkName) {
            case "MAN":
                categoryId = "1";
                break;
            case "WOMAN":
                categoryId = "2";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        actions.moveToElement(getDriver().findElement(By.xpath(baseXpath))).build().perform();
        return this;
    }


    public boolean isMenCategoryAppears() {
        return menCategory.isDisplayed();
    }

    public boolean isWomenCategoryAppears() {
        return womenCategory.isDisplayed();
    }

    public MainPage hoverOverAccessoriesMenu() {
        actions.moveToElement(accessoriesMenu).build().perform();
        return this;
    }

    public boolean isStationeryCategoryAppears() {
        return stationeryCategory.isDisplayed();
    }

    public boolean isHomeAccessoriesCategoryAppears() {
        return homeAccessoriesCategory.isDisplayed();
    }

    public MainPage hoverOverArtMenu() {
        actions.moveToElement(artMenu).build().perform();
        return this;
    }

    public boolean isAnySubCategoriesAppears() {
        return artSubCategories.size() != 0;
    }

    public int getPopularProductsSize() {
        return popularProductsList.size();
    }

    public boolean havePopularProductsNameFields() {
        List<String> names = new ArrayList<>();
        for (WebElement e : popularProductsName) {
            names.add(e.getText());
        }
        return names.size() == popularProductsList.size();
    }

    public boolean havePopularProductsPriceFields() {
        List<String> prices = new ArrayList<>();
        for (WebElement e : popularProductsName) {
            prices.add(e.getText());
        }
        return prices.size() == popularProductsList.size();
    }

    public List<String> arePopularProductsPriceBiggerThanZero() {
        List<String> prices = new ArrayList<>();
        for (WebElement e : popularProductsName) {
            prices.add(e.getText());
        }
        return prices;

    }


    //for popular products

    public List<String> getAllNamesFromProducts() {
        Product product = new Product();
        product.getAllPopularProducts(containers);
    }

}
