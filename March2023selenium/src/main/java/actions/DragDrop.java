package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); //by locator 
		driver.switchTo().frame(0); //by index method 
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		 		 
		Actions a = new Actions(driver);
		//a.dragAndDrop(drag, drop).perform(); 
		a.clickAndHold(drag).moveToElement(drop).release().build().perform();//more then 1 action method we need to build and perform
	
		//right click on element
		driver.switchTo().defaultContent();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[4]/a"));
		a.contextClick(element).perform();
	
	}

}
