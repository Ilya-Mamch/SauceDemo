import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.className("title")).getText();
        // Boolean titleIsVisible = driver.findElement(By.className("title")).isDisplayed(); - возможна такая реализ.
        Assert.assertEquals(title, "Products");
        // Assert.assertTrue(titleIsVisible); - возможна такая реализ.
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        String price = driver.findElement(By.className("inventory_item_price")).getText();
        Assert.assertEquals(price, "$29.99");
    }
}
