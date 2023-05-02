package suiteB;

import org.testng.annotations.Test;

public class TestB2 
{
  @Test
  public void f() throws Exception 
  {
	  System.out.println("I am Starting B2");
	  Thread.sleep(3000);
	  System.out.println("I am Ending B2");
  }
}
