package com.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Dataprovider.DataProviderClass;
import com.PageObjects.AddToCartPage;
import com.PageObjects.AddressPage;
import com.PageObjects.IndexPage;
import com.PageObjects.LoginPage;
import com.PageObjects.OrderPage;
import com.PageObjects.SearchResultPage;
import com.Utility.Logs;

public class AddressPageTest extends BaseClass {
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private AddressPage addressPage;
	private LoginPage loginPage;
		
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"}, dataProvider = "newAddressData", dataProviderClass = DataProviderClass.class)
	public void addressPageTest(HashMap<String, String> hashMapValue) throws Throwable {
		Logs.startTestCase("addressPageTest");
		index= new IndexPage();
		
		//Using hardcoded value to test the address page
		searchResultPage = index.searchProduct("dresses");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickAddToCart();
		orderPage = addToCartPage.clickCheckoutButton();
		loginPage = orderPage.clickProceedButton();
		addressPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		addressPage.clickAddNewAddress();
		
		//Adding new address
		addressPage.addAddress(hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("PostCode"),
				hashMapValue.get("Country"),
				hashMapValue.get("HomePhone"),
				hashMapValue.get("MobilePhone"),
				hashMapValue.get("Alias")
			);
		addressPage.clickSaveButton();
		boolean result = addressPage.validateAddressPage();
		Assert.assertTrue(result);
		Logs.endTestCase("addressPageTest");		
	}
}
