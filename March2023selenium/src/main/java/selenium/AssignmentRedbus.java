package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentRedbus
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("src")).sendKeys("Miyapur, Hyderabad");
		String sourceVal = driver.findElement(By.id("src")).getAttribute("value");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class=\"autoFill homeSearch\"]/li"));
		for(int i=0;i<list.size();i++)
		{
			if (list.get(i).getText().equalsIgnoreCase(sourceVal))
			{
				list.get(i).click();
				return; 
			}
		}
		
		/*driver.findElement(By.id("dest")).sendKeys("Miyapur, Hyderabad");
		String destVal = driver.findElement(By.id("dest")).getAttribute("value");
		
		
		if (sourceVal == destVal)
		{
			driver.findElement(By.id("dest")).sendKeys("cant be same as source");
		}
		

		
	
		/*driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		for(int i=1;i<=2;i++)
		{
			driver.findElement(By.xpath("//td[@class='next']")).click();
		}
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[7]/td")).click();*/
	}
}
