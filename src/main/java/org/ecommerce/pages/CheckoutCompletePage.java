package org.ecommerce.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutCompletePage {
    private static final Logger logger = LoggerFactory.getLogger(CheckoutCompletePage.class);
    private final String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
    private WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyAndTakeScreenshot() {

        if (driver.getCurrentUrl().equals(expectedUrl)) {
            logger.debug("The page is the expected checkout complete page.");

            takeScreenshot();
        } else {
            logger.warn("The current URL is not the expected checkout complete page.");
        }
    }

    private void takeScreenshot() {
        try {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

            File destinationFile = new File("screenshots/checkout_complete.png");

            FileUtils.copyFile(screenshot, destinationFile);

            logger.debug("Screenshot saved to: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Error while saving screenshot.", e);
        }
    }
}
