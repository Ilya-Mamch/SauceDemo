package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {
    private final By COMPLETE_TITLE = By.className("title");
    private final By COMPLETE_HEADER = By.className("complete-header");
    private final By COMPLETE_TEXT = By.className("complete-text");
    private final By COMPLETE_BUTTON = By.id("back-to-products");
    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "checkout-complete.html");
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

    public void clickButton() {
        driver.findElement(COMPLETE_BUTTON).click();
    }
}
