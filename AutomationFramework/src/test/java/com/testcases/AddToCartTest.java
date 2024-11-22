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
import com.PageObjects.SearchResultPage;
import com.Utility.Logs;

public class AddToCartTest extends BaseClass {
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
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickAddToCart();
		boolean result = addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Logs.endTestCase("addToCartTest");
		
	}
}
