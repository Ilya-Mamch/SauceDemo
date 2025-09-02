package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CompletePage extends BasePage {
    private final By COMPLETE_TITLE = By.className("title");
    private final By COMPLETE_HEADER = By.className("complete-header");
    private final By COMPLETE_TEXT = By.className("complete-text");
    private final By COMPLETE_BUTTON = By.id("back-to-products");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public CompletePage open() {
        driver.get(BASE_URL + "checkout-complete.html");
        log.info("Opening Checkout page");
        return this;
    }

    public String getCompleteTitle() {
        return driver.findElement(COMPLETE_TITLE).getText();
    }

    public String getCompleteHeader() {
        return driver.findElement(COMPLETE_HEADER).getText();
    }

    public String getCompleteText() {
        return driver.findElement(COMPLETE_TEXT).getText();
    }

    public ProductsPage clickButton() {
        driver.findElement(COMPLETE_BUTTON).click();
        log.info("Click back to product button");
        return new ProductsPage(driver);
    }
}