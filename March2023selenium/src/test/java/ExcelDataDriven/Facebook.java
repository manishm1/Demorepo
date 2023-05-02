package ExcelDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook 
{
	public static void main(String[] args) throws Exception 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		ExcelApi e = new ExcelApi("C:\\Users\\manish\\Desktop\\Test Data.xlsx");
		
		for(int i=1;i<e.getRowCount("login");i++)
		{
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(e.getCellData("login", 0, i));
			driver.findElement(By.name("pass")).clear();
			driver.findElement(By.name("pass")).sendKeys(e.getCellData("login", 1, i));
			
			Thread.sleep(1000);
		}
	}

}
