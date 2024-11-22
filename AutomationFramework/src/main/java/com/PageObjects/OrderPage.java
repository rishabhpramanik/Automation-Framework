package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;

public class OrderPage extends BaseClass {
	ActionClass actions = new ActionClass();
	
	@FindBy(xpath = "//li[@class='price special-price']")
	WebElement unitPrice;
	
	@FindBy(xpath = "//input[@name='quantity_5_23_0_8026']")
	WebElement quantity;
	
	@FindBy(id = "total_shipping")
	WebElement shippingPrice;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutButton;
	
	@FindBy(xpath = "//p[@class='fancybox-error']")
	WebElement errorMessage;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public Double getCalculatedPrice() {
		//Converting the String value to Double value
		double unitPriceValue = actions.stringToDouble(unitPrice);
		double quantityValue = actions.stringToDouble(quantity);
		double shippingValue = actions.stringToDouble(shippingPrice);
		
		//Calculating the total price
		double calculatedPrice = (unitPriceValue * quantityValue) + shippingValue;
		return calculatedPrice;
	}
	
	public Double getTotalPrice() {
		//Converting the String value to Double value
		double totalValue = actions.stringToDouble(totalPrice);
		return totalValue;
	}
	
	public boolean errorMessageShown() {
		boolean response = errorMessage.isDisplayed();
		return response;
	}
	
	public String getErrorMessage() {
		String message = errorMessage.getText();
		return message;
	}
	
	public LoginPage clickProceedButton() {
		proceedToCheckoutButton.click();
		return new LoginPage();
	}
}
