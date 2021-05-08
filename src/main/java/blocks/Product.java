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
    public WebElement productPriceWE;

    public Product() {
    }

    public Product(WebElement container) {
        // if(container.getAttribute("innerHTML").contains("disconte")){
        //    this.discountPrice = Double.valueOf(container.findElement(By.xpath(".//x[=pathForPrice")).getText());
        // }
        this.productName = container.findElement(By.xpath(".//div[@class='products row']//a[@itemprop='url']")).getText();
        this.regularPrice = Double.valueOf(container
                .findElement(By.xpath("//div[@class='products row']//span[@class='price']"))
                .getText().replace("€", ""));
        this.productNameWE = container.findElement(By.xpath(".//div[@class='products row']//a[@itemprop='url']"));
        this.productPriceWE = container.findElement(By.xpath("//div[@class='products row']//span[@class='price']"));

    }


    public int getCountOfAllPopularProducts(List<WebElement> containers) {
        List<Product> allPopularProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allPopularProducts.add(new Product(container));
        }
        return allPopularProducts.size();
    }

    public List<Product> getAllPopularProducts(List<WebElement> containers) {
        List<Product> allPopularProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allPopularProducts.add(new Product(container));
        }
        return allPopularProducts;
    }
}
