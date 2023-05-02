package selenium;

import org.apache.log4j.Logger;

public class Tc_003log4j extends BaseTest
{

	private static final Logger log = Logger.getLogger(Tc_003log4j.class);
	
	public static void main(String[] args) throws Exception 
	
	{
		init();
		log.info("init the properties file");
		
		launch("chromebrowser");
		log.info("Opened the Browser " + p.getProperty("chromebrowser") );
		
		navigateurl("amazonurl");
		log.info("Navigate to URL" + childprop.getProperty("amazonurl"));
		
		selectOption("amazonsearchbox_id","Books");
		log.info("click on the locator " + orprop.getProperty("amazonsearchbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		log.info("Enter the text using locator" + orprop.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on the element by using locator" +orprop.getProperty("amazonsearchbutton_xpath"));
		
		//driver.close();
	
	}
}
