package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Dataprovider.DataProviderClass;
import com.PageObjects.HomePage;
import com.PageObjects.IndexPage;
import com.PageObjects.LoginPage;
import com.Utility.Logs;

public class HomePageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
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
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void personalInformationTest(String uname, String pswd) throws Throwable {
		Logs.startTestCase("PersonalInformationTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignin();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validatePersonalInformation();
		Assert.assertTrue(result);
		Logs.endTestCase("PersonalInformationTest");
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
		Logs.startTestCase("orderHistoryandDetailsTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignin();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		Logs.endTestCase("orderHistoryandDetailsTest");
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void myAddressesTest(String uname, String pswd) throws Throwable {
		Logs.startTestCase("myAddressesTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignin();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateMyAddresses();
		Assert.assertTrue(result);
		Logs.endTestCase("myAddressesTest");
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void logoutButtonTest(String uname, String pswd) throws Throwable {
		Logs.startTestCase("logoutButtonVisiblilityTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignin();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateLogoutButton();
		Assert.assertTrue(result);
		Logs.endTestCase("logoutButtonVisibilityTest");
	}
}
