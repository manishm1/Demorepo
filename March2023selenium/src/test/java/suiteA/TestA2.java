package suiteA;

import org.testng.annotations.Test;

public class TestA2 {
  @Test
  public void f() throws Exception
  {
	  System.out.println("I am Starting A2");
	  Thread.sleep(3000);
	  System.out.println("I am Ending A2");
  }
}
