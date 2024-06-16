package org.example.tests;

import org.example.CheckoutProduct;
import org.example.LoginPage;
import org.example.testComponent.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void successCheckout(){
        goTo();
        LoginPage lp = new LoginPage(driver);
        lp.setEmail("standard_user");
        lp.setPassword("secret_sauce");
        lp.clickSubmit();
        CheckoutProduct cp = new CheckoutProduct(driver);
        cp.addToCart();

        cp.checkoutProduct("Lilas", "Ikuta", "11270");

        Assert.assertEquals(driver.findElement(By.className("complete-header")).getText(), "Thank you for your order!");
    }
}
