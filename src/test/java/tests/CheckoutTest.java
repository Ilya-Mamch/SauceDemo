package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {
    @Test
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

    @Test
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

    @Test
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

    @Test
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

    @Test
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
