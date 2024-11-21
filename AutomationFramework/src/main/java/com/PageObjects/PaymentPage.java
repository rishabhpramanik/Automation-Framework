package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class PaymentPage extends BaseClass {
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement bankWireOption;
	
	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement checkOption;
	
	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	WebElement confirmOrderButton;
	
	@FindBy(xpath = "//a[normalize-space()='Other payment methods']")
	WebElement otherPaymentOption;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean bankOptionAvailable() {
		boolean response = bankWireOption.isDisplayed();
		return response;
	}
	
	public boolean checkOptionAvailable() {
		boolean response = checkOption.isDisplayed();
		return response;
	}
	
	public void selectBankWireOption() {
		bankWireOption.click();
	}
	
	public void selectCheckOption() {
		checkOption.click();
	}
	
	public void selectOtherOption() {
		otherPaymentOption.click();
	}
	
	public ConfirmationPage confirmOrder() {
		confirmOrderButton.click();
		return new ConfirmationPage();
	}
}
