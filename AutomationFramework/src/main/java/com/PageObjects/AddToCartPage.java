package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;

public class AddToCartPage extends BaseClass {
	ActionClass action = new ActionClass();
	
	@FindBy(id = "group_1")
	WebElement sizeSelection;
	
	@FindBy(id = "color_16")
	WebElement colorSelection;
	
	@FindBy(id = "quantity_wanted")
	WebElement quantitySelection;
	
	@FindBy(xpath = "//button[@name='Submit']")
	WebElement addButton;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement checkoutButton;
	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement cartMessage;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity) {
		action.scrollUntilElementInView(quantitySelection, getDriver());
		//Clearing the default value
		quantitySelection.clear();
		
		//Enter new value
		quantitySelection.sendKeys(quantity);		
	}
	
	public void selectSize(String size) {
		action.scrollUntilElementInView(sizeSelection, getDriver());
		action.selectByVisibleText(sizeSelection, size);
	}
	
	public void clickAddToCart() {
		action.scrollUntilElementInView(addButton, getDriver());
		addButton.click();
	}
	
	public OrderPage clickCheckoutButton() {
		checkoutButton.click();
		return new OrderPage();
	}

	public boolean validateAddtoCart() {
		//Waiting for the element to be visible
		action.waitUntilTheElementIsVisible(cartMessage, getDriver());
		boolean response = cartMessage.isDisplayed();
		return response;
	}
}
