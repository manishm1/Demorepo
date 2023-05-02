package testg;

import java.util.Arrays;

import org.testng.TestNG;

public class RunSuiteParallel 
{
	public static void main(String[] args) 
	{
		/*String[] s = new String[2];//array declaration 3 ways
		String[] s1 = {"1","2","3"};
		String[] s2 = new String[] {"1","2","3"};*/
		
		TestNG obj = new TestNG();
		obj.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+"//megasuite.xml"}));
		obj.setSuiteThreadPoolSize(2);
		obj.run();		
	}

}
