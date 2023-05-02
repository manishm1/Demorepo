package selenium;

public class Tc_001 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		//launch("edge");
		launch("chromebrowser");
		//launch("ie");
		navigateurl("amazonurl");
		
		driver.manage().window().maximize();
		String title =driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		driver.navigate().refresh();
	
		//driver.close(); //close the current browser but not kill the driver
		//driver.quit(); //current the all browser opened by web driver and kill the driver
		
	}

}
