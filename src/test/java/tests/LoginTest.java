package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{
    @Test
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
//        String errorMessage = loginPage.gerErrorMessage();
//        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");
        assertEquals(loginPage.gerErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не соответсвует");
    }

    @Test
    public void checkLoginWithEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.gerErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не соответсвует");
    }

    @Test
    public void checkLoginWithNegative() {
        loginPage.open();
        loginPage.login("123", "123");
        assertEquals(loginPage.gerErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не соответсвует");
    }
}
