package utility;




import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String CapturedScreenShot(WebDriver driver, String ScreenshotName){
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
	String	dstination="C:\\Users\\sawood\\workspacecom.learnautomation.hybrid\\ScreenShots\\"+ScreenshotName+System.currentTimeMillis()+".png";
		
		try {
			FileUtils.copyFile(src, new File(dstination));
		} 
		
		catch (IOException e) {
			System.out.println("Fial to captured the screen shot "+e.getMessage());
		}
		
		return dstination;
		
	}


}
