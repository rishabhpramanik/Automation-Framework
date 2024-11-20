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
	public HomePage login(String email, String pass) {
		emailField.sendKeys(email);
		passwordField.sendKeys(pass);
		signInBtn.click();
		return new HomePage();
	}
	
	//Combine the below methods to create account
	public void enterEmailAddress(String email) {
		emailAddressField.sendKeys(email);
	}
	
	public void clickCreationButton() {
		createAccountBtn.click();
	}
	
	public void clickHomeButton() {
		homeBtn.click();
	}
}
