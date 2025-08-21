package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {
    @Test(testName = "Проверка позитивного завершения покупки товара",
            description = "Проверка позитивного завершения покупки товара",
            priority = 1)
    public void checkPositiveCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.clickCheckout();
        checkoutPage.fillAllInfo("Ilya", "Mamchyk", "220076");
        checkoutPage.clickContinue();
        overviewPage.clickFinish();
        assertEquals(completePage.getCompleteTitle(),
                "Checkout: Complete!",
                "Покупка не прошла");
    }

    @Test(testName = "Проверка покупки товара с пустыми полями",
            description = "Проверка покупки товара с пустыми полями",
            priority = 4)
    public void checkEmptyFields() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.clickCheckout();
        checkoutPage.fillAllInfo("", "", "");
        checkoutPage.clickContinue();
        assertEquals(checkoutPage.getError(),
                "Error: First Name is required");
    }

    @Test(testName = "Проверка покупки товара с незаполненным именем",
            description = "Проверка покупки товара с незаполненным именем",
            priority = 5)
    public void checkEmptyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.clickCheckout();
        checkoutPage.clickCancel();
        assertEquals(cartPage.getCartTitle(),
                "Your Cart");
    }

    @Test(testName = "Проверка общей цены", description = "Проверка общей цены", priority = 2)
    public void checkTotalPrice() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.clickCheckout();
        checkoutPage.fillAllInfo("Ilya", "Mamchyk", "220076");
        checkoutPage.clickContinue();
        assertEquals(overviewPage.getTotalPrice(),
                "Total: $10.79");
    }

    @Test(testName = "Проверка налога товара", description = "Проверка налога товара", priority = 3)
    public void getProductCard() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.clickCheckout();
        checkoutPage.fillAllInfo("Ilya", "Mamchyk", "220076");
        checkoutPage.clickContinue();
        assertEquals(overviewPage.getTax(), "Tax: $0.80");
    }
}
