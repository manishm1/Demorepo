package selenium;

import org.openqa.selenium.By;

public class TestcaseCloseDemo extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		init();
		launch("chromebrowser");
		navigateurl("amazonurl");
		driver.findElement(By.linkText("Mobiles")).click();
		driver.findElement(By.linkText("Apple")).click();
		//driver.findElement(By.linkText("Apple iPhone 13 (128GB) - Blue")).click();
		//driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).click();
		//driver.findElement(By.className("a-button a-spacing-small a-button-primary a-button-icon")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.id("submit.add-to-cart-announce")).click();
		
		closeBrowser();
		
		if (driver == null)
		{
			launch("chromebrowser");
			navigateurl("amazonurl");
			driver.findElement(By.linkText("Mobiles")).click();
			driver.findElement(By.linkText("OnePlus")).click();
			closeBrowser();
		}
	}

}
