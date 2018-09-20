package by.ruslan.automation.maven.test;

import org.testng.annotations.Test;

public class TestBrowser extends PrepareWebTest{
	
  @Test
  public void start() throws InterruptedException {
	  //The browser has just launched
	  int count = 5;
	  System.out.println("Closing the Browser in ,sec");
	  while(count-- >0) {
		  System.out.println(count);
		  Thread.sleep(1000);
	  }
  }
  
  
}
