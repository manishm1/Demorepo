package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentGoibibo 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]")).click();
		//driver.findElement(By.cssSelector("span[class='logSprite icClose']")).click();
		//driver.findElement(By.cssSelector("body[class='desktop']>div>div>div>div>div>div>div>p>span")).click();
		//driver.findElement(By.cssSelector("body[class='desktop'] span[class='sc-iwjdpV jUsACy fswDownArrow']")).click();
		driver.findElement(By.xpath("//span[@class=\"sc-dvQaRk fchrvX fswDownArrow\"]")).click();
		
		//WebElement monthName =  driver.findElement(By.xpath("//*[@class=\"DayPicker-Caption\"]/div[contains(text(), 'August')]"));
		WebElement monthName =  driver.findElement(By.xpath("//div[@class=\"DayPicker-Caption\"]/div[contains(text(), 'August')]"));
		String name = monthName.getText();
		System.out.println(name);
		
		driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();
			
		
//		for(int i=1;i<=4;i++)
//		{
//			driver.findElement(By.cssSelector("div[class='DayPicker-NavBar']>span[class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
//		}
		//driver.findElement(By.cssSelector("body[class='desktop'] div[class='DayPicker-Month']:last-child div[class='DayPicker-Body'] div[class='DayPicker-Week']:nth-child(3)>div:nth-child(3)")).click();
		driver.findElement(By.cssSelector("body[class='desktop'] div[class='DayPicker-Month']:last-child div[class='DayPicker-Week']:nth-child(3) div[class='DayPicker-Day']:nth-child(3)")).click();
		//driver.close();
	}

}
