package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;

public class AccountCreationPage extends BaseClass {
	ActionClass action = new ActionClass();

	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement formTitle;

	@FindBy(id = "id_gender1")
	private WebElement mr;

	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "passwd")
	private WebElement passwordField;

	@FindBy(id = "days")
	private WebElement days;

	@FindBy(id = "months")
	private WebElement months;

	@FindBy(id = "years")
	private WebElement years;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String company, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws Throwable {

		if(gender.equalsIgnoreCase("Mr")) {
			mr.click();
		} else {
			mrs.click();
		}

		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		passWord.sendKeys(pswd);
		action.selectByValue(days, day);
		action.selectByValue(months, month);
		action.selectByValue(years, year);
	}

	public HomePage validateRegistration() throws Throwable {
		registerBtn.click();
		return new HomePage();
	}

	public boolean validateAcountCreatePage() throws Throwable {
		return formTitle.isDisplayed();
	}
}
