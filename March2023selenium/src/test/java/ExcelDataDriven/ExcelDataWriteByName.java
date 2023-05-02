//Stand Alone program
package ExcelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataWriteByName
{
	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\manish\\Desktop\\Test Data.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row= sheet.getRow(0);
		
		int cellIndex = -1;
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("Result"))
				cellIndex=i;
		}
		row =sheet.getRow(2);
		XSSFCell cell = row.getCell(cellIndex);
		cell.setCellValue("Failed");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\manish\\Desktop\\Test Data.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
	}

}
