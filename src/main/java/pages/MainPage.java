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

    @FindBy(xpath = "//li[@id='category-9']//li")
    private List<WebElement> artSubCategories;

    @FindBy(xpath = "//div[@class='products row']//div[@class='product']")
    private List<WebElement> popularProductsContainers;

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

    public Integer getCountOfAllLanguagesFromDropdown() {
        log.info("Getting size of the list of languages from the dropdown");
        return listOfLanguagesInDropdown.size();

    }

    public List<String> findLanguages() {
        log.info("Checking the list on presence of the specific language");
        List<String> presenceOfLanguage = new ArrayList<>();
        for (WebElement language : listOfLanguagesInDropdown) {
            presenceOfLanguage.add(language.getText());
        }
        return presenceOfLanguage;
    }

    public LogInPage clickOnSignInButton() {
        log.info("Click on the sign-in button to confirm registration");
        signInButton.click();
        return new LogInPage();
    }

    public String getUserNameFromNavigationBar() {
        return userName.getText();
    }

    Actions actions = new Actions(getDriver());

    public MainPage hoverOverTopMenuLinks(String linkName) {
        String categoryId = null;
        switch (linkName) {
            case "CLOTHES":
                categoryId = "3";
                break;
            case "ACCESSORIES":
                categoryId = "6";
                break;
            case "ART":
                categoryId = "9";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        actions.moveToElement(getDriver().findElement(By.xpath(baseXpath))).build().perform();
        return this;
    }

    public boolean isCategoryDisplaying (String linkName) {
        String categoryId = null;
        switch (linkName) {
            case "MEN":
                categoryId = "4";
                break;
            case "WOMEN":
                categoryId = "5";
                break;
            case "STATIONERY":
                categoryId = "7";
                break;
            case "HOME_ACCESSORIES":
                categoryId = "8";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        return getDriver().findElement(By.xpath(baseXpath)).isDisplayed();
    }

    public boolean isAnySubCategoriesAppears() {
        return artSubCategories.size() != 0;
    }

    public int getPopularProductsSize() {
        Product product = new Product();
        int productsOnPage = product.getCountOfAllPopularProducts(popularProductsContainers);
        return productsOnPage;
    }

    public List<Product> getAllPopularProducts() {
        Product product = new Product();
        List<Product> allProductsOnMainPage = product.getAllPopularProducts(popularProductsContainers);
        return allProductsOnMainPage;
    }

    public boolean isEveryProductHasName () {
        Product product = new Product();
          return product.productNameWE.isDisplayed();

    }

    public boolean isEveryProductHasPrice () {
        Product product = new Product();
        return product.productPriceWE.isDisplayed();
    }

    public boolean arePopularProductsPriceBiggerThanZero() {
        Product product = new Product();
        double zero = 0.00;
        return product.regularPrice > zero;
    }

}
