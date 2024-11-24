package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.PageObjects.IndexPage;
import com.Utility.Logs;

public class IndexPageTest extends BaseClass {
	private IndexPage indexPage;
		
	@Parameters("browser")
	@BeforeClass(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@Test(testName = "Logo Test", groups = "Smoke")
	public void logoTest() {
		indexPage = new IndexPage();
		Logs.startTestCase("verifyLogo");
		indexPage = new IndexPage();
		Assert.assertTrue(indexPage.isLogoDisplayed());
		Logs.endTestCase("verifyLogo");
	}
	
	@Test(testName = "Verify Title", groups = "Smoke")
	public void verifyTitle() {
		indexPage = new IndexPage();
		Logs.startTestCase("verifyTitle");
		String expectedTitle = "Login - My Shop";
		String actualTitle = indexPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		Logs.endTestCase("verifyTitle");
	}
	
	@Test(testName = "Verify URL", groups = "Smoke", priority = -1)
	public void verifyUrl() {
		indexPage = new IndexPage();
		Logs.startTestCase("verifyUrl");
		String expectedUrl = "http://www.automationpractice.pl/index.php";
		String actualUrl = indexPage.getPageUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		Logs.endTestCase("verifyUrl");
	}
	
	@Test(testName = "Contact number displayed", groups = "Smoke")
	public void contactNumberAvailable() {
		indexPage = new IndexPage();
		Logs.startTestCase("verifyContactNumber");
		Assert.assertTrue(indexPage.contactInfoVisible());
		Logs.endTestCase("verifyContactNumber");
	}
	
	@Test(testName = "Email displayed", groups = "Smoke")
	public void emailAvailable() {
		indexPage = new IndexPage();
		Logs.startTestCase("verifyEmailInfo");
		Assert.assertTrue(indexPage.emailVisible());
		Logs.endTestCase("verifyEmailInfo");
	}
	
	@Test(testName = "Navigate to Login page", groups = "Smoke")
	public void verifyLoginPage() {
		indexPage = new IndexPage();
		Logs.startTestCase("verifyLoginPage");
		String currentUrl = indexPage.loadLoginPage();
		String expectedUrl = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(currentUrl, expectedUrl);	
		Logs.endTestCase("verifyLoginPage");
	}
	
	@AfterClass(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
