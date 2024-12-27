package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoginPage;
import org.example.SortProducts;
import org.testng.Assert;
import testComponent.BaseTest;

public class sortProductStepDefinition extends BaseTest {
    private LoginPage loginPage;
    private SortProducts sortProducts;

    @Given("User is logged in with username {string} and password {string}")
    public void user_is_logged_in_with_username_and_password(String username, String password) {
        initializeDriver();
        goTo();
        loginPage = new LoginPage(driver);
        loginPage.setEmail(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();
    }

    @When("User sorts the products by {string}")
    public void user_sorts_the_products_by(String sortingOption) {
        sortProducts = new SortProducts(driver);
    }

    @Then("The product list should be sorted by price in descending order")
    public void the_product_list_should_be_sorted_by_price_in_descending_order() {
        Assert.assertEquals(sortProducts.getPriceProductList(), sortProducts.sortDescedingProduct());
    }

    @Then("Close the browser")
    public void close_the_browser() {
        tearDown();
    }
}
