package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Dataprovider.DataProviderClass;
import com.PageObjects.AddToCartPage;
import com.PageObjects.AddressPage;
import com.PageObjects.ConfirmationPage;
import com.PageObjects.IndexPage;
import com.PageObjects.LoginPage;
import com.PageObjects.OrderPage;
import com.PageObjects.PaymentPage;
import com.PageObjects.SearchResultPage;
import com.PageObjects.ShippingPage;
import com.Utility.Logs;

public class EndToEndTest extends BaseClass{
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private ConfirmationPage confirmationPage;

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
	public void endToEndTest(String productName, String qty, String size) throws Throwable {
		Logs.startTestCase("endToEndTest");
		index= new IndexPage();
		
		//Navigating to Search result page
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		
		//Adding the product into cart
		addToCartPage.selectSize(size);
		addToCartPage.enterQuantity(qty);
		
		addToCartPage.clickAddToCart();
		orderPage = addToCartPage.clickCheckoutButton();
		
		//Login using credentials
		loginPage = orderPage.clickProceedButton();
		addressPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage = addressPage.clickProceed();
		
		//Accepting terms and condition on shipping page
		shippingPage.clickCheckbox();
		paymentPage = shippingPage.clickProceed();
		
		//Selecting payment option on payment page
		paymentPage.selectBankWireOption();
		
		//Confirming order
		confirmationPage = paymentPage.confirmOrder();
		
		//Getting the confirmation message from the Confirmation page
		String actualMessage = confirmationPage.getConfirmationMessage();
		String expectedMsg = "Your order on My Shop is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		Logs.endTestCase("endToEndTest");
	}

}
