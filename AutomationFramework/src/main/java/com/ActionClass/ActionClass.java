package com.ActionClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class ActionClass {
	//Using fluent wait to wait for the element to be interactable
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	
	//Converting the string to double
	public Double stringToDouble(WebDriver driver, WebElement element) {
		String stringValue = element.getText();
		double doubleValue = 0.0;
		if(stringValue.startsWith("$")) {
			//Removing the $ sign from the price
			stringValue = stringValue.replace("$","");
			
			//Converting the string into double
			doubleValue = Double.parseDouble(stringValue);
			return doubleValue;			
		}else {
			doubleValue = Double.parseDouble(stringValue);
			return doubleValue;
		}
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		//Using Select class to choose values from the dropdown
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
