package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Product {

    public String productName;
    public Double regularPrice;
    //public Double discountPrice;
    public WebElement productNameWE;
    public WebElement regularPriceWE;

    public Product() {
    }

    public Product(WebElement container) {
        this.productName = container.findElement(By.xpath(".//a[@itemprop='url']")).getText();
        this.regularPrice = Double.valueOf(container
                .findElement(By.xpath(".//span[@class='price']"))
                .getText().replace("€", ""));
        this.productNameWE = container.findElement(By.xpath(".//a[@itemprop='url']"));
        this.regularPriceWE = container.findElement(By.xpath(".//span[@class='price']"));
    }

    public int getCountOfAllProducts(List<WebElement> containers) {
        List<Product> allProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allProducts.add(new Product(container));
        }
        return allProducts.size();
    }

    public static List<Product> getAllProducts (List<WebElement> containers) {
        List<Product> allProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allProducts.add(new Product(container));
        }
        return allProducts;
    }
}
