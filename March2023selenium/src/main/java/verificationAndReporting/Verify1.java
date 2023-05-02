package verificationAndReporting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		
		driver.findElement(By.id("id=\"twotabsearchtextbox\"")).sendKeys("Sony");
		//to get the dynamic value of element use get attribute - "value"
		String val=driver.findElement(By.id("id=\"twotabsearchtextbox\"")).getAttribute("value");
	}

}
