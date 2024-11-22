package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Dataprovider.DataProviderClass;
import com.PageObjects.HomePage;
import com.PageObjects.IndexPage;
import com.PageObjects.LoginPage;
import com.Utility.Logs;

public class HomePageTest extends BaseClass {
	public static IndexPage indexPage;
	public static LoginPage loginPage;
	public static HomePage homePage;
	
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
