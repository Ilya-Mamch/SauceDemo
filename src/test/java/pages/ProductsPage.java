package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends BasePage {
    private final By TITLE = By.className("title");
    public final String ADD_TO_CART_PATTERN = "//*[text()='%s']/" +
            "ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage open() {
        driver.get(BASE_URL + "inventory.html");
        log.info("Opening Product page");
        return this;
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        log.info("Add product to cart");
        return this;
    }
}


