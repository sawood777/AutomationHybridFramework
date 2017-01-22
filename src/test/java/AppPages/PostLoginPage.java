package AppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostLoginPage {
	
	WebDriver driver;
	public PostLoginPage(WebDriver ldriver){
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath=".//*[@id='option-menu']/li[1]") WebElement WelcomeTxt;
	@FindBy(linkText="Change Password") WebElement ChangePwd;	
	@FindBy(linkText="Logout") WebElement Logout;
	
	
	public String getWelTxt(){
		
		return WelcomeTxt.getText();		
	}
	
	public void verifychangpwd(){
		ChangePwd.isDisplayed();
		
	}
	
	public void logout(){
		Logout.isDisplayed();
		
	}
	

}
