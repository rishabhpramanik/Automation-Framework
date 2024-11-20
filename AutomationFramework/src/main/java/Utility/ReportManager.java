package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports reports;
	public static ExtentTest test;

	public static void setExtent() {
		/*
		 * Initialize the spark reporter and provide the report path
		 * Configure the report details
		 * Attach the report using the ExtentReports and set system info
		 * Log the test using the Listeners
		 */

		//Initializng the SparkReporter
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\TestReport");

		//Configuring the report details
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setDocumentTitle("E-Commerce Website Testing");
		sparkReporter.config().setReportName("Store Test Report");

		//Attaching the reporter
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);

		reports.setSystemInfo("HostName", "MyHost");
		reports.setSystemInfo("ProjectName", "EcomProject");
		reports.setSystemInfo("Tester", "Rishabh");
		reports.setSystemInfo("OS", "Win10");		
	}
	
	public static void endReport() {
		reports.flush();
	}

}
