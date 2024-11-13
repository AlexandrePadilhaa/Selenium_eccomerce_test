package org.ecommerce.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class WebDriverConfig {

    private static WebDriver driver;

    public WebDriverConfig() {
        if (driver == null) {
            initializeDriver();
        }
    }

    public static WebDriver initializeDriver() {
        if (driver == null) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

