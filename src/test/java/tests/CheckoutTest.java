package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {
    @Test(testName = "Проверка позитивного завершения покупки товара",
            description = "Проверка позитивного завершения покупки товара",
            priority = 1)
    public void checkPositiveCheckout() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Bike Light");
        cartPage.open()
                .clickCheckout()
                .fillAllInfo("Ilya", "Mamchyk", "220076")
                .clickContinue()
                .clickFinish();
        assertEquals(completePage.getCompleteTitle(),
                "Checkout: Complete!1",
                "Покупка не прошла");
    }

    @Test(testName = "Проверка покупки товара с пустыми полями",
            description = "Проверка покупки товара с пустыми полями",
            priority = 4)
    public void checkEmptyFields() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Bike Light");
        cartPage.open()
                .clickCheckout()
                .fillAllInfo("", "", "")
                .clickContinue();
        assertEquals(checkoutPage.getError(),
                "Error: First Name is required");
    }

    @Test(testName = "Проверка покупки товара с незаполненным именем",
            description = "Проверка покупки товара с незаполненным именем",
            priority = 5)
    public void checkEmptyFirstName() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Bike Light");
        cartPage.open()
                .clickCheckout()
                .clickCancel();
        assertEquals(cartPage.getCartTitle(),
                "Your Cart");
    }

    @Test(testName = "Проверка общей цены", description = "Проверка общей цены", priority = 2)
    public void checkTotalPrice() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Bike Light");
        cartPage.open()
                .clickCheckout()
                .fillAllInfo("Ilya", "Mamchyk", "220076")
                .clickContinue();
        assertEquals(overviewPage.getTotalPrice(),
                "Total: $10.79");
    }

    @Test(testName = "Проверка налога товара", description = "Проверка налога товара", priority = 3)
    public void getProductCard() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Bike Light");
        cartPage.open()
                .clickCheckout()
                .fillAllInfo("Ilya", "Mamchyk", "220076")
                .clickContinue();
        assertEquals(overviewPage.getTax(), "Tax: $0.80");
    }
}
