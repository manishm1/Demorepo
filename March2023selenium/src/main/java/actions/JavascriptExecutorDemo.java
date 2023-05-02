package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='manish'");
		String title = js.executeScript("return document.title").toString();	
		System.out.println(title);
		js.executeScript("window.scrollBy(0,100)");
		//for scroling till the end of page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//for scroling till particular emelent is visible
		js.executeScript("document.getElementById('u_0_5_PB').scrollIntoView()");
		//to navigate in webpage back/forward.refresh
		js.executeScript("window.history.back()");
		js.executeScript("window.history.forward()");
		js.executeScript("window.history.go(0)");
		
	}

}
