// by default test execute Alphabetically by giving Priority we can change it
package testg;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestDependancy 
{
  @Test(priority=1)
  public void orange()
  {
	  System.out.println("Orange");
  }
  @Test(priority=2, dependsOnMethods = {"orange"})
  public void white()
  {
	  System.out.println("White");
  }
  @Test(priority=3,dependsOnMethods = {"white"})
  public void blue()
  {
	  System.out.println("Blue");
	 // Assert.fail("Blue Test is failed.."); /when fail the depending test will skip
	  throw new SkipException("Blue test is Skipped.."); // when skip then also depending test skip
  }
  @Test(priority=4,dependsOnMethods = {"blue"})
  public void green()
  {
	  System.out.println("Green");
  }
}
