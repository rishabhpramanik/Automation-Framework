package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;

public class SearchResultPage extends BaseClass {
	ActionClass action = new ActionClass();
	
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
		action.scrollUntilElementInView(product, getDriver());
		product.click();
		return new AddToCartPage();
	}
}
