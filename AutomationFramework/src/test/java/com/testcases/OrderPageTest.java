package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Dataprovider.DataProviderClass;
import com.PageObjects.AddToCartPage;
import com.PageObjects.IndexPage;
import com.PageObjects.OrderPage;
import com.PageObjects.SearchResultPage;
import com.Utility.Logs;

public class OrderPageTest extends BaseClass {
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviderClass.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		Logs.startTestCase("verifyTotalPrice");
		index= new IndexPage();
		searchResultPage = index.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		
		addToCartPage.selectSize(size);
		addToCartPage.enterQuantity(qty);
		
		addToCartPage.clickAddToCart();
		orderPage = addToCartPage.clickCheckoutButton();
		
		//Getting the price from the page and calculating it
		double expectedPrice = orderPage.getCalculatedPrice();
		
		//Getting the total price from the page
		Double actualPrice = orderPage.getTotalPrice();
		
		Assert.assertEquals(actualPrice, expectedPrice);
		Logs.endTestCase("verifyTotalPrice");
	}
}
