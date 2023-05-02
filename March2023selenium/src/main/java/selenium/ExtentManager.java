package selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BaseTest
{
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReport;
	
	public static ExtentReports getInstance()
	{
		if(htmlReport==null)
		{
			htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"//Reports//report.html");
			htmlReport.config().setDocumentTitle("AUtomation Report");
			htmlReport.config().setReportName("Functional Report");
			htmlReport.config().setTheme(Theme.DARK);
			
			report = new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("TesterName", "Manish");
			report.setSystemInfo("Browser", "Chrome");
		}
		
		return report;
	}
	
}

