package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortProducts extends LoginPage {
    WebDriver driver;

    public SortProducts(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_price")
    List<WebElement> priceProducts;

    public List<Double> getPriceProductList() {
        List<Double> priceProductList = priceProducts.stream()
                .map(s -> Double.valueOf(s.getText().replace("$", "")))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return priceProductList;
    }

    public List<Double> sortDescedingProduct() {
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");

        List<Double> sortedProducts = priceProducts.stream()
                .map(s -> Double.valueOf(s.getText().replace("$", "")))
                .collect(Collectors.toList());

        return sortedProducts;
    }
}
