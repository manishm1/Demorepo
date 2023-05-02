//java script alert handling
package actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling 
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.demo.guru99.com/selenium/delete_customer.php");
		
		driver.findElement(By.name("cusid")).sendKeys("45678");
		driver.findElement(By.name("submit")).click();
		
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();
		
	}

}
