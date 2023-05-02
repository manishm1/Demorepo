package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.findElement(By.id("ap_email")).sendKeys("donhere");
		
		//driver.findElement(By.linkText("Mobiles")).click();
		//driver.navigate().forward();
		//driver.findElement(By.linkText("Apple")).click();
		//System.out.println(driver.getTitle());
		//driver.navigate().back();
		 
		//driver.close();
		//WebDriverManager.edgedriver().setup();
		//EdgeDriver driver1 = new EdgeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//FirefoxDriver driver2 = new FirefoxDriver();
	}

}
