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
	
	@FindBy(id ="search_query_top")
	WebElement searchBar;
	
	@FindBy(name = "submit_search")
	WebElement searchButton;
	
	
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
	
	public boolean isLogoDisplayed() {
		boolean response = logoElement.isDisplayed();
		return response;
	}
	
	public String getPageTitle() {
		String title = getDriver().getTitle();
		return title;
	}
	
	public String getPageUrl() {
		String url = getDriver().getCurrentUrl();
		return url;
	}
	
	public String loadLoginPage() {
		signinButton.click();
		String url = getDriver().getCurrentUrl();
		return url;
	}
	
	public LoginPage clickSignIn() {
		signinButton.click();
		return new LoginPage();
	}
	
	public SearchResultPage searchProduct(String productName) {
		searchBar.sendKeys(productName);
		searchButton.click();
		return new SearchResultPage();
	}
}
