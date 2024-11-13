package org.ecommerce;

import org.ecommerce.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.initializeDriver();

        driver.get("https://www.saucedemo.com/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverConfig.closeDriver();
    }
}