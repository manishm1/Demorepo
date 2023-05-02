package testg;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import selenium.BaseTest;

public class LinkTesting1 extends BaseTest
{
	@BeforeMethod(groups={"Regression", "Smoke"})
	@Parameters("browser")
	public void setup(String bType) throws Exception
	{
		System.out.println("startProcess");
	    init();
		test = report.createTest("LinksTesting1");
		test.log(Status.PASS, "Initiating the Property Files...");
				
		launch(bType);
		test.log(Status.INFO, "Opened the Browser :- " + p.getProperty("chromebrowser"));
						
		navigateurl("googleurl");
		test.log(Status.PASS, "Navigated to app :-" + childprop.getProperty("googleurl"));
	}
	
	
	@Test(groups={"Regression"})
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Images")).click();	
		Reporter.log("Clicked on Image Link");
		String actval=driver.getTitle();
		
		Assert.assertEquals(actval, expval);
		
	 }
	
	@AfterMethod(groups={"Regression", "Smoke"})
	public void tearDown()
	{
		 System.out.println("endProcess");
		 report.flush();
		 driver.quit();
	}

}