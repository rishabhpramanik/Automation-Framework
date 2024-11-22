package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Dataprovider.DataProviderClass;
import com.PageObjects.IndexPage;
import com.PageObjects.SearchResultPage;
import com.Utility.Logs;

public class SearchResultTest extends BaseClass {
	private IndexPage index;
	private SearchResultPage searchResultPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}

	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviderClass.class)
	public void productAvailabilityTest(String productName) throws Throwable {
		Logs.startTestCase("productAvailabilityTest");
		index= new IndexPage();
		searchResultPage = index.searchProduct(productName);
		boolean result = searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Logs.endTestCase("productAvailabilityTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
