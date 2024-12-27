package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import testComponent.BaseTest;

public class loginStepDefinition extends BaseTest {
    private LoginPage loginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        initializeDriver(); 
        goTo();           
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        loginPage.setEmail(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();
    }

    @When("User enters invalid username {string} and password {string}")
    public void user_enters_invalid_username_and_password(String username, String password) {
        loginPage.setEmail(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();
    }

    @Then("User should see the home page with title {string}")
    public void user_should_see_the_home_page_with_title(String title) {
        String actualTitle = driver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(actualTitle, title);
    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String errorMessage) {
        String actualError = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(actualError, errorMessage);
    }

    @Then("Close the browser")
    public void close_the_browser() {
        tearDown(); 
    }
}
