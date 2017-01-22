package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.Helper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




import AppPages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePagewithReport {
WebDriver driver;
ExtentReports report;
ExtentTest logger;


	@BeforeMethod
	public void startup(){
		
		report=new ExtentReports(".\\Reports\\FirspageReport.htm", true);
		
		logger=report.startTest("VerifyHomePageTest", "TestReprotofverify home page");
		
		driver=BrowserFactory.getBroser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Browser is started");
	}
	
	@Test
	public void testapp(){
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getPageTitle();
		
		System.out.println(title);
		
		Assert.assertTrue(title.contains("OrangeHRM"));
		
		logger.log(LogStatus.PASS, "title is captured");
		
		//
		
		home.EnterUNandPW(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		home.ClickOnLogin();
		
		logger.log(LogStatus.INFO, "user is clicked on login");
		
		String postlogintitle=driver.getTitle();

		
		Assert.assertTrue(postlogintitle.contains("Orange"));
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.CapturedScreenShot(driver, "loginpage 1")));
		
		logger.log(LogStatus.PASS, "user is Logedin successfully");
		
		 
	}
	
/*	@Test
	public void LoginAPP(){
		
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	
	home.EnterUNandPW(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	
	home.ClickOnLogin();
	
	logger.log(LogStatus.INFO, "user is clicked on login");
	
	String postlogintitle=driver.getTitle();

	
	Assert.assertTrue(postlogintitle.contains("Orange"));
	
	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.CapturedScreenShot(driver, "loginpage 1")));
	
	logger.log(LogStatus.PASS, "user is Logedin successfully");
	}*/
	
	@AfterMethod
	public void shutdown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			String path=Helper.CapturedScreenShot(driver, result.getName());
			
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			System.out.println("screen shto taken");
			
		}
		
		BrowserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		
		report.flush();
	
	}
	
}
