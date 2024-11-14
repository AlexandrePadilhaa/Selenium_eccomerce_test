package org.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Random;

public class CheckoutPage {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);
    private WebDriver driver;

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");

    By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillCheckoutForm(String firstName, String lastName) {

        WebElement firstNameElement = driver.findElement(firstNameField);
        WebElement lastNameElement = driver.findElement(lastNameField);
        WebElement postalCodeElement = driver.findElement(postalCodeField);

        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);

        String postalCode = generateRandomPostalCode();
        postalCodeElement.sendKeys(postalCode);

        logger.debug("Filled checkout form with First Name: {}, Last Name: {}, Postal Code: {}", firstName, lastName, postalCode);
    }

    public void clickContinueButton() {
        WebElement continueBtn = driver.findElement(continueButton);
        continueBtn.click();
        logger.debug("Clicked on the continue button.");
    }

    public void clickFinishButton() {
        WebElement finishBtn = driver.findElement(finishButton);
        finishBtn.click();
        logger.debug("Clicked on the finish button.");
    }


    private String generateRandomPostalCode() {
        Random random = new Random();
        int postalCode = 10000 + random.nextInt(90000);
        return String.valueOf(postalCode);
    }
}
