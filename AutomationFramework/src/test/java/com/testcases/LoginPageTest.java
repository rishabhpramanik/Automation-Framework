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

public class LoginPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviderClass.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		Logs.startTestCase("loginTest");
		indexPage= new IndexPage();
		Logs.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignin();
		Logs.info("Enter Username and Password");
	    
		homePage=loginPage.login(uname,pswd,homePage);
		
	    String actualURL = homePage.getHomePageUrl();
	    String expectedURL="http://www.automationpractice.pl/index.php?controller=my-account";
	    Logs.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Logs.info("Login is Sucess");
	    Logs.endTestCase("loginTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
}
