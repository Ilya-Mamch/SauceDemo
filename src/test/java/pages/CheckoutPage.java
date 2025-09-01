package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public void open() {
        driver.get(BASE_URL + "checkout-step-one.html");
    }

    public String getTitleCheckout() {
        return driver.findElement(CHECKOUT_TITLE).getText();
    }

    public void setFirstName(String firstName) {
        driver.findElement(CHECKOUT_FIRST_NAME).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(CHECKOUT_LAST_NAME).sendKeys(lastName);
    }

    public void setZipCode(String zipCode) {
        driver.findElement(CHECKOUT_ZIP_CODE).sendKeys(zipCode);
    }

    public void clickCancel() {
        driver.findElement(CHECKOUT_CANCEL_BUTTON).click();
    }

    public void clickContinue() {
        driver.findElement(CHECKOUT_CONTINUE_BUTTON).click();
    }

    public void fillAllInfo(String firstName, String lastName, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setZipCode(zipCode);
    }

    public String getError(){
        return driver.findElement(CHECKOUT_ERROR).getText();
    }
}
