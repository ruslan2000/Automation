package by.ruslan.automation.maven.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.PageObject;

public class TestImages extends PrepareWebTest{
	
	
	private PageObject page;
	
	@BeforeTest
	public void init() {
		page = new PageObject(driver);
	}
	
	@Test
	public void test() {
		String URL = "https://dev-us.pandora.net/en/gifts/gifts-for-daughters/";
		page.openHomePage(URL);
		
		page.showNoImages();
	}

}
