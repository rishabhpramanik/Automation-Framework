package com.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Dataprovider.DataProviderClass;
import com.PageObjects.AccountCreationPage;
import com.PageObjects.HomePage;
import com.PageObjects.IndexPage;
import com.PageObjects.LoginPage;
import com.Utility.Logs;

public class AccountCreationPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage accountCreationPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviderClass.class)
	public void verifyCreateAccountPageTest(String email) throws Throwable {
		Logs.startTestCase("verifyCreateAccountPageTest");
		indexPage = new IndexPage();
		loginPage  =indexPage.clickOnSignin();
		
		//Entering the email into account creation field
		loginPage.enterEmailAddress(email);
		
		//Clicking on Create account button
		accountCreationPage = loginPage.clickCreationButton();
		
		boolean result=accountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		Logs.endTestCase("verifyCreateAccountPageTest");
	}
	
	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviderClass.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		Logs.startTestCase("createAccountTest");
		indexPage= new IndexPage();
		loginPage = indexPage.clickOnSignin();
		loginPage.enterEmailAddress(hashMapValue.get("Email"));
		accountCreationPage = loginPage.clickCreationButton();
		accountCreationPage.createAccount(
				hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homePage = accountCreationPage.validateRegistration();
		String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		String homePageUrl = homePage.getHomePageUrl();
		Assert.assertEquals(expectedUrl, homePageUrl);
		Logs.endTestCase("createAccountTest");
	}
}
