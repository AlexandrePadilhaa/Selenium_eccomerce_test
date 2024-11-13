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

    private final String URL = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        driver = WebDriverConfig.initializeDriver();

        loginPage = new LoginPage(driver);

        driver.get(URL);
    }

    @Test
    public void testLogin() {

        assertTrue(true);
    }

    @After
    public void tearDown() {
        WebDriverConfig.closeDriver();
    }
}