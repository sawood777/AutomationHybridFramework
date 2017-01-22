package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider(){
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream File=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(File);
		} 
		
		catch (Exception e) {
			System.out.println("Properties Exception message is: "+e.getMessage());
			
		}
		
	}
	
	public String getApplicationUrl(){
		
		String url=pro.getProperty("url");
		return url;
	}
	
		public String getChromePath(){
		
		String ChromePath=pro.getProperty("ChromePath");
		return ChromePath;
	}
	
	public String getIEPath(){
			
		String IEPath=pro.getProperty("IEPath");
		return IEPath;
	}
		

}
