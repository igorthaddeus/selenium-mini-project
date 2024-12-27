package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CheckoutProduct;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import testComponent.BaseTest;

public class checkoutProductStepDefinition extends BaseTest {
    private LoginPage loginPage;
    private CheckoutProduct checkoutProduct;

    @Given("User is logged in with username {string} and password {string}")
    public void user_is_logged_in_with_username_and_password(String username, String password) {
        initializeDriver(); 
        goTo();            
        loginPage = new LoginPage(driver);
        loginPage.setEmail(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();
    }

    @When("User adds two products to the cart")
    public void user_adds_two_products_to_the_cart() {
        checkoutProduct = new CheckoutProduct(driver);
        checkoutProduct.addToCart();
    }

    @When("User completes checkout with first name {string}, last name {string}, and postal code {string}")
    public void user_completes_checkout_with_first_name_last_name_and_postal_code(String firstName, String lastName, String postalCode) {
        checkoutProduct.checkoutProduct(firstName, lastName, postalCode);
    }

    @Then("User should see the confirmation message {string}")
    public void user_should_see_the_confirmation_message(String confirmationMessage) {
        String actualMessage = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(actualMessage, confirmationMessage);
    }

    @Then("Close the browser")
    public void close_the_browser() {
        tearDown();
    }
}
