package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutPage extends BasePage {
    private final By CHECKOUT_TITLE = By.className("title");
    private final By CHECKOUT_FIRST_NAME = By.id("first-name");
    private final By CHECKOUT_LAST_NAME = By.id("last-name");
    private final By CHECKOUT_ZIP_CODE = By.id("postal-code");
    private final By CHECKOUT_CANCEL_BUTTON = By.id("cancel");
    private final By CHECKOUT_CONTINUE_BUTTON = By.id("continue");
    private final By CHECKOUT_ERROR = By.cssSelector("[data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage open() {
        driver.get(BASE_URL + "checkout-step-one.html");
        log.info("Opening Checkout page");
        return this;
    }

    public String getTitleCheckout() {
        return driver.findElement(CHECKOUT_TITLE).getText();
    }

    public CheckoutPage setFirstName(String firstName) {
        driver.findElement(CHECKOUT_FIRST_NAME).sendKeys(firstName);
        log.info("Set first name");
        return this;
    }

    public CheckoutPage setLastName(String lastName) {
        driver.findElement(CHECKOUT_LAST_NAME).sendKeys(lastName);
        log.info("Set last name");
        return this;
    }

    public CheckoutPage setZipCode(String zipCode) {
        driver.findElement(CHECKOUT_ZIP_CODE).sendKeys(zipCode);
        log.info("Set ZipCod");
        return this;
    }

    public CartPage clickCancel() {
        driver.findElement(CHECKOUT_CANCEL_BUTTON).click();
        log.info("Click cancel button");
        return new CartPage(driver);
    }

    public OverviewPage clickContinue() {
        driver.findElement(CHECKOUT_CONTINUE_BUTTON).click();
        log.info("Click continue button");
        return new OverviewPage(driver);
    }

    public CheckoutPage fillAllInfo(String firstName, String lastName, String zipCode) {
        log.info("Fill all info with cred {}, {}, {}", firstName, lastName, zipCode);
        setFirstName(firstName);
        setLastName(lastName);
        setZipCode(zipCode);
        return this;
    }

    public String getError() {
        return driver.findElement(CHECKOUT_ERROR).getText();
    }
}
