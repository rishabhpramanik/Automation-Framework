package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BaseClass.BaseClass;

public class AddToCartPage extends BaseClass {
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
	
	public void select(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);		
	}
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity) {
		//Clearing the default value
		quantitySelection.clear();
		
		//Enter new value
		quantitySelection.sendKeys(quantity);		
	}
	
	public void selectSize(String size) {
		select(sizeSelection, size);
	}
	
	public void clickAddToCart() {
		addButton.click();
	}
	
	public OrderPage clickCheckoutButton() {
		checkoutButton.click();
		return new OrderPage();
	}

	public boolean validateAddtoCart() {
		boolean response = cartMessage.isDisplayed();
		return response;
	}
}
