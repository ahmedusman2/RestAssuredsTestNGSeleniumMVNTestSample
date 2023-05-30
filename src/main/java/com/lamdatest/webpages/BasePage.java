package com.lamdatest.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    // All common methods will be placed here.
    // To achieve DRY - don't repeat yourself

    // Define the WebDriver
    public static WebDriver driver;

    /**
     * Sets the WebDriver instance for the BasePage class.
     * @param driver The WebDriver instance to use.
     */
    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    /**
     * Finds a WebElement using the provided locator.
     * @param locator The By locator to identify the element.
     * @return The WebElement matching the locator.
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Clicks on a WebElement identified by the provided locator.
     * @param locator The By locator of the element to click.
     */
    protected void click(By locator) {
        find(locator).click();
    }

    /**
     * Retrieves the text of a WebElement identified by the provided locator.
     * @param locator The By locator of the element to retrieve the text from.
     * @return The text of the WebElement.
     */
    protected String getText(By locator) {
        String text = find(locator).getText();
        System.out.println("Text: " + text);
        return text;
    }

    /**
     * Enters text into a text field identified by the provided locator.
     * @param locator The By locator of the text field element.
     * @param text The text to enter into the text field.
     */
    protected void sendKeys(By locator, String text) {
        find(locator).sendKeys(text);
    }
}
