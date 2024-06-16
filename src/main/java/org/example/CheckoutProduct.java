package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutProduct extends LoginPage {
    public CheckoutProduct(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
    List<WebElement> listItems;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productName;

    @FindBy(xpath = "//button[text()='Add to cart']")
    WebElement addButton;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(name = "firstName")
    WebElement inputFirstName;

    @FindBy(name = "lastName")
    WebElement inputLastName;

    @FindBy(name = "postalCode")
    WebElement inputPostalCode;

    @FindBy(name = "continue")
    WebElement continueButton;

    @FindBy(name = "finish")
    WebElement finishButton;

    public void addToCart() {
        List<WebElement> products = productName.stream().limit(2).collect(Collectors.toList());
        for (WebElement product : products) {
            addButton.click();
        }
        cartIcon.click();
    }

    public void checkoutProduct(String firstName, String lastName, String postalCode) {
        checkoutButton.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
        continueButton.click();
        finishButton.click();
    }
}
