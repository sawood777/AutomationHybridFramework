package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import AppPages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage {
WebDriver driver;


	@BeforeMethod
	public void startup(){
		driver=BrowserFactory.getBroser("chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test
	public void testapp(){
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getPageTitle();
		
		System.out.println(title);
		Assert.assertTrue(title.contains("OrangeHRM - New Level of HR Management"));
		home.EnterUNandPW(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
		home.ClickOnLogin();
		System.out.println("Loged in successfully");
		 
	}
	
/*	@Test
	public void LoginAPP(){
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	home.EnterUNandPW(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));
	home.ClickOnLogin();
	System.out.println("Loged in successfully");
	}
	*/
	@AfterMethod
	public void shutdown(){
		BrowserFactory.closeBrowser(driver);
	
	}
	
}
