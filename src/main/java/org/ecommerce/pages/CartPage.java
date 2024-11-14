package org.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CartPage {

    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);
    private WebDriver driver;

    By removeButtons = By.xpath("//button[contains(@class, 'cart_button')]");
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllProductsInCart() {
        List<WebElement> products = driver.findElements(removeButtons);
        logger.debug("Number of products in the cart: " + products.size());
        return products;
    }


    public void removeLastProduct() {
        List<WebElement> products = getAllProductsInCart();

        if (!products.isEmpty()) {
            WebElement lastProduct = products.get(products.size() - 1);
            logger.debug("Removing product: " + lastProduct.getAttribute("data-test"));
            lastProduct.click();
        } else {
            logger.error("No products found in the cart to remove.");
        }
    }

    public void clickCheckoutButton() {

        WebElement checkoutBtn = driver.findElement(checkoutButton);
        checkoutBtn.click();
        System.out.println("test url(cardpage): " + driver.getCurrentUrl());
        logger.debug("Clicked on the checkout button.");
    }
}
