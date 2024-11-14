package org.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryPage {

    private static final Logger logger = LoggerFactory.getLogger(InventoryPage.class);
    private WebDriver driver;

    By addToCartButtons = By.xpath("//button[contains(@class, 'btn_inventory')]");
    By shoppingCartButton = By.id("shopping_cart_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllProducts() {
        List<WebElement> products = driver.findElements(addToCartButtons);
        logger.debug("Number of products available: " + products.size());
        return products;
    }

    public void addTwoProductsToCart() {
        List<WebElement> products = getAllProducts();

        if (products.size() >= 2) {
            logger.debug("Adding first product: " + products.get(0).getAttribute("data-test"));
            products.get(0).click();
            logger.debug("Adding second product: " + products.get(1).getAttribute("data-test"));
            products.get(1).click();
        } else {
            logger.error("Less than two products available. Cannot add to cart.");
        }
    }

    public void goToCart() {
        WebElement cartButton = driver.findElement(shoppingCartButton);
        cartButton.click();
        logger.debug("Navigated to cart page.");
    }
}

