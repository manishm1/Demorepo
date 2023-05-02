package ExcelDataDriven;

public class Assignment1 
{
	public static void main(String[] args) throws Exception 
	{
		ExcelApi e = new ExcelApi("C:\\Users\\manish\\Desktop\\Test Data.xlsx");
		for(int i=1;i<e.getRowCount("student");i++)
		{
		 String val = e.getCellData("student", 1, i);
		 double d =Double.parseDouble(val);
		 if(d<18) 
		  	 e.setCellData("student", 2, i, "Minor");
		 else 
			 e.setCellData("student", 2, i, "Major");			 
		 
		}
	}

}
