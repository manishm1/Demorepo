package WebdriverScreenshots;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy4 
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://amazon.in");

		List<WebElement> link = driver.findElements(By.xpath("//div[@id=\"nav-xshop\"]/child::a"));
		for(int i=0; i<link.size();i++)
		{
			String linkname = link.get(i).getText();
			link.get(i).click();
			File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcfile, new File("C:\\Users\\manish\\Desktop\\Screnshot\\"+linkname+".png"));
			//link = driver.findElements(By.xpath("//div[@class=\"FPdoLc lJ9FBc\"]/center/input"));
		}
		
		
	}

}
