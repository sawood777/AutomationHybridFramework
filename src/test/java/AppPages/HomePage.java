package AppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.DataProviderFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver ldriver){
		
		this.driver=ldriver;
	}
	
	@FindBy(name="txtUserName") WebElement UserName;
	@FindBy(name="txtPassword") WebElement Password;
	@FindBy(name="Submit") WebElement LoginButton;
	@FindBy(name="clear") WebElement ClearButton;
	
	
	public void EnterUNandPW(String uid, String pwd){
		
		UserName.sendKeys(uid);
		Password.sendKeys(pwd);
	}
	
	public void ClickOnLogin(){
		LoginButton.click();
	}
	
	public void ClickOnClear(){
		ClearButton.click();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	

}
