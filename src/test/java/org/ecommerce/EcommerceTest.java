package org.ecommerce;

import org.ecommerce.config.WebDriverConfig;
import org.ecommerce.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.After;

import static org.testng.AssertJUnit.assertTrue;
public class EcommerceTest {

    private WebDriver driver;
    private LoginPage loginPage;

    private final String URL = "https://practicetestautomation.com/practice-test-login/";

    @Before
    public void setUp() {
        driver = WebDriverConfig.initializeDriver();

        loginPage = new LoginPage(driver);

        driver.get(URL);
    }

    @Test
    public void testLogin() {

        loginPage.login("student","Password123");
        assertTrue(true);

        String currentUrl = driver.getCurrentUrl();

        assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully/"));
        //assertTrue(true);
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

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ecommerceTest.tearDown();
        }
    }
}