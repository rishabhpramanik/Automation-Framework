package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class IndexPage extends BaseClass {
	@FindBy(xpath = "//img[@alt='My Shop']")
	WebElement logoElement;	

	@FindBy(xpath = "//a[@title='Contact us']")
	WebElement contactUs;
	
	@FindBy(xpath = "//span[normalize-space()='0123-456-789']")
	WebElement contactInfo;
	
	@FindBy(xpath = "//a[normalize-space()='sales@yourcompany.com']")
	WebElement emailInfo;
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signinButton;
	
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ContactPage goToContact() {
		contactUs.click();
		return new ContactPage();
	}
	
	public boolean contactInfoVisible() {
		boolean response = contactInfo.isDisplayed();
		return response;
	}
	
	public boolean emailVisible() {
		boolean response = emailInfo.isDisplayed();
		return response;
	}
	
	public LoginPage clickOnSignin() {
		signinButton.click();
		return new LoginPage();
	}
}
