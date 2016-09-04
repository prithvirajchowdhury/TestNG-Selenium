package xclLib;                                       

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.*;

public class XclHelp { 
	
	Workbook workBook;
	
	public String getData(String Workbook,String sheetName,String column)throws Exception
	{
		String data=null;
		FileInputStream in=new FileInputStream(new File(System.getProperty("user.dir")).getAbsolutePath()+"//DataTables//"+Workbook);
		String fileExtension=Workbook.substring(Workbook.indexOf('.'));
		
			workBook=new HSSFWorkbook(in);
		Sheet sheet=(Sheet) workBook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=0;i<rowCount+1;i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				Cell cell=row.getCell(j);
				System.out.print(cell.getStringCellValue()+"||");
			}
			System.out.println();
		}
		
		
		return data;
	}

}
