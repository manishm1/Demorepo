package WebdriverScreenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy2 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		Date d = new Date();
//converting date to string for elimination of : and space (require for name in screenshot if u want no overridng)
		String dt=d.toString().replace(':', '_').replace(' ','_');
		
		List<WebElement> link = driver.findElements(By.linkText("Rajnikanth"));
		if (link.size()==0)
		{
			File srcfirle = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcfirle, new File("C:\\Users\\manish\\Desktop\\Screnshot\\google"+dt+".jpeg"));
		}
	}

}
