package com.Utility;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BaseClass.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenersManager extends ReportManager implements ITestListener{
	
	//Overriding the ITestListeners methods
	//Creating the test using test name
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getName());
	}
	
	//On test success 
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " passed", ExtentColor.GREEN));
		}		
	}
	
	//On test failure or exception thrown
	public void onTestFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " failed", ExtentColor.RED));
			
			//Capturing the screenshot where the test fails
			String imgPath = takeScreenshot(BaseClass.getDriver(), result.getName());
			test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
		}
	}
	
	//On test skipped
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " skipped", ExtentColor.YELLOW));
		}
	}
	
	//Method to take screenshot, called when the test case fails
	public String takeScreenshot(WebDriver driver, String testName) {
		//Setting the current date on which test is executed
		String dateName = new SimpleDateFormat("ddmmyyhhmmss").format(new Date());
		
		//Initialize the screenshot object
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		//Getting the source of the image
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String imgPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + "_" + dateName + ".png";
		try {
			//Copy the file from to destination
			FileUtils.copyFile(source, new File(imgPath));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Add new path for Jenkins
		return imgPath;
		
	}
}
