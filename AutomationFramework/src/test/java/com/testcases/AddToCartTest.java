package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;
import com.Dataprovider.DataProviderClass;
import com.PageObjects.AddToCartPage;
import com.PageObjects.IndexPage;
import com.PageObjects.SearchResultPage;
import com.Utility.Logs;

public class AddToCartTest extends BaseClass {
	ActionClass action = new ActionClass();
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviderClass.class)
	public void addToCartTest(String productName, String qty, String size) throws Throwable {
		Logs.startTestCase("addToCartTest");
		index= new IndexPage();
		searchResultPage = index.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		
		addToCartPage.selectSize(size);
		addToCartPage.enterQuantity(qty);
		
		addToCartPage.clickAddToCart();
		
		boolean result = addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Logs.endTestCase("addToCartTest");
		
	}
}
