package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;

public class AddressPage extends BaseClass {
	ActionClass action = new ActionClass();
	
	@FindBy(id = "firstname")
	private WebElement firstnameField;
	
	@FindBy(id = "lastname")
	private WebElement lastnameField;
	
	@FindBy(id = "company")
	private WebElement companyField;
	
	@FindBy(id = "address1")
	private WebElement addressField;
	
	@FindBy(id = "city")
	private WebElement cityField;
	
	@FindBy(id = "id_state")
	private WebElement stateField;
	
	@FindBy(id = "postcode")
	private WebElement postcodeField;
	
	@FindBy(id = "id_country")
	private WebElement countryField;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberField;
	
	@FindBy(id = "phone_mobile")
	private WebElement mobilePhoneField;
	
	@FindBy(id = "alias")
	private WebElement aliasField;
	
	@FindBy(id = "submitAddress")
	private WebElement saveButton;
	
	@FindBy(xpath = "//button[@name='processAddress']")
	private WebElement proceedButton;
	
	@FindBy(xpath = "//*[text()='Your delivery address']")
	private WebElement savedAddressLocator;
	
	@FindBy(xpath = "//a[@title='Add an address']")
	private WebElement addNewAddressButton;
		
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
	
	public boolean validateAddressPage() {
		boolean response = savedAddressLocator.isDisplayed();
		return response;
	}
	
	public void clickAddNewAddress() {
		addNewAddressButton.click();
	}
	
	public void addAddress(String fName, 
			String lName,
			String company,
			String address,
			String city,
			String state,
			String postCode,
			String country,
			String homeNumber,
			String mobileNumber,
			String aliasName) {
		firstnameField.sendKeys(fName);
		lastnameField.sendKeys(lName);
		companyField.sendKeys(company);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		action.selectByVisibleText(stateField, state);
		postcodeField.sendKeys(postCode);
		action.selectByVisibleText(countryField, country);
		phoneNumberField.sendKeys(homeNumber);
		mobilePhoneField.sendKeys(mobileNumber);
		aliasField.clear();
		aliasField.sendKeys(aliasName);
	}
}
