package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;

public class AddressPage extends BaseClass {
	ActionClass action = new ActionClass();
	
	@FindBy(id = "firstname")
	WebElement firstnameField;
	
	@FindBy(id = "lastname")
	WebElement lastnameField;
	
	@FindBy(id = "company")
	WebElement companyField;
	
	@FindBy(id = "address1")
	WebElement addressField;
	
	@FindBy(id = "city")
	WebElement cityField;
	
	@FindBy(id = "id_state")
	WebElement stateField;
	
	@FindBy(id = "postcode")
	WebElement postcodeField;
	
	@FindBy(id = "id_country")
	WebElement countryField;
	
	@FindBy(id = "phone")
	WebElement phoneNumberField;
	
	@FindBy(id = "phone_mobile")
	WebElement mobilePhoneField;
	
	@FindBy(id = "alias")
	WebElement aliasField;
	
	@FindBy(id = "submitAddress")
	WebElement saveButton;
	
	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement proceedButton;
		
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void setFirstName(String name) {
		firstnameField.sendKeys(name);
	}
	
	public void setLastname(String name) {
		lastnameField.sendKeys(name);
	}
	
	public void setCompany(String name) {
		companyField.sendKeys(name);
	}
	
	public void setAddress(String name) {
		addressField.sendKeys(name);
	}
	
	public void setCity(String name) {
		cityField.sendKeys(name);
	}
	
	public void setState(String name) {
		//Selecting value from the dropdown
		action.selectByVisibleText(stateField, name);
	}
	
	public void setPostcode(String text) {
		postcodeField.sendKeys(text);
	}
	
	public void setCountry(String text) {
		action.selectByVisibleText(countryField, text);
	}
	
	public void setHomePhone(String number) {
		phoneNumberField.sendKeys(number);
	}
	
	public void setMobilePhone(String number) {
		mobilePhoneField.sendKeys(number);
	}
	
	public void setAlias(String alias) {
		aliasField.clear();
		aliasField.sendKeys(alias);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public ShippingPage clickProceed() {
		proceedButton.click();
		return new ShippingPage();
	}
}
