package org.example.tests;

import org.example.LoginPage;
import org.example.SortProducts;
import org.example.testComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortProductsTest extends BaseTest {
    @Test
    public void successSortHighLow(){
        goTo();
        LoginPage lp = new LoginPage(driver);
        lp.setEmail("standard_user");
        lp.setPassword("secret_sauce");
        lp.clickSubmit();
        SortProducts sp = new SortProducts(driver);

        Assert.assertEquals(sp.getPriceProductList(), sp.sortDescedingProduct());
    }
}
