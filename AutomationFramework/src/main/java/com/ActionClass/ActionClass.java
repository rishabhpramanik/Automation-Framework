package com.ActionClass;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass {
    // Using fluent wait to wait for the element to be interactable
    public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeOut))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
            e.printStackTrace(); // Replace with logging in production
        }
    }

    // Converting the string to double
    public Double stringToDouble(WebElement element) {
        double doubleValue = 0.0;
        
        //Checking if the Web element is not null
        String stringValue = element != null ? element.getText() : null;
        if (stringValue != null && !stringValue.isEmpty()) {
            try {
                if (stringValue.startsWith("$")) {
                    stringValue = stringValue.replace("$", "");
                }
                doubleValue = Double.parseDouble(stringValue);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + stringValue);
            }
        } else {
            System.err.println("The string value is null or empty.");
        }
        return doubleValue;
    }

    public void selectByVisibleText(WebElement element, String text) {
        if (element != null) {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } else {
            System.err.println("WebElement is null.");
        }
    }

    public void selectByValue(WebElement element, String value) {
        if (element != null) {
            Select select = new Select(element);
            select.selectByValue(value);
        } else {
            System.err.println("WebElement is null.");
        }
    }
    
    public void waitUntilTheElementIsVisible(WebElement element, WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void scrollUntilElementInView(WebElement element, WebDriver driver) {
    	Actions action = new Actions(driver);
    	action.moveToElement(element);
    }
}
