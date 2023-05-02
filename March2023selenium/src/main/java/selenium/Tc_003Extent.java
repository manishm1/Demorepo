package selenium;

import com.aventstack.extentreports.Status;

public class Tc_003Extent extends BaseTest
{
	
		
	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.createTest("Tc_003Extent");
		test.log(Status.INFO, "init the properties files...");
		
		launch("chromebrowser");
		test.log(Status.PASS, "Opened the Browser : " +  p.getProperty("chromebrowser"));
		
		navigateurl("amazonurl");
		test.log(Status.INFO, "Navigated to url : " + childprop.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selected the option Books By using Locator : " +orprop.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Entered the text Harry Potter By using the Locator : " + orprop.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.INFO, "Clicked on Element By Using Locator : " + orprop.getProperty("amazonsearchbutton_xpath"));
		
		report.flush();
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
	}

	

}
