package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends BasePage {
    private final By CART_TITLE = By.className("title");
    private final By CART_ITEM_NAME = By.className("inventory_item_name");
    private final By CART_ITEM_PRICES = By.className("inventory_item_price");
    private final By CART_REMOVE_BUTTON = By.cssSelector("button.cart_button");
    private final By CART_CHECKOUT_BUTTON = By.cssSelector("button.checkout_button");
    private final By CART_CONTINUE_BUTTON = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage open() {
        driver.get(BASE_URL + "cart.html");
        log.info("Opening Cart page");
        return this;
    }

    public String getCartTitle() {
        return driver.findElement(CART_TITLE).getText();
    }

    public String getCartName() {
        return driver.findElement(CART_ITEM_NAME).getText();
    }

    public String getCartPrice() {
        return driver.findElement(CART_ITEM_PRICES).getText();
    }

    public CartPage clickRemove() {
        driver.findElement(CART_REMOVE_BUTTON).click();
        log.info("Click remove button");
        return this;
    }

    public CheckoutPage clickCheckout() {
        driver.findElement(CART_CHECKOUT_BUTTON).click();
        log.info("Click checkout button");
        return new CheckoutPage(driver);
    }

    public ProductsPage clickContinue() {
        driver.findElement(CART_CONTINUE_BUTTON).click();
        log.info("Click continue button");
        return new ProductsPage(driver);
    }
}
