package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionBox 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Hadoop tutorial");
		String val = driver.findElement(By.name("q")).getAttribute("value");
		
		////ul[@class="G43f7e"][1]/li/div/div/div/div[1]/span
					
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.cssSelector("ul[jsname='bw4e9b'] div[class='wM6W7d']>span"));
		for(int i=0;i<list.size();i++)
		{
			if (list.get(i).getText().equalsIgnoreCase(val))
			{
				list.get(i).click();
				return;
			}
		}
	}
	
}
