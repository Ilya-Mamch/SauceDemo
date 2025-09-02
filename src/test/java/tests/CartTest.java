package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(priority = 1, description = "Проверка добавления товара в корзину",
            testName = "Проверка добавления товара в корзину")
    public void checkCart() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Bike Light")
                .addToCart("Sauce Labs Fleece Jacket");
    }
}
