package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AppPages.HomePage;
import AppPages.PostLoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyPostLoginPage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void stratup(){
		driver=BrowserFactory.getBroser("chrome");
		driver.manage().window().maximize();
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void LoginAPP(){
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		home.EnterUNandPW(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		
		home.ClickOnLogin();
		
		String title=driver.getTitle();
		
		Assert.assertTrue(title.contains("OrangeHRM"));
		//
		PostLoginPage postlogin=PageFactory.initElements(driver, PostLoginPage.class);
		String Weltxt=postlogin.getWelTxt();
		Assert.assertTrue(Weltxt.equals("Welcome "+DataProviderFactory.getExcel().getData(0, 0, 0)));
		System.out.println("welcome txt displayed");
		postlogin.verifychangpwd();
		postlogin.logout();
		
	}
	
/*	@Test
	public void verifyPostLoginpage(){
		PostLoginPage postlogin=PageFactory.initElements(driver, PostLoginPage.class);
		String Weltxt=postlogin.getWelTxt();
		Assert.assertTrue(Weltxt.equals("Welcome "+DataProviderFactory.getExcel().getData(0, 0, 0)));
		System.out.println("welcome txt displayed");
		postlogin.verifychangpwd();
		postlogin.logout();
		
	}*/
	
	@AfterMethod
	public void shutdown(){
		BrowserFactory.closeBrowser(driver);
	}
	

}
