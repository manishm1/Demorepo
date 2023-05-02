package selenium;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties p;
	public static FileInputStream fis;
	
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orprop;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void init() throws Exception
	{
		//System.getProperty("user.dir"); Dynamic path can work in any system if u shared the code e.g. check below 2 lines
		//FileInputStream fis = new FileInputStream("C:\\Users\\manish\\eclipse-workspace\\March2023selenium\\src\\main\\resources\\data.properties");
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\data.properties");
		
		p = new Properties();
		p.load(fis);
		//String str = p.getProperty("amazonurl");
		//System.out.println(str);
		
		fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\environment.properties");
		mainprop = new Properties();
		mainprop.load(fis);
		String e = mainprop.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\"+e+".properties");
		childprop = new Properties();
		childprop.load(fis);
		System.out.println(childprop.getProperty("amazonurl"));
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\or.properties");
		orprop = new Properties();
		orprop.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManager.getInstance();
				
	}
	public static void launch(String browser)
	{
		if(browser.equals("chrome")) // when using xml suite to pass thru @parameters
		//if(p.getProperty(browser).equals("chrome")) // when taking value from property file
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))// when using xml suite to pass thru @parameters
		//else if (p.getProperty(browser).equals("firefox"))// when taking value from property file
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equals("edge"))// when using xml suite to pass thru @parameters
		//else if (p.getProperty(browser).equals("edge"))// when taking value from property file
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(); 
		}
		else if (browser.equals("ie"))// when using xml suite to pass thru @parameters
		//else if (browser.equals("ie"))// when taking value from property file
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}
	
	public static void navigateurl(String url)
	{
		driver.get(p.getProperty(url));
		//driver.get(childprop.getProperty(url)); //get method always go to server and open the browser, only used for opening browser
		//driver.navigate().to(childprop.getProperty(url)); navigate 1st open thru server then onwards look into cach, can use for back,forward etc.
	}
	public static void clickElement(String locatorkey) 
	{
		getElement(locatorkey).click();
		
		//driver.findElement(By.xpath(orprop.getProperty(locatorkey))).click();
	}
	public static void typeText(String locatorkey, String text)
	{
		getElement(locatorkey).sendKeys(text);
		//driver.findElement(By.name(orprop.getProperty(locatorkey))).sendKeys(text);
	}
	public static void selectOption(String locatorkey, String option) 
	{
		getElement(locatorkey).sendKeys(option);
		//driver.findElement(By.id(orprop.getProperty(locatorkey))).sendKeys(option);
	}
	public static WebElement getElement(String locatorkey) 
	{
		WebElement element = null;
		
		//check for element present
		if (!isElementPresent(locatorkey))
			//report for failure
			System.out.println("Element is not present ");
		
		element = driver.findElement(getLocator(locatorkey)); 	
		
		/*if(locatorkey.endsWith("_id")){
			element = driver.findElement(By.id(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_name")) {
			element = driver.findElement(By.name(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_classname")){
			element = driver.findElement(By.className(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_css")){
			element = driver.findElement(By.cssSelector(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_linktext")){
			element = driver.findElement(By.linkText(orprop.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_partiallinktext")){
			element = driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey)));
		}*/
		
		return element;
	}
	public static boolean isElementPresent(String locatorkey)
	{
		System.out.println("checking for Element is presence" + locatorkey);
		WebDriverWait wait= new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
		
		/*if (locatorkey.endsWith("_id")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orprop.getProperty(locatorkey))));
		}else if (locatorkey.equals("_name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orprop.getProperty(locatorkey))));
		}else if (locatorkey.endsWith("_classname")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orprop.getProperty(locatorkey))));
		}else if (locatorkey.endsWith("_xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orprop.getProperty(locatorkey))));
		}else if(locatorkey.endsWith("_css")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orprop.getProperty(locatorkey))));
		}else if (locatorkey.endsWith("_linktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orprop.getProperty(locatorkey))));
		}else if (locatorkey.endsWith("_partiallinktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orprop.getProperty(locatorkey))));
		}*/
				
		return true;
	}
	
	public static By getLocator(String locatorkey)
	{
		By by = null;
		
			if(locatorkey.endsWith("_id")) {
				by = By.id(orprop.getProperty(locatorkey));
			}else if (locatorkey.endsWith("_name")) {
				by = By.name(orprop.getProperty(locatorkey));
			}else if (locatorkey.endsWith("_classname")) {
				by = By.className(orprop.getProperty(locatorkey));
			}else if (locatorkey.endsWith("_xpath")) {
				by = By.xpath(orprop.getProperty(locatorkey));
			}else if (locatorkey.endsWith("_css")) {
				by = By.cssSelector(orprop.getProperty(locatorkey));
			}else if (locatorkey.endsWith("_linktext")) {
				by = By.linkText(orprop.getProperty(locatorkey));
			}else if (locatorkey.endsWith("_partiallinktext")) {
				by = By.partialLinkText(orprop.getProperty(locatorkey));
			}
		return  by;
		
	}
	public static void closeBrowser()
	{
		driver.quit();
		driver = null;
	}
	
}
