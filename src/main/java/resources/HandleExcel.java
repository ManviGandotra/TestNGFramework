package resources;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HandleExcel {
	
	
	public String readDataFromExcel(int s,int r,int c) throws InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\nipun\\Desktop\\TestingData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(s);
		XSSFRow row=sheet.getRow(r);
		XSSFCell cell=row.getCell(c);
		System.out.println(sheet.getRow(r).getCell(c));
		return sheet.getRow(r).getCell(c).toString();
	}
	
	
	

}
