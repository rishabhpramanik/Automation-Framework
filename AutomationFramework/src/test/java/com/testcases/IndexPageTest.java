package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.PageObjects.IndexPage;
import com.Utility.Logs;

public class IndexPageTest extends BaseClass {
	private IndexPage indexPage;
		
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@Test(testName = "Logo Test", groups = "Smoke")
	public void logoTest() {
		Logs.startTestCase("verifyLogo");
		indexPage = new IndexPage();
		Assert.assertTrue(indexPage.isLogoDisplayed());
		Logs.endTestCase("verifyLogo");
	}
	
	@Test(testName = "Verify Title", groups = "Smoke")
	public void verifyTitle() {
		Logs.startTestCase("verifyTitle");
		String expectedTitle = "My Shop";
		String actualTitle = indexPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		Logs.endTestCase("verifyTitle");
	}
	
	@Test(testName = "Verify URL", groups = "Smoke")
	public void verifyUrl() {
		Logs.startTestCase("verifyUrl");
		String expectedUrl = "http://www.automationpractice.pl/index.php";
		String actualUrl = indexPage.getPageUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		Logs.endTestCase("verifyUrl");
	}
	
	@Test(testName = "Contact number displayed", groups = "Smoke")
	public void contactNumberAvailable() {
		Logs.startTestCase("verifyContactNumber");
		Assert.assertTrue(indexPage.contactInfoVisible());
		Logs.endTestCase("verifyContactNumber");
	}
	
	@Test(testName = "Email displayed", groups = "Smoke")
	public void emailAvailable() {
		Logs.startTestCase("verifyEmailInfo");
		Assert.assertTrue(indexPage.emailVisible());
		Logs.endTestCase("verifyEmailInfo");
	}
	
	@Test(testName = "Navigate to Login page", groups = "Smoke")
	public void verifyLoginPage() {
		Logs.startTestCase("verifyLoginPage");
		String currentUrl = indexPage.loadLoginPage();
		String expectedUrl = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(currentUrl, expectedUrl);	
		Logs.endTestCase("verifyLoginPage");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
