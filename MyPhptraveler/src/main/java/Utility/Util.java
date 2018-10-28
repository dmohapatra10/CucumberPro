package Utility;

import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BasePack.TestBase;

public class Util extends TestBase{
	
	protected Util() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static Object obj[][];
	
	public static void captureScreenshot() throws IOException
	{

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile,new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	
	public static Object[] getExcelData(int sheetIndex,int rowIndex) throws Exception
	{
		fis=new FileInputStream("C:\\MyGit\\MyPhptraveler\\src\\main\\java\\TestData\\TestData.xlsx");
		
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheetAt(sheetIndex);
		
		int rowCount=sh.getLastRowNum();
		int cellCount=sh.getRow(rowIndex).getLastCellNum();
		
		obj=new Object[rowCount][cellCount];
		
		for(int i=rowIndex; i<=rowCount;i++)
		{
			for(int j=rowIndex;j<=cellCount;j++)
			{
				
			cell=sh.getRow(i).getCell(j);			
			if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			{
				obj[i][j]=cell.getNumericCellValue();				
				
			}
			else if(cell.getCellType()==cell.CELL_TYPE_STRING)
			{
				obj[i][j]=cell.getStringCellValue();			
				
			}
					
			}
		}
		return obj;
				
	}
	
	public static void textData()
	{
		
		
		
	}
	
	
}





