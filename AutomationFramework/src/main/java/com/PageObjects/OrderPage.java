package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class OrderPage extends BaseClass {
	@FindBy(xpath = "//li[@class='price special-price']")
	WebElement unitPrice;
	
	@FindBy(xpath = "//input[@name='quantity_5_23_0_8026']")
	WebElement quantity;
	
	@FindBy(id = "total_shipping")
	WebElement shippingPrice;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double calculateTotalPrice() {
		double unitPrice = 
		
	}
}
