package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	
	
	//return type should be browser to get(return) browser
	public static WebDriver getBroser(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver Idriver){
		driver.quit();
	}
	
}
