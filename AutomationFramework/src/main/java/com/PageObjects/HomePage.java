package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//span[@class='shop-phone']")
	WebElement contactDetails;
		
	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement signOut;
	
	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement myAccount;
	
	@FindBy(xpath = "//img[@alt='My Shop']")
	WebElement logo;
	
	@FindBy(id ="search_query_top")
	WebElement searchBar;
	
	@FindBy(name = "submit_search")
	WebElement searchButton;
	
	@FindBy(xpath = "//a[@title='View my shopping cart']")
	WebElement shoppingCartButton;
	
	@FindBy(xpath = "//a[@title='Orders']")
	WebElement orderHistory;
	
	@FindBy(xpath = "//a[@title='Credit slips']")
	WebElement creditSlips;
	
	@FindBy(xpath = "//a[@title='Addresses']")
	WebElement myAddresses;
	
	@FindBy(xpath = "//a[@title='Information']")
	WebElement personalInformation;
	
	@FindBy(xpath = "//h4[normalize-space()='Store Information']")
	WebElement storeInformation;
	
	@FindBy(xpath = "//section[@id='block_contact_infos']//li[1]")
	WebElement storeAddress;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void signout() {
		signOut.click();
	}
	
	public void goToCart() {
		shoppingCartButton.click();
	}
	
	public void goToOrders() {
		orderHistory.click();
	}
	
	public void goToAddresses() {
		myAddresses.click();
	}
	
	public void goToPersonalInformation() {
		personalInformation.click();
	}
	
	public SearchResultPage search(String items) {
		searchBar.sendKeys(items);
		searchButton.click();
		return new SearchResultPage();
	}
	
	//Add method to navigate to main page after logout
	
	//Add method to navigate to personal information page
}
