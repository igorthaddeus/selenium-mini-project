package tests;

import org.example.LoginPage;
import testComponent.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends BaseTest {
    private LoginPage lp;

    @BeforeMethod
    public void setUp() {
        goTo();
        lp = new LoginPage(driver);
    }

    @Test(dataProvider = "getData")
    public void successLogin(HashMap<String, String> input) throws InterruptedException {
        lp.setEmail(input.get("username"));
        lp.setPassword(input.get("password"));
        lp.clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className("app_logo")).getText(), "Swag Labs");
    }
    @Test
    public void failedLogin() throws InterruptedException {
        lp.setEmail("test");
        lp.setPassword("test");
        lp.clickSubmit();
        Assert.assertEquals(driver.findElement(By.cssSelector("h3[data-test='error']")).getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap("C:\\Users\\Igor\\SYNRGY_WebAutomation\\src\\test\\java\\org\\example\\data\\LoginData.json");
        return new Object[][] {
                {data.get(0)},
                {data.get(2)},
                {data.get(3)},
                {data.get(4)},
                {data.get(5)},
        };
    }
}
