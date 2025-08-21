package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test(testName = "Проверка входа в магазин с позитивными данными",
            description = "Проверка входа в магазин с позитивными данными", priority = 1, invocationCount = 1,
            threadPoolSize = 2, groups = {"smoke"})

    @Description("Проверка входа в магазин с позитивными данными")
    @Owner("Ilya Mamchyk")
    @Link("https://allurereport.org/docs/testing/")
    @Epic("SauceDemo Login Page")
    @Feature("Log in")
    @Story("Log in with positive cred")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Bill Geitz")
    @TmsLink("SD-01")
    @Issue("SD_01/1")
    public void checkPositiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
    }

    @Test(enabled = false, testName = "Проверка авторизации без ввода пароля",
            description = "Проверка авторизации без ввода пароля", priority = 2)
    public void checkLoginWithEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.gerErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не соответствует");
    }

    @Test(testName = "Проверка входа в магазин с пустым именем пользователя",
            description = "Проверка входа в магазин с пустым именем пользователя", priority = 2)
    public void checkLoginWithEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.gerErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не соответсвует");
    }

    @Test(testName = "Проверка входа в магазин с пустыми полями",
            description = "Проверка входа в магазин с пустыми полями",
            retryAnalyzer = Retry.class, priority = 2)
    public void checkLoginWithNegative() {
        loginPage.open();
        loginPage.login("123", "123");
        assertEquals(loginPage.gerErrorMessage(),
                "Epic sadface: Username and password do not match any user in this servic",
                "Сообщение об ошибке не соответсвует");
    }

    @DataProvider(name = "Проверка логина с негативными данными")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Проверка логина с негативными данными",
            description = "Проверка логина с негативными данными", priority = 3)
    public void paramNegativeTest(String user, String password, String expectedErrorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.gerErrorMessage(),
                expectedErrorMessage,
                "Сообщение об ошибке не соответствует");
    }
}
