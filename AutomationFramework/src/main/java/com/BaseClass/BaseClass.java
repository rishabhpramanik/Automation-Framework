package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Utility.ReportManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	
	//Making separate copy of driver for each thread
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	//Getting the driver instance for the particular thread
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void loadConfig() {
		/*
		 * Setup the Extent Report to save the report
		 * Configure the Logger
		 * Read the configuration file and load the configuration file
		 */
		
		//Setting up the Extent Report
		ReportManager.setExtentReport();
		
//		//Configure the logger
//		DOMConfigurator.configure("log4j.xml");
		
		//Loading the Configuration file and reading the values
		try {
				prop = new Properties();
				FileInputStream fip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
				prop.load(fip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void launchApp(String browserName) {
		/*
		 * Setup the driver according to the browser required
		 * Launch the browser
		 * Maximize the browser
		 * Delete all cookies
		 * Manage implicit wait
		 * Manage page load timeout 
		 * Launch the url
		 */
		
		//Setting up the driver based on parameter
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		
		//Maximize the window
		getDriver().manage().window().maximize();
		
		//Deleting all the cookies
		getDriver().manage().deleteAllCookies();
		
		//Implicit Timeouts
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Lauching the URL
		getDriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		ReportManager.endReport();
	}

}
