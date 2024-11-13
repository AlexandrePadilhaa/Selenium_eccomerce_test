package org.ecommerce;

import org.ecommerce.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.initializeDriver();

        driver.get("https://www.saucedemo.com/");
        System.out.println("Page Title: " + driver.getTitle());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverConfig.closeDriver();
    }
}