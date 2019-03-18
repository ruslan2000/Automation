package by.ruslan.automation.maven.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.PageObject;

public class TestLinks extends PrepareWebTest{
	
	private PageObject page;

	@BeforeTest
	public void init() {
		page = new PageObject(driver);
	}
	
	@Test
	public void test() {
		page.openHomePage("https://ticketmonster.com/");
		
		page.findBrokenLinks();
	}
	
}
