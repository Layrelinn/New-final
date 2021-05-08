package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Product {

    String name;
    WebElement image;
    Double discountPrice;

    public Product(WebElement container) {
        if(container.getAttribute("innerHTML").contains("disconte")){
            this.discountPrice = Double.valueOf(container.findElement(By.xpath(".//x[=pathForPrice")).getText());
        }
        this.name = container.findElement(By.xpath(".//x[=pathForName")).getText();
        this.image = container.findElement(By.xpath(".//x[=pathForName"));
    }

    public Product() {
    }

    public List<Product> getAllPopularProducts(List<WebElement> containers) { //containers shoud have 8 lements
        List<Product> popularProducts = new ArrayList<>();
        for (WebElement container : containers) {
            popularProducts.add(new Product(container));
        }
        return popularProducts;
    }
}
