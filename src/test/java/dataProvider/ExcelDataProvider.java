package dataProvider;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider(){
		
		try {
			File src=new File("./AppTestData/AppData.xlsx");
			
			FileInputStream file=new FileInputStream(src);
			
			wb=new XSSFWorkbook(file);
		} 
		
		catch (Exception e) {
			System.out.println("Exception message is "+e.getMessage());
		} 
		
	}
	
	
	public String getData(int SheetIndex, int row, int column){
		String data=wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;	
	}
	
	public String getData(String SheetName, int row, int column){
		String data=wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		return data;	
	}
	
	

}
