package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class ShippingPage extends BaseClass {
	@FindBy(xpath = "//span[normalize-space()='Back to your account']")
	private WebElement backToAccountButton;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement termsCheckbox;
	
	@FindBy(xpath = "//button[@name='processCarrier']")
	private WebElement proceedButton;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickCheckbox() {
		termsCheckbox.click();
	}
	
	public PaymentPage clickProceed() {
		proceedButton.click();
		return new PaymentPage();
	}
	
	public boolean validateTermsAndConditions() {
		boolean response = termsCheckbox.isDisplayed();
		return response;
	}
}
