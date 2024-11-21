package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class ConfirmationPage extends BaseClass {
	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement confirmationMessage;
	
	public ConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getConfirmationMessage() {
		String message = confirmationMessage.getText();
		return message; //Your order on My Shop is complete
	}
}
