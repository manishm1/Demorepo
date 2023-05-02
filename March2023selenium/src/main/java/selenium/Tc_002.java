package selenium;

//import org.openqa.selenium.By;

public class Tc_002 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	
	{
		init();
		launch("chromebrowser");
		navigateurl("amazonurl");
		
		selectOption("amazonsearchbox_id","Books");
		typeText("amazonsearchtext_name","Harry Potter");
		clickElement("amazonsearchbutton_xpath");
		
		driver.close();
				
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	}

	
}