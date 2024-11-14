package org.ecommerce;

import org.ecommerce.config.WebDriverConfig;
import org.ecommerce.pages.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.AssertJUnit.assertTrue;
public class EcommerceTest {
    private static final Logger logger = LoggerFactory.getLogger(EcommerceTest.class);

    private WebDriver driver;
    private LoginPage loginPage;

    private final String URL = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        driver = WebDriverConfig.initializeDriver();

        loginPage = new LoginPage(driver);

        driver.get(URL);
    }

    @Test
    public void testLogin() {

        loginPage.login("standard_user","secret_sauce");

        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("https://www.saucedemo.com/inventory.html"));
        //Logger.debug("Login completed, accessing page: ", currentUrl);
    }

    @Test
    public void testAddtoCard() {
        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addTwoProductsToCart();
        inventoryPage.goToCart();

        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("https://www.saucedemo.com/cart.html"));
        //Logger.debug("Login completed, accessing page: ", currentUrl);
    }

    @Test
    public void testRemoveProduct() {
        CartPage cartPage = new CartPage(driver);

        cartPage.removeLastProduct();
        cartPage.clickCheckoutButton();

        String currentUrl = driver.getCurrentUrl();

        //assertTrue(currentUrl.contains("https://www.saucedemo.com/checkout-step-one.html"));
        System.out.println("passou aqui");
    }

    @Test
    public void testFillInformation() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillCheckoutForm("Name","Second Name");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();

        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("https://www.saucedemo.com/checkout-complete.html"));
        //Logger.debug("Login completed, accessing page: ", currentUrl);
    }

    @Test
    public void testTakeScreenshot() {
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        checkoutCompletePage.verifyAndTakeScreenshot();

        String currentUrl = driver.getCurrentUrl();

        //assertTrue(currentUrl.contains("https://www.saucedemo.com/checkout-complete.html"));
        //Logger.debug("Login completed, accessing page: ", currentUrl);
    }

    @After
    public void tearDown() {
        WebDriverConfig.closeDriver();
    }

    public static void main(String[] args) {
        EcommerceTest ecommerceTest = new EcommerceTest();

        try {
            ecommerceTest.setUp();

            ecommerceTest.testLogin();

            ecommerceTest.testAddtoCard();

            ecommerceTest.testRemoveProduct();

            ecommerceTest.testFillInformation();

            ecommerceTest.testTakeScreenshot();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ecommerceTest.tearDown();
        }
    }
}