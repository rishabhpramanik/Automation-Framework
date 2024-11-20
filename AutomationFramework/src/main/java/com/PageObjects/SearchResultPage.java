package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class SearchResultPage extends BaseClass {
	@FindBy(xpath = "(//a[@title='Printed Summer Dress'])[2]")
	WebElement product;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() {
		boolean response = product.isDisplayed();
		return response;
	}
	
	public AddToCartPage clickOnProduct(){
		product.click();
		return new AddToCartPage();
	}
}
