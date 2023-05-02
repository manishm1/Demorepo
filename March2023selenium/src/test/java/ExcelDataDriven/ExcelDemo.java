package ExcelDataDriven;

public class ExcelDemo 
{
	public static void main(String[] args) throws Exception
	{
		ExcelApi e = new ExcelApi("C:\\Users\\manish\\Desktop\\Test Data.xlsx");
		
		System.out.println(e.getRowCount("login"));
		System.out.println(e.columnCount("login"));
		
		System.out.println(e.getCellData("login", 2, 2));
		System.out.println(e.getCellData("login", 3, 2));
		e.setCellData("login", 4,3,"Aboreted");
			
	}

}
