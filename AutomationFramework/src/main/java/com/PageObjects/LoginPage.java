package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class LoginPage extends BaseClass{
	//Locating the Web elements
	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(id = "passwd")
	WebElement passwordField;
	
	@FindBy(xpath = "//a[@title='Recover your forgotten password']")
	WebElement forgetPassword;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id = "email_create")
	WebElement emailAddressField;
	
	@FindBy(id = "SubmitCreate")
	WebElement createAccountBtn;
	
	@FindBy(xpath = "//i[@class='icon-home']")
	WebElement homeBtn;
	
	//Initializing the Web element
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//Methods to perform actions on Web elements
	public AddressPage login(String email, String pass, AddressPage addressPage) {
		emailField.sendKeys(email);
		passwordField.sendKeys(pass);
		signInBtn.click();
		addressPage = new AddressPage();
		return addressPage;
	}
	
	public HomePage login(String email, String pass, HomePage homePage) {
		emailField.sendKeys(email);
		passwordField.sendKeys(pass);
		signInBtn.click();
		homePage = new HomePage();
		return homePage;
	}
	
	//Combine the below methods to create account
	public void enterEmailAddress(String email) {
		emailAddressField.sendKeys(email);
	}
	
	public AccountCreationPage clickCreationButton() {
		createAccountBtn.click();
		return new AccountCreationPage();
	}
	
	public void clickHomeButton() {
		homeBtn.click();
	}
}
