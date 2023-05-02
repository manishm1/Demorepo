package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		Actions a = new Actions(driver);
		
		WebElement drag = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		//a.dragAndDropBy(drag, 300, 0).perform();
		a.clickAndHold(drag).moveByOffset(200, 0).release().build().perform();
		
	}

}
