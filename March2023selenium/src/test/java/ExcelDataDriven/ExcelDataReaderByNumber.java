//Stand alone program
package ExcelDataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReaderByNumber 
{
	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\manish\\Desktop\\Test Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("login");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		String str =cell.getStringCellValue();
		System.out.println(str);
		row = sheet.getRow(2);
		cell=row.getCell(3);
		double val = cell.getNumericCellValue();
		val = val/2;
		System.out.println(val);
		wb.close();
		fis.close();
	}
}
