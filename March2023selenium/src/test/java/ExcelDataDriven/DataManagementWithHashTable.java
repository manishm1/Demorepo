package ExcelDataDriven;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataManagementWithHashTable 
{
  @Test(dataProvider = "getData")
  public void f(Hashtable<String, String> str ) 
  {
	  
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	  ExcelApi e = new ExcelApi("C:\\Users\\manish\\Desktop\\suitex.xlsx");
		String sheetName = "data";
		String testName = "TestB";
		
		// To find the matching Testcase RowNumber 
		int testStartRowNum = 0;
		while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testName))
		{
			testStartRowNum++;
		}
		System.out.println("Test Start Row Number Is : "+testStartRowNum);
		
		int colStartRowNum = testStartRowNum+1;
		int dataStartRowNum = testStartRowNum+2;
		
		//calculate the rows of data
		int rows = 0;
		while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
		{
			rows++;
		}
		System.out.println("Total rows are : " +  rows);
		
		//calculate the cols of data
		int cols = 0;
		while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
		{
			cols++;
		}
		System.out.println("Total cols are : " +  cols);
		
		
		// Read the test data
		int dataRow = 0;
		Object[][] data = new Object[rows][1];
		Hashtable<String, String> table = null;
		for(int rNum = dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table = new Hashtable<String, String>(); 
			for(int cNum=0;cNum<cols;cNum++)
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
				//data[dataRow][cNum] = e.getCellData(sheetName, cNum, rNum);
				
				String key = e.getCellData(sheetName, cNum, colStartRowNum);
				String value = e.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		return data;
  }
}