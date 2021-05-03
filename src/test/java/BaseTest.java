import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.getDriver;

public class BaseTest {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browserName) {
        System.out.println("Current browser is : " + browserName);
        System.out.println("Current thread id : " + Thread.currentThread().getId());

        if(browserName==null){
            browserName="chrome";
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://demo.prestashop.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BasePage.setDriverThreadLocal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }

}
