package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class OverviewPage extends BasePage {
    private final By OVERVIEW_TITLE = By.className("title");
    private final By OVERVIEW_ITEM_NAME = By.className("inventory_item_name");
    private final By OVERVIEW_ITEM_PRICE = By.className("inventory_item_price");
    private final By OVERVIEW_PAYMENT_INFO = By.xpath("//div[@class='summary_info']" +
            "//div[@class='summary_value_label'][1]");
    private final By OVERVIEW_SHIPPING_INFO = By.xpath("//div[@class='summary_info']" +
            "//div[@class='summary_value_label'][2]");
    private final By OVERVIEW_TOTAL_PRICE = By.className("summary_total_label");
    private final By OVERVIEW_CANCEL_BUTTON = By.id("cancel");
    private final By OVERVIEW_FINISH_BUTTON = By.id("finish");
    private final By OVERVIEW_PRODUCT_CARD = By.className("inventory_item_name");
    private final By OVERVIEW_TAX = By.className("summary_tax_label");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public OverviewPage open() {
        driver.get(BASE_URL + "checkout-step-two.html");
        log.info("Opening Overview page");
        return this;
    }

    public String getOverviewTitle() {
        return driver.findElement(OVERVIEW_TITLE).getText();
    }

    public String getOverviewItemName() {
        return driver.findElement(OVERVIEW_ITEM_NAME).getText();
    }

    public String getOverviewItemPrice() {
        return driver.findElement(OVERVIEW_ITEM_PRICE).getText();
    }

    public String getPaymentInfo() {
        return driver.findElement(OVERVIEW_PAYMENT_INFO).getText();
    }

    public String getShippingInfo() {
        return driver.findElement(OVERVIEW_SHIPPING_INFO).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(OVERVIEW_TOTAL_PRICE).getText();
    }

    public ProductsPage clickCancel() {
        driver.findElement(OVERVIEW_CANCEL_BUTTON).click();
        log.info("Click cancel button");
        return new ProductsPage(driver);
    }

    public CompletePage clickFinish() {
        driver.findElement(OVERVIEW_FINISH_BUTTON).click();
        log.info("Click finish button");
        return new CompletePage(driver);
    }

    public void clickProductCard() {
        driver.findElement(OVERVIEW_PRODUCT_CARD).click();
        log.info("Click product");
    }

    public String getTax() {
        return driver.findElement(OVERVIEW_TAX).getText();
    }
}
