package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;

public class OrderPage extends BaseClass {
	ActionClass actions = new ActionClass();
	
	@FindBy(xpath = "//li[@class='price special-price']")
	private WebElement unitPrice;
	
	@FindBy(id = "total_product")
	private WebElement cartTotalField;
	
	@FindBy(id = "total_shipping")
	private WebElement shippingPrice;
	
	@FindBy(id = "total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckoutButton;
	
	@FindBy(xpath = "//p[@class='fancybox-error']")
	private WebElement errorMessage;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public Double getCalculatedPrice() {
		//Calculated price is the product of unit price and quantity
		double cartTotal = actions.stringToDouble(cartTotalField);
		double shipping = actions.stringToDouble(shippingPrice);
		double calculatedPrice = cartTotal + shipping;
		return calculatedPrice;
	}
	
	public Double getTotalPrice() {
		//Converting the String value to Double value
		double totalValue = actions.stringToDouble(totalPrice);
		System.out.println(totalValue);
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
