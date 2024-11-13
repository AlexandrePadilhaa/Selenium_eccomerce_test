package org.ecommerce.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class WebDriverConfig {

    private static WebDriver driver;

    // Construtor para garantir que o WebDriver seja inicializado quando necessário
    public WebDriverConfig() {
        if (driver == null) {
            initializeDriver();
        }
    }

    // Método estático para inicializar o WebDriver
    public static WebDriver initializeDriver() {
        if (driver == null) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }

    // Método estático para fechar o WebDriver
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Getter para obter o WebDriver
    public WebDriver getDriver() {
        return driver;
    }
}

