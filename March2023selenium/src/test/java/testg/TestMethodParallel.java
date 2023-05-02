package testg;

import org.testng.annotations.Test;

public class TestMethodParallel 
{
  @Test
  public void test1() 
  {
	  System.out.println("I am test 1 :"  +  Thread.currentThread().getId());
  }
  @Test
  public void test2() 
  {
	  System.out.println("I am test 2 :" + Thread.currentThread().getId());
  }
  @Test
  public void test3() 
  {
	  System.out.println("I am test 3 :" + Thread.currentThread().getId());
  }
  @Test
  public void test4() 
  {
	  System.out.println("I am test 4 :" + Thread.currentThread().getId());
  }
  @Test
  public void test5() 
  {
	  System.out.println("I am test 5 :" + Thread.currentThread().getId());
  }
  @Test
  public void test6() 
  {
	  System.out.println("I am test 6 :" + Thread.currentThread().getId());
  }
  @Test
  public void test7() 
  {
	  System.out.println("I am test 7 :" + Thread.currentThread().getId());
  }
}
